package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import eu.cubix.mc.hub.tools.ParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class BloodHelix {

    private int taskID;
    private final Player player;
    double i = 0;

    public BloodHelix(Player player) {
        this.player = player;
    }

    public void startBloodHelix() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                Location location = player.getPlayer().getLocation();
                Location location2 = location.clone();
                double radius = 1.1d;
                double radius2 = 1.1d;
                double particles = 100;

                for (int step = 0; step < 100; step += 4) {
                    double interval = (2 * Math.PI) / particles;
                    double angle = step * interval + i;
                    Vector v = new Vector();
                    v.setX(Math.cos(angle) * radius);
                    v.setZ(Math.sin(angle) * radius);
                    ParticleEffect packet1 = new ParticleEffect(EnumParticle.REDSTONE, location.add(v),
                            0.1f, 0.1f, 0.1f, 0.07f, 1);
                    for(Player p : Bukkit.getOnlinePlayers())
                        packet1.sendToPlayer(p);
                    location.subtract(v);
                    location.add(0, 0.12d, 0);
                    radius -= 0.044f;
                }
                for (int step = 0; step < 100; step += 4) {
                    double interval = (2 * Math.PI) / particles;
                    double angle = step * interval + i + 3.5;
                    Vector v = new Vector();
                    v.setX(Math.cos(angle) * radius2);
                    v.setZ(Math.sin(angle) * radius2);
                    ParticleEffect packet1 = new ParticleEffect(EnumParticle.REDSTONE, location2.add(v),
                            0.1f, 0.1f, 0.1f, 0.07f, 1);
                    for(Player p : Bukkit.getOnlinePlayers())
                        packet1.sendToPlayer(p);
                    location2.subtract(v);
                    location2.add(0, 0.12d, 0);
                    radius2 -= 0.044f;
                }
                i += 0.05;
            }
        }, 0, 1);
    }
}
