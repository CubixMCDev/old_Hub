package eu.cubix.mc.hub.events;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.task.AntiAFK;
import eu.cubix.mc.hub.tools.*;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

public class PlayerEvent implements Listener {

    private final Main main;

    public PlayerEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Title titlePrison = new Title("§4Vous êtes banni","§cQuel dommage!");
        Title title = new Title("§6Bienvenue","§eBon jeu!");
        ActionBar actionBar = new ActionBar("§cLe serveur est en phase de développement.");
        Player player = e.getPlayer();
        Inventory inv = player.getInventory();
        Location spawn = new Location(Bukkit.getServer().getWorld("Hub"), 110.5, 16, 772.5, 180, 0);
        Location prison = new Location(Bukkit.getServer().getWorld("Hub"), 145, 3, 756, 0, 0);

        main.getScoreboardManager().onLogin(player);
        //if(!main.bar.getBar().getPlayers().contains(e.getPlayer())) {
            //main.bar.addPlayer(e.getPlayer());
    //}

        e.getPlayer().getInventory().setHeldItemSlot(4);

        if(player.hasPermission("joinquit.message") || player.hasPermission("*")) {
            e.setJoinMessage("§e" + main.getAPI().get().getRankWithColors(player.getUniqueId()) + "§8\u2758§r " + player.getName() + " §6a rejoint le hub !");
        } else {
            e.setJoinMessage("");
        }

        player.sendMessage("\n \n ");

        if(main.getAPI().getBanManager().isBanned(player.getUniqueId())) {
            player.teleport(prison);
            player.sendMessage("§cCubixMC §4» §cErreur: vous êtes banni §4"+"un temps"+"§c.");

            titlePrison.send(player,1,7,1);

            ItemsBuilder ban = new ItemsBuilder(Material.BARRIER).setName("§4Vous êtes banni").setLore("§cQuel dommage!");
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

                ItemsBuilder profil = new ItemsBuilder(Material.SKULL_ITEM, 1, (byte) 3).setName("§6Profil").setLore("§eClic droit").setSkullOwner(player.getName());
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

            title.send(player,1,7,1);
            actionBar.send(player);

            Hologram hologram = new Hologram("§6§lVotre profil",
                    "§8§m---------------------------",
                    "§6Pseudo : §e"+player.getName(),
                    "§6Grade : §e"+ main.getAPI().get().getRankWithColors(player.getUniqueId()),
                    "§6Crédits : §e" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                    "§6Coins : §e"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                    "§6Temps de jeu : §e"+"0 minutes §c(Soon)",
                    "§6Niveau : §e"+main.getAPI().get().getLevel(player.getUniqueId())+" §6(§e"+main.getAPI().get().getExp(player.getUniqueId())+" Exp.§6)",
                    "§6Progression : §e"+"§6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+"0%",
                    "§8§m---------------------------");
            hologram.show(player, new Location(player.getWorld(),110.5,15.5,765.5));

            Hologram hologram2 = new Hologram("§6Caisse", "§eClé de vote");
            hologram2.show(player, new Location(player.getWorld(),103.5,16,765.5));

            player.setAllowFlight(player.hasPermission("fly.hub") || player.hasPermission("*"));
        }

        player.setHealth(2.0);
        player.setMaxHealth(2.0);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1f, 1f);

        if(!player.hasPermission("antiafk.bypass") || player.hasPermission("*")) {
            AntiAFK antiAFK = new AntiAFK(player, player.getLocation().getBlock());
            main.getAntiAFK().put(player, antiAFK);
            antiAFK.runTaskTimer(main, 0L, 20L);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        ParticleData particle = new ParticleData(player.getUniqueId());

        if(player.hasPermission("joinquit.message") || player.hasPermission("*")) {
            e.setQuitMessage("§e" + main.getAPI().get().getRankWithColors(player.getUniqueId()) + "§8\u2758§r " + player.getName() + " §6a quitté le hub !");
        } else {
            e.setQuitMessage("");
        }

        if(particle.hasID()) {
            particle.endTask();
            particle.removeID();
        }

        if(main.getAntiAFK().containsKey(player)){
            main.getAntiAFK().remove(player);
        }

        main.getScoreboardManager().onLogout(player);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        main.getAntiAFKTime().put(player, 900);
    }
}
