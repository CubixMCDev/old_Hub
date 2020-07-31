package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Heart {

    private int taskID;
    private final Player player;

    public Heart(Player player) {
        this.player = player;
    }

    public void startHeart() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                /*
                ParticleEffect packet1 = new ParticleEffect(EnumParticle.HEART, player.getPlayer().getLocation().add(0, 2.3d, 0),
                        0.1f, 0.1f, 0.1f, 1.0f, (int)1.0);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);
                 */
            }
        }, 0, 4);
    }
}
