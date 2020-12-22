package eu.cubix.mc.hub.task;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.Hologram;
import eu.cubixmc.com.data.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class JoinTask extends BukkitRunnable {

    private final Main main;
    private final Player player;

    int timer = 1;

    public JoinTask(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    @Override
    public void run() {
        if(timer == 0) {
            User user = main.getAPI().getUserManager().getUser(player.getUniqueId());
            Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();

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
            Team Helper = sb.getTeam("ehelper");
            if(Helper == null) {
                Helper = sb.registerNewTeam("ehelper");
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

            Admin.setPrefix(ChatColor.RED+"Admin ");
            Developer.setPrefix(ChatColor.BLUE+"Developer ");
            RespMod.setPrefix(ChatColor.RED+"R. Mod ");
            Moderator.setPrefix(ChatColor.DARK_AQUA+"Moderator ");
            Helper.setPrefix(ChatColor.AQUA+"Helper ");
            Builder.setPrefix(ChatColor.DARK_GREEN+"Builder ");
            Partner.setPrefix(ChatColor.GOLD+"Partner ");
            Friend.setPrefix(ChatColor.WHITE+"Friend ");
            Youtuber.setPrefix(ChatColor.GOLD+"YouTuber ");
            VipPlus.setPrefix(ChatColor.GOLD+"VIP+ ");
            Vip.setPrefix(ChatColor.YELLOW+"VIP ");
            Player.setPrefix(ChatColor.GRAY+"");

            if(player.hasPermission("staff.use") || player.hasPermission("*") || player.hasPermission("friend.use") || player.hasPermission("partner.use") || player.hasPermission("youtuber.use")) {
                if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("admin") && player.isOp()) {
                    Admin.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("developer")) {
                    Developer.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("resp_mod")) {
                    RespMod.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("moderator")) {
                    Moderator.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("helper")) {
                    Helper.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("builder")) {
                    Builder.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("partner")) {
                    Partner.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("friend")) {
                    Friend.addPlayer(player);
                } else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("youtuber")) {
                    Youtuber.addPlayer(player);
                }
            } else if(player.hasPermission("vipplus.use")){
                VipPlus.addPlayer(player);
            } else if(player.hasPermission("vip.use")){
                Vip.addPlayer(player);
            } else {
                Player.addPlayer(player);
            }

            if(player.hasPermission("staff.use") || player.hasPermission("friend.use") || player.hasPermission("partner.use") || player.hasPermission("youtuber.use")) {
                Bukkit.broadcastMessage(user.getRankToStringWithColor() + ChatColor.DARK_GRAY + " \u2758 " + main.getAPI().get().getRankColor(player.getUniqueId()) + player.getName() + " §6a rejoint le hub !");

            } else if(player.hasPermission("vipplus.use")){
                Bukkit.broadcastMessage(ChatColor.GOLD+"VIP+"+ChatColor.DARK_GRAY+" \u2758 " + ChatColor.GOLD + player.getName() + " §6a rejoint le hub !");
            } else if(player.hasPermission("vip.use")){
                Bukkit.broadcastMessage(ChatColor.YELLOW+"VIP"+ChatColor.DARK_GRAY+" \u2758 " + ChatColor.YELLOW + player.getName() + " §6a rejoint le hub !");
            }

            if(player.hasPermission("fly.hub") || player.hasPermission("*")) player.setAllowFlight(true);

            if(player.hasPermission("staff.use") && player.hasPermission("vipplus.use") || player.hasPermission("friend.use") && player.hasPermission("vipplus.use") || player.hasPermission("partner.use") && player.hasPermission("vipplus.use") || player.hasPermission("youtuber.use") && player.hasPermission("vipplus.use")) {
                Hologram hologram11 = new Hologram("§6§lVotre profil",
                        "§8§m---------------------------",
                        "§6Pseudo : §e"+player.getName(),
                        "§6Grade : §e"+ main.getAPI().get().getRankWithColors(player.getUniqueId())+ ChatColor.GRAY+"/"+ChatColor.GOLD+"VIP+",
                        "§6Crédits : §e" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                        "§6Coins : §e"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                        "§6Temps de jeu : §e"+"0 minutes §c(Soon)",
                        "§6Niveau : §e"+main.getAPI().get().getLevel(player.getUniqueId())+" §6(§e"+main.getAPI().get().getExp(player.getUniqueId())+" Exp.§6)",
                        "§6Progression : §e"+"§6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+"0%",
                        "§8§m---------------------------");
                hologram11.show(player, new Location(player.getWorld(),110.5,15.5,765.5));

            } else if(player.hasPermission("staff.use") && player.hasPermission("vip.use") || player.hasPermission("friend.use") && player.hasPermission("vip.use") || player.hasPermission("partner.use") && player.hasPermission("vip.use") || player.hasPermission("youtuber.use") && player.hasPermission("vip.use")) {
                Hologram hologram22 = new Hologram("§6§lVotre profil",
                        "§8§m---------------------------",
                        "§6Pseudo : §e"+player.getName(),
                        "§6Grade : §e"+ main.getAPI().get().getRankWithColors(player.getUniqueId())+ChatColor.YELLOW+"/"+ChatColor.GOLD+"VIP",
                        "§6Crédits : §e" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                        "§6Coins : §e"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                        "§6Temps de jeu : §e"+"0 minutes §c(Soon)",
                        "§6Niveau : §e"+main.getAPI().get().getLevel(player.getUniqueId())+" §6(§e"+main.getAPI().get().getExp(player.getUniqueId())+" Exp.§6)",
                        "§6Progression : §e"+"§6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+"0%",
                        "§8§m---------------------------");
                hologram22.show(player, new Location(player.getWorld(),110.5,15.5,765.5));

            } else if(player.hasPermission("vipplus.use")){
                Hologram hologram33 = new Hologram("§6§lVotre profil",
                        "§8§m---------------------------",
                        "§6Pseudo : §e"+player.getName(),
                        "§6Grade : §e"+ChatColor.GOLD+"VIP+",
                        "§6Crédits : §e" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                        "§6Coins : §e"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                        "§6Temps de jeu : §e"+"0 minutes §c(Soon)",
                        "§6Niveau : §e"+main.getAPI().get().getLevel(player.getUniqueId())+" §6(§e"+main.getAPI().get().getExp(player.getUniqueId())+" Exp.§6)",
                        "§6Progression : §e"+"§6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+"0%",
                        "§8§m---------------------------");
                hologram33.show(player, new Location(player.getWorld(),110.5,15.5,765.5));

            } else if(player.hasPermission("vip.use")){
                Hologram hologram44 = new Hologram("§6§lVotre profil",
                        "§8§m---------------------------",
                        "§6Pseudo : §e"+player.getName(),
                        "§6Grade : §e"+ChatColor.YELLOW+"VIP",
                        "§6Crédits : §e" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                        "§6Coins : §e"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                        "§6Temps de jeu : §e"+"0 minutes §c(Soon)",
                        "§6Niveau : §e"+main.getAPI().get().getLevel(player.getUniqueId())+" §6(§e"+main.getAPI().get().getExp(player.getUniqueId())+" Exp.§6)",
                        "§6Progression : §e"+"§6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+"0%",
                        "§8§m---------------------------");
                hologram44.show(player, new Location(player.getWorld(),110.5,15.5,765.5));
            } else {
                Hologram hologram55 = new Hologram("§6§lVotre profil",
                        "§8§m---------------------------",
                        "§6Pseudo : §e"+player.getName(),
                        "§6Grade : §e"+ main.getAPI().get().getRankWithColors(player.getUniqueId()),
                        "§6Crédits : §e" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                        "§6Coins : §e"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                        "§6Temps de jeu : §e"+"0 minutes §c(Soon)",
                        "§6Niveau : §e"+main.getAPI().get().getLevel(player.getUniqueId())+" §6(§e"+main.getAPI().get().getExp(player.getUniqueId())+" Exp.§6)",
                        "§6Progression : §e"+"§6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+"0%",
                        "§8§m---------------------------");
                hologram55.show(player, new Location(player.getWorld(),110.5,15.5,765.5));
            }

            Hologram hologram2 = new Hologram("§6§lCaisse",
                    "§8§m--------------",
                    "§eClé de vote",
                    "§8§m--------------");
            hologram2.show(player, new Location(player.getWorld(),103.5,16,765.5));

            if(!player.hasPermission("staff.use") || !player.hasPermission("*")) {
                AntiAFK antiAFK = new AntiAFK(player, player.getLocation().getBlock());
                main.getAntiAFK().put(player, antiAFK);
                antiAFK.runTaskTimer(main, 0L, 20L);
            }

            this.cancel();
        }

        timer--;
    }
}
