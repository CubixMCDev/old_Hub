package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.*;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Enchanted {

    private int taskID;
    private final Player player;

    public Enchanted(Player player) {
        this.player = player;
    }

    public void startEnchanted() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                ParticleEffect packet1 = new ParticleEffect(EnumParticle.ENCHANTMENT_TABLE, player.getPlayer().getLocation().add(0, MathUtil.randomDouble(0.1, 2), 0),
                        0.1f, 0.1f, 0.1f, 8.0f, 60);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);
            }
        }, 0, 1);
    }
}