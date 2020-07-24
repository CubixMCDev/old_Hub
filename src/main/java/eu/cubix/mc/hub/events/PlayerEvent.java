package eu.cubix.mc.hub.events;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.pets.Pet;
import eu.cubix.mc.hub.task.AntiAFK;
import eu.cubix.mc.hub.tools.*;
import org.bukkit.*;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import java.lang.Math;
import java.util.UUID;

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
        UUID uuid = player.getUniqueId();
        Location spawn = new Location(Bukkit.getServer().getWorld("Hub"), 110.5, 16, 772.5, 180, 0);
        Location prison = new Location(Bukkit.getServer().getWorld("Hub"), 145, 3, 756, 0, 0);
        double pourcent = (double) Main.api.getExpManager().getExp(player.getUniqueId()) / (double) Main.api.getExpManager().getXPfromLevel(Main.api.getExpManager().getLevel(player.getUniqueId()));

        Main.getInstance().getScoreboardManager().onLogin(player);
        //if(!Main.getInstance().bar.getBar().getPlayers().contains(e.getPlayer())) {
            //Main.getInstance().bar.addPlayer(e.getPlayer());
    //}

        e.getPlayer().getInventory().setHeldItemSlot(4);

        if( Main.api.getRankManager().getRank(player).getPower() >= 10) {
            e.setJoinMessage("§e" + Main.api.getRankManager().getRank(player).getTagColor() + Main.api.getRankManager().getRank(player).getNameTag() + "§8\u2758§r " + Main.api.getRankManager().getRank(player).getTagColor() + player.getName() + " §6a rejoint le hub !");
        } else {
            e.setJoinMessage("");
        }

        player.sendMessage("\n \n ");

        if(Main.api.banned.containsKey(uuid)) {
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
            if(!Main.api.getModManager().isInMod(player.getUniqueId())) {
                inv.clear();

                ItemsBuilder profil = new ItemsBuilder(Material.SKULL_ITEM, 1, (byte) 3).setName("§6Profil").setLore("§eClic droit").setSkullOwner(player.getName());
                inv.setItem(0,profil.toItemStack());
                ItemsBuilder menu = new ItemsBuilder(Material.COMPASS).setName("§6Menu").setLore("§eClic droit");
                inv.setItem(3,menu.toItemStack());
                if(Main.api.getPartyManager().isInParty(String.valueOf(player))) {
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

            Hologram hologram = new Hologram("§6§lVotre profil", "§8§m---------------------------", "§6Pseudo : §e"+player.getName(), "§6Grade : §e"+Main.api.getRankManager().getRank(player).getTagColor() + Main.api.getRankManager().getRank(player).getNameTag().replaceAll(" ",""), "§6Crédits : §e"+Main.api.getEcoManager().getBalanceCredits(player) + " \u24D2", "§6Coins : §e"+Main.api.getEcoManager().getBalanceCoins(player) + " \u26C3", "§6Temps de jeu : §e"+"0 minutes §c(Soon)", "§6Niveau : §e"+Main.api.getExpManager().getLevel(player.getUniqueId())+" §6(§e"+Main.api.getExpManager().getExp(player.getUniqueId())+" Exp.§6)", "§6Progression : §e"+"§6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+Math.floor(pourcent)+"%", "§8§m---------------------------");
            hologram.show(player, new Location(player.getWorld(),110.5,15.5,765.5));

            Hologram hologram2 = new Hologram("§6Caisse", "§eClé de vote");
            hologram2.show(player, new Location(player.getWorld(),103.5,16,765.5));

            player.setAllowFlight(Main.api.getRankManager().getRank(player).getPower() >= 60);
        }

        player.setHealth(2.0);
        player.setMaxHealth(2.0);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1f, 1f);

        if( Main.api.getRankManager().getRank(player).getPower() <= 50) {
            AntiAFK antiAFK = new AntiAFK(player, player.getLocation().getBlock());
            main.getAntiAFK().put(player, antiAFK);
            antiAFK.runTaskTimer(main, 0L, 20L);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        ParticleData particle = new ParticleData(player.getUniqueId());

        if(Main.api.getRankManager().getRank(player).getPower() >= 10) {
            e.setQuitMessage("§e" + Main.api.getRankManager().getRank(player).getTagColor() + Main.api.getRankManager().getRank(player).getNameTag() + "§8\u2758§r " + Main.api.getRankManager().getRank(player).getTagColor() + player.getName() + " §6a quitté le hub !");
        } else {
            e.setQuitMessage("");
        }

        if(Main.Pets.containsKey(player.getName())){
            Main.Pets.get(player.getName()).remove();
        }

        if(particle.hasID()) {
            particle.endTask();
            particle.removeID();
        }

        if(main.getAntiAFK().containsKey(player)){
            main.getAntiAFK().remove(player);
        }

        Main.getInstance().getScoreboardManager().onLogout(player);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player player = e.getPlayer();

        if(Main.Pets.containsKey(player.getName())){
            new Pet().followPlayer((Creature) Main.Pets.get(player.getName()), player, 1.3);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        main.getAntiAFKTime().put(player, 900);
    }
}
