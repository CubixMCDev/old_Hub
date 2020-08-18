package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Emerald {

    private final Main main;
    private int taskID;
    private final Player player;

    public Emerald(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startEmerald() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                /*
                ParticleEffect packet1 = new ParticleEffect(EnumParticle.VILLAGER_HAPPY, player.getPlayer().getLocation().add(0, 1, 0),
                        0.1f, 0.1f, 0.1f, 0.07f, 2);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);
                 */
            }
        }, 0, 3);
    }
}
