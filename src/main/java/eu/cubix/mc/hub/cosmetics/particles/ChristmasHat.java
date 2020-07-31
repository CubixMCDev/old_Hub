package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.MathUtil;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ChristmasHat {

    private int taskID;
    private final Player player;
    public int particles = 12;

    public ChristmasHat(Player player) {
        this.player = player;
    }

    public void startChristmasHat() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                Location location = player.getPlayer().getEyeLocation().add(0, 0.3, 0);
                float radius = 0.25f;
                drawCircle(radius + 0.1f, -0.05f, location, false);
                for (int i = 0; i < 5; i++) {
                    double x = MathUtil.randomDouble(-0.05, 0.05);
                    double z = MathUtil.randomDouble(-0.05, 0.05);
                    location.add(x, 0.46f, z);
                    /*
                    UtilParticles.display(255, 255, 255, location);
                     */
                    location.subtract(x, 0.46f, z);
                }
                for (float f = 0; f <= 0.4f; f += 0.1f) {
                    if (radius >= 0) {
                        drawCircle(radius, f, location, true);
                        radius -= 0.09f;
                    }
                }

            }
        }, 0, 1);
    }

    private void drawCircle(float radius, float height, Location location, boolean red) {
        for (int i = 0; i < particles; i++) {
            double inc = (2 * Math.PI) / particles;
            float angle = (float) (i * inc);
            float x = (float) (Math.cos(angle) * radius);
            float z = (float) (Math.sin(angle) * radius);
            location.add(x, height, z);
            /*
            UtilParticles.display(255, red ? 0 : 255, red ? 0 : 255, location);
             */
            location.subtract(x, height, z);
        }
    }
}
