package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RainLava {

    private int taskID;
    private final Player player;

    public RainLava(Player player) {
        this.player = player;
    }

    public void startRainLava() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            int timer = 10;
            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                timer--;

                /*
                ParticleEffect packet1 = new ParticleEffect(EnumParticle.SMOKE_LARGE, player.getPlayer().getLocation().add(0, 3, 0),
                        0.5F, 0.1f, 0.5f, 0.001f, 10);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);

                ParticleEffect packet2 = new ParticleEffect(EnumParticle.DRIP_LAVA, player.getPlayer().getLocation().add(0, 2, 0),
                        0.25F, 0.45f, 0.25f, 0.01f, 1);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet2.sendToPlayer(p);
                */
            }
        }, 0, 1);
    }
}
