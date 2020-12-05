package eu.cubix.mc.hub.events;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.task.AntiAFK;
import eu.cubix.mc.hub.task.JoinTask;
import eu.cubix.mc.hub.tools.*;
import eu.cubixmc.com.data.User;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

public class PlayerEvent implements Listener {

    private final Main main;
    private ActionBar actionBar;

    public PlayerEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Title titlePrison = new Title("§4Vous êtes banni","§cQuel dommage!");
        Title title = new Title("§6Bienvenue","§eBon jeu!");
        Player player = e.getPlayer();
        Inventory inv = player.getInventory();
        Location spawn = new Location(Bukkit.getServer().getWorld("Hub"), 110.5, 16, 772.5, 180, 0);
        Location prison = new Location(Bukkit.getServer().getWorld("Hub"), 145, 3, 756, 0, 0);

        e.setJoinMessage("");

        main.getScoreboardManager().onLogin(player);

        e.getPlayer().getInventory().setHeldItemSlot(4);

        player.sendMessage("\n \n ");

        player.setHealth(2.0);
        player.setMaxHealth(2.0);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1f, 1f);

        if(main.getAPI().getBanManager().isBanned(player.getUniqueId())) {
            player.teleport(prison);
            player.sendMessage(main.prefix+ChatColor.RED+"Erreur: vous êtes banni "+ChatColor.DARK_RED+"un temps"+ChatColor.RED+".");

            titlePrison.send(player,1,7,1);

            ItemsBuilder ban = new ItemsBuilder(Material.BARRIER).setName(ChatColor.DARK_RED+"Vous êtes banni").setLore(ChatColor.RED+"Quel dommage!");
            inv.setItem(0,ban.toItemStack());
            inv.setItem(1,ban.toItemStack());
            inv.setItem(2,ban.toItemStack());
            inv.setItem(3,ban.toItemStack());
            inv.setItem(4,ban.toItemStack());
            inv.setItem(5,ban.toItemStack());
            inv.setItem(6,ban.toItemStack());
            inv.setItem(7,ban.toItemStack());
            inv.setItem(8,ban.toItemStack());
        } else {
            if(!main.getAPI().getModManager().isInMod(player.getUniqueId())) {
                inv.clear();

                ItemsBuilder profil = new ItemsBuilder(Material.SKULL_ITEM, 1, (byte) 3).setName(ChatColor.GOLD+"Profil").setLore(ChatColor.YELLOW+"Clic droit").setSkullOwner(player.getName());
                inv.setItem(0,profil.toItemStack());
                ItemsBuilder menu = new ItemsBuilder(Material.COMPASS).setName("§6Menu").setLore("§eClic droit");
                inv.setItem(3,menu.toItemStack());
                if(main.getAPI().getPartyManager().isInParty(String.valueOf(player))) {
                    ItemsBuilder joinLeaderParty = new ItemsBuilder(Material.FLINT).setName("§6Rejoindre le chef de groupe").setLore("§eClic droit");
                    inv.setItem(4,joinLeaderParty.toItemStack());
                }
                ItemsBuilder cosmetiques = new ItemsBuilder(Material.ENDER_CHEST).setName("§6Cosmétiques").setLore("§eClic droit");
                inv.setItem(5,cosmetiques.toItemStack());
                ItemsBuilder boutique = new ItemsBuilder(Material.GOLD_INGOT).setName("§6Boutique").setLore("§eClic droit");
                inv.setItem(8,boutique.toItemStack());
            }

            player.teleport(spawn);

            JoinTask task = new JoinTask(main, player);
            task.runTaskTimer(main, 0, 1);

            title.send(player,1,7,1);
            actionBar.sendActionBarMessage(player, ChatColor.GOLD+"Bon jeu sur notre serveur !", 5, main);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        ParticleData particle = new ParticleData(player.getUniqueId());

        e.setQuitMessage("");


        if(particle.hasID()) {
            particle.endTask();
            particle.removeID();
        }

        main.getAntiAFK().remove(player);
        main.getScoreboardManager().onLogout(player);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        User user = main.getAPI().getUserManager().getUser(player.getUniqueId());
        String message = e.getMessage();

        if(!player.hasPermission("staff.use") || !player.hasPermission("*")) {
            AntiAFK antiAFK = new AntiAFK(player, player.getLocation().getBlock());
            main.getAntiAFK().put(player, antiAFK);
        }

        if(player.hasPermission("staff.use")) {
            e.setFormat(user.getRankToStringWithColor()+ChatColor.DARK_GRAY+" \u2758 "+ChatColor.RESET+ main.getAPI().get().getRankColor(player.getUniqueId()) + player.getName() + ChatColor.DARK_GRAY+" » "+ChatColor.RESET+ message);

        } else if(player.hasPermission("vipplus.use")){
            e.setFormat(ChatColor.GOLD+"VIP+"+ChatColor.DARK_GRAY+" \u2758 "+ChatColor.GOLD + player.getName() + ChatColor.DARK_GRAY+" » "+ChatColor.RESET+ message);

        } else if(player.hasPermission("vip.use")){
            e.setFormat(ChatColor.YELLOW+"VIP"+ChatColor.DARK_GRAY+" \u2758 "+ChatColor.YELLOW + player.getName() + ChatColor.DARK_GRAY+" » "+ChatColor.RESET+ message);
        } else {
            e.setFormat(ChatColor.GRAY+player.getName() + ChatColor.DARK_GRAY+" » "+ChatColor.GRAY+ message);
        }
    }
}
