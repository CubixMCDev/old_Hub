package eu.cubix.mc.hub.events;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.task.AntiAFK;
import eu.cubix.mc.hub.tools.*;
import eu.cubixmc.com.data.User;
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
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

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
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        Location spawn = new Location(Bukkit.getServer().getWorld("Hub"), 110.5, 16, 772.5, 180, 0);
        Location prison = new Location(Bukkit.getServer().getWorld("Hub"), 145, 3, 756, 0, 0);
        User user = main.getAPI().getUserManager().getUser(player.getUniqueId());

        Team Admin = sb.getTeam("aadmin");
        if(Admin == null) {
            Admin = sb.registerNewTeam("aadmin");
        }
        Team Developer = sb.getTeam("bdeveloper");
        if(Developer == null) {
            Developer = sb.registerNewTeam("bdeveloper");
        }
        Team RespMod = sb.getTeam("cresp_mod");
        if(RespMod == null) {
            RespMod = sb.registerNewTeam("cresp_mod");
        }
        Team Moderator = sb.getTeam("dmoderator");
        if(Moderator == null) {
            Moderator = sb.registerNewTeam("dmoderator");
        }
        Team Helper = sb.getTeam("0003Helper");
        if(Helper == null) {
            Helper = sb.registerNewTeam("0003Helper");
        }
        Team Builder = sb.getTeam("fbuilder");
        if(Builder == null) {
            Builder = sb.registerNewTeam("fbuilder");
        }
        Team Partner = sb.getTeam("gpartner");
        if(Partner == null) {
            Partner = sb.registerNewTeam("gpartner");
        }
        Team Friend = sb.getTeam("hfriend");
        if(Friend == null) {
            Friend = sb.registerNewTeam("hfriend");
        }
        Team Youtuber = sb.getTeam("iyoutuber");
        if(Youtuber == null) {
            Youtuber = sb.registerNewTeam("iyoutuber");
        }
        Team VipPlus = sb.getTeam("jvip+");
        if(VipPlus == null) {
            VipPlus = sb.registerNewTeam("jvip+");
        }
        Team Vip = sb.getTeam("kvip");
        if(Vip == null) {
            Vip = sb.registerNewTeam("kvip");
        }
        Team Player = sb.getTeam("lplayer");
        if(Player == null) {
            Player = sb.registerNewTeam("lplayer");
        }
        Admin.setPrefix("§cAdmin ");
        Developer.setPrefix("§9Developer ");
        RespMod.setPrefix("§cR. Mod ");
        Moderator.setPrefix("§3Mod ");
        Helper.setPrefix("§bHelper ");
        Builder.setPrefix("§2Builder ");
        Partner.setPrefix("§6Partner ");
        Friend.setPrefix("§fFriend ");
        Youtuber.setPrefix("§6Ytb ");
        VipPlus.setPrefix("§6VIP+ ");
        Vip.setPrefix("§eVIP ");
        Player.setPrefix(ChatColor.GRAY+"");

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("admin")) {
                Admin.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("developer")) {
                Developer.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("resp_mod")) {
                RespMod.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("moderator")) {
                Moderator.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("helper")) {
                Helper.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("builder")) {
                Builder.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("partner")) {
                Partner.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("friend")) {
                Friend.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("youtuber")) {
                Youtuber.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("vip+")) {
                VipPlus.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("vip")) {
                Vip.addPlayer(p);
            } else if(main.getAPI().get().getRankID(p.getUniqueId()).equalsIgnoreCase("player")) {
                Player.addPlayer(p);
            }
        }

        main.getScoreboardManager().onLogin(player);
        //if(!main.bar.getBar().getPlayers().contains(e.getPlayer())) {
            //main.bar.addPlayer(e.getPlayer());
    //}

        e.getPlayer().getInventory().setHeldItemSlot(4);

        player.sendMessage("\n \n ");

        player.setHealth(2.0);
        player.setMaxHealth(2.0);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1f, 1f);

        if(player.hasPermission("joinquit.message") || player.hasPermission("*")) {
            e.setJoinMessage(main.getAPI().get().getRankWithColors(player.getUniqueId())+ChatColor.DARK_GRAY+" \u2758 "+ChatColor.RESET+ main.getAPI().get().getRankColor(player.getUniqueId()) + player.getName()+ChatColor.GOLD+" a rejoint le hub !");
        } else {
            e.setJoinMessage("");
        }

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

            Hologram hologram2 = new Hologram("§6§lCaisse",
                    "§8§m--------------",
                    "§eClé de vote",
                    "§8§m--------------");
            hologram2.show(player, new Location(player.getWorld(),103.5,16,765.5));

            player.setAllowFlight(player.hasPermission("fly.hub") || player.hasPermission("*"));
        }

        if(!player.hasPermission("antiafk.bypass") || player.hasPermission("*")) {
            AntiAFK antiAFK = new AntiAFK(player, player.getLocation().getBlock());
            main.getAntiAFK().put(player, antiAFK);
            antiAFK.runTaskTimer(main, 0L, 20L);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        User user = main.getAPI().getUserManager().getUser(player.getUniqueId());
        ParticleData particle = new ParticleData(player.getUniqueId());

        if(player.hasPermission("joinquit.message") || player.hasPermission("*")) {
            e.setQuitMessage(main.getAPI().get().getRankWithColors(player.getUniqueId())+ChatColor.DARK_GRAY+" \u2758 "+main.getAPI().get().getRankColor(player.getUniqueId())+player.getName() + " §6a quitté le hub !");
        } else {
            e.setQuitMessage("");
        }

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

        if(player.hasPermission("rank.messagesyntax") || player.hasPermission("*")) {
            e.setFormat(user.getRankToStringWithColor()+ChatColor.DARK_GRAY+" \u2758 "+ChatColor.RESET+ main.getAPI().get().getRankColor(player.getUniqueId()) + player.getName() + ChatColor.DARK_GRAY+" » "+ChatColor.RESET+ message);
        } else {
            e.setFormat(ChatColor.GRAY+player.getName() + ChatColor.DARK_GRAY+" » "+ChatColor.GRAY+ message);
        }

        main.getAntiAFKTime().put(player, 900);
    }
}
