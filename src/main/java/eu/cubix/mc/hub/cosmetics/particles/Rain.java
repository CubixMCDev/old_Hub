package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import eu.cubix.mc.hub.tools.ParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Rain {

    private final Main main;
    private int taskID;
    private final Player player;

    public Rain(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startRain() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                ParticleEffect packet1 = new ParticleEffect(EnumParticle.CLOUD, player.getPlayer().getLocation().add(0, 3, 0),
                        0.5F, 0.1f, 0.5f, 0.001f, 10);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);

                ParticleEffect packet2 = new ParticleEffect(EnumParticle.WATER_SPLASH, player.getPlayer().getLocation().add(0, 2, 0),
                        0.25F, 0.45f, 0.25f, 0.01f, 1);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet2.sendToPlayer(p);
            }
        }, 0, 1);
    }
}
