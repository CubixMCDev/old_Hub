package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.*;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Enchanted {

    private final Main main;
    private int taskID;
    private final Player player;

    public Enchanted(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startEnchanted() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());
            ParticleEffect particleEffect = new ParticleEffect(player);

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                particleEffect.drawParticle(EnumParticle.ENCHANTMENT_TABLE, player.getPlayer().getLocation().add(0, MathUtil.randomDouble(0.1, 2), 0),
                        0.1f, 0.1f, 0.1f, 8.0f, 60);
                for(Player p : Bukkit.getOnlinePlayers())
                    particleEffect.sendToPlayer(p);
            }
        }, 0, 1);
    }
}
