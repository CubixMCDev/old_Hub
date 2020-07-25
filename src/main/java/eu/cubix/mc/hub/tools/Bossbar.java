package eu.cubix.mc.hub.tools;

public class Bossbar {
    /*

    private int taskID = -1;
    private final Main main;
    private BossBar bar;

    public Bossbar(Main main) {
        this.main = main;
    }

    public void addPlayer(Player player) {
        bar.addPlayer(player);
    }

    public BossBar getBar() {
        return bar;
    }

    public void createBar() {
        bar = Bukkit.createBossBar(format("&7Bienvenue sur &eCubix&6MC&7!"), BarColor.YELLOW, BarStyle.SOLID);
        bar.setVisible(true);
        cast();
    }

    public void cast() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            int count = -1;
            double progress = 1.0;
            final double time = 2.5 /480;

            @Override
            public void run() {
                bar.setProgress(progress);

                switch (count) {
                    case -1:
                        break;
                    case 0:
                        bar.setColor(BarColor.RED);
                        bar.setTitle(format("&7Le serveur est actuellement en &cAlpha&7!"));
                        break;
                    case 1:
                        bar.setColor(BarColor.GREEN);
                        bar.setTitle(format("§7Visitez notre site web : &ahttps://cubixmc.fr"));
                        break;
                    case 2:
                        bar.setColor(BarColor.PURPLE);
                        bar.setTitle(format("&7Rejoignez notre Discord : &dhttps://discord.gg/UFd3eRh"));
                        break;
                    default:
                        bar.setColor(BarColor.YELLOW);
                        bar.setTitle(format("&7Bienvenue sur &eCubix&6MC&7!"));
                        count = -1;
                        break;
                }
                progress = progress - time;
                if(progress <= 0) {
                    count++;
                    progress = 1.0;
                }
            }
        }, 0, 1);
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
     */
}