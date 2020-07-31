package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EnderAura {

    private int taskID;
    private final Player player;

    public EnderAura(Player player) {
        this.player = player;
    }

    public void startEnderAura() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                /*
                ParticleEffect packet1 = new ParticleEffect(EnumParticle.PORTAL, player.getPlayer().getLocation().add(0, 0, 0),
                        0.35f, 0.05f, 0.35f, 0.01f, 128);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);

                ParticleEffect packet2 = new ParticleEffect(EnumParticle.PORTAL, player.getPlayer().getLocation().add(0, -0.5, 0),
                        0.35f, 0.5f, 0.35f, 0.01f, 128);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet2.sendToPlayer(p);
                 */
            }
        }, 0, 3);
    }
}
