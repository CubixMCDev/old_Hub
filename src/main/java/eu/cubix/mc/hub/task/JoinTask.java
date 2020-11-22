package eu.cubix.mc.hub.task;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.Hologram;
import eu.cubixmc.com.data.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

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

            if(player.hasPermission("staff.use") || player.hasPermission("vip.use") || player.hasPermission("*")) {
                Bukkit.broadcastMessage(user.getRankToStringWithColor() + ChatColor.DARK_GRAY + " \u2758 " + main.getAPI().get().getRankColor(player.getUniqueId()) + player.getName() + " §6a rejoint le hub !");
            }

            if(player.hasPermission("fly.hub") || player.hasPermission("*")) player.setAllowFlight(true);

            if(player.hasPermission("staff.use") && player.hasPermission("vipplus.use")) {
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

            } else if(player.hasPermission("staff.use") && player.hasPermission("vip.use")) {
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

            this.cancel();
        }

        timer--;
    }
}
