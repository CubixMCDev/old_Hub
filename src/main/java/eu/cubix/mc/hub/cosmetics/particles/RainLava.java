package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import eu.cubix.mc.hub.tools.ParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RainLava {

    private final Main main;
    private int taskID;
    private final Player player;

    public RainLava(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startRainLava() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());
            ParticleEffect particleEffect = new ParticleEffect(player);

            int timer = 10;
            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                timer--;

                particleEffect.drawParticle(EnumParticle.SMOKE_LARGE, player.getPlayer().getLocation().add(0, 3, 0),
                        0.5F, 0.1f, 0.5f, 0.001f, 10);
                for(Player p : Bukkit.getOnlinePlayers())
                    particleEffect.sendToPlayer(p);

                particleEffect.drawParticle(EnumParticle.DRIP_LAVA, player.getPlayer().getLocation().add(0, 2, 0),
                        0.25F, 0.45f, 0.25f, 0.01f, 1);
                for(Player p : Bukkit.getOnlinePlayers())
                    particleEffect.sendToPlayer(p);
            }
        }, 0, 1);
    }
}
