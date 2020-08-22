package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.MathUtil;
import eu.cubix.mc.hub.tools.ParticleData;
import eu.cubix.mc.hub.tools.ParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Flame {

    private final Main main;
    private int taskID;
    private final Player player;

    public Flame(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startFlame() {

        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());
            float step = 0;

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                for (int i = 0; i < 2; i++) {
                    double inc = (2 * Math.PI) / 100;
                    double toAdd = 0;
                    if (i == 1)
                        toAdd = 3.5;
                    double angle = step * inc + toAdd;
                    Vector v = new Vector();
                    v.setX(Math.cos(angle));
                    v.setZ(Math.sin(angle));
                    if (i == 0) {
                        MathUtil.rotateAroundAxisZ(v, 180);
                    } else {
                        MathUtil.rotateAroundAxisZ(v, 90);
                    }
                    ParticleEffect packet1 = new ParticleEffect(EnumParticle.FLAME, player.getPlayer().getLocation().add(0, 1, 0),
                            0.1f, 0.1f, 0.1f, 0.07f, (int)1.0);
                    for(Player p : Bukkit.getOnlinePlayers())
                        packet1.sendToPlayer(p);
                }
                step += 3;
            }
        }, 0, 3);
    }
}
