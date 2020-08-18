package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Crit {

    private final Main main;
    private int taskID;
    private final Player player;

    public Crit(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startCrit() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());
            final float[] height = {0, 0, 2, 2};
            final boolean[] up = {true, false, true, false};
            final int[] steps = {0, 0, 0, 0};

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                for (int i = 0; i < 4; i++) {
                    if (up[i]) {
                        if (height[i] < 2)
                            height[i] += 0.05;
                        else
                            up[i] = false;
                    } else {
                        if (height[i] > 0)
                            height[i] -= 0.05;
                        else
                            up[i] = true;
                    }
                    double inc = (2 * Math.PI) / 100;
                    double angle = steps[i] * inc + ((i + 1) % 2 == 0 ? 45 : 0);
                    Vector v = new Vector();
                    v.setX(Math.cos(angle) * 1.1);
                    v.setZ(Math.sin(angle) * 1.1);
                    try {
                        /*
                        ParticleEffect packet1 = new ParticleEffect(EnumParticle.CRIT_MAGIC, player.getPlayer().getLocation().clone().add(v).add(0, height[i], 0),
                                0.15f, 0.15f, 0.15f, 0.07f, 4);
                        for(Player p : Bukkit.getOnlinePlayers())
                            packet1.sendToPlayer(p);
                         */
                    } catch (Exception exc) {

                    }
                    if (i == 0 || i == 3)
                        steps[i] -= 4;
                    else
                        steps[i] += 4;
                }
            }
        }, 0, 3);
    }
}
