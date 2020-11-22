package eu.cubix.mc.hub.scoreboard;

import eu.cubix.mc.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PersonalScoreboard {
    private final Player player;
    private Main main;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;

    PersonalScoreboard(Main main, Player player){
        this.main = main;
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "CubixMC");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){
        //double pourcent = (double) Main.api.get().getExp(player.getUniqueId()) / (double) Main.api.get().getXPfromLevel(Main.api.get().getExp(player.getUniqueId()));
        objectiveSign.setDisplayName("§eCubix§6MC");

        objectiveSign.setLine(0, "§1");
        objectiveSign.setLine(1, "§8» §6§n" + player.getName()+"§r §7("+((CraftPlayer) player).getHandle().ping+" ms)");
        objectiveSign.setLine(2, "§2");
        if(player.hasPermission("staff.use") && player.hasPermission("vipplus.use")) {
            objectiveSign.setLine(3, "§8» §6Grade: "+
                    main.getAPI().get().getRankWithColors(player.getUniqueId())+ChatColor.GRAY+"/"+ChatColor.GOLD+"VIP+");

        } else if(player.hasPermission("staff.use") && player.hasPermission("vip.use")) {
            objectiveSign.setLine(3, "§8» §6Grade: "+
                    main.getAPI().get().getRankWithColors(player.getUniqueId())+ChatColor.GRAY+"/"+ChatColor.YELLOW+"VIP");

        } else if(player.hasPermission("vipplus.use")){
            objectiveSign.setLine(3, "§8» §6Grade: "+ ChatColor.GOLD+"VIP+");

        } else if(player.hasPermission("vip.use")){
            objectiveSign.setLine(3, "§8» §6Grade: "+ ChatColor.YELLOW+"VIP");
        } else {
            objectiveSign.setLine(3, "§8» §6Grade: "+ main.getAPI().get().getRankWithColors(player.getUniqueId()));
        }
        objectiveSign.setLine(4, "§3");
        objectiveSign.setLine(5, "§8» §6Crédits: §e"+ main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2");
        objectiveSign.setLine(6, "§8» §6Coins: §e" + main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3");
        objectiveSign.setLine(7, "§4");
        objectiveSign.setLine(8, "§8» §6Niveau: §e"+ main.getAPI().get().getLevel(player.getUniqueId()));
        objectiveSign.setLine(9, "§8» §6[§e\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758\u2758§6] §e"+"Nope"+"%");
        objectiveSign.setLine(10, "§6");
        objectiveSign.setLine(11, "§8» §6Connectés: §e" + Bukkit.getOnlinePlayers().size() + "§6/§e" + Bukkit.getMaxPlayers());
        objectiveSign.setLine(12, "§8» §6Serveur: §e" + Bukkit.getMotd());
        objectiveSign.setLine(13, "§7");
        objectiveSign.setLine(14, "§8» " + ip);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}