package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import eu.cubix.mc.hub.tools.ParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Angry {

    private final Main main;
    private int taskID;
    private final Player player;

    public Angry(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startAngry() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                ParticleEffect particleEffect = new ParticleEffect(player);

                particleEffect.drawParticle(EnumParticle.VILLAGER_ANGRY, player.getPlayer().getLocation().add(0, 1.9d, 0),
                        0.1f, 0.1f, 0.1f, 1.0f, (int)1.0);
                for(Player p : Bukkit.getOnlinePlayers()) particleEffect.sendToPlayer(p);
            }
        }, 0, 3);
    }
}
