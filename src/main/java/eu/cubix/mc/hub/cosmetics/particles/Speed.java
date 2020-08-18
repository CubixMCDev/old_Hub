package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Speed {

    private final Main main;
    private int taskID;
    private final Player player;

    public Speed(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startSpeed() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                /*
                ParticleEffect packet1 = new ParticleEffect(EnumParticle.SPELL_INSTANT, player.getPlayer().getLocation().add(0, 0, 0),
                        0.1f, 0.1f, 0.1f, 0.07f, 2);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);
                 */

                new SpeedEffect(4,player);
            }
        }, 0, 1);
    }

    class SpeedEffect extends BukkitRunnable {

        private final Player player;

        public SpeedEffect(double time, Player player) {
            this.runTaskLater(main, (int) time);
            this.player = player;
        }

        @Override
        public void run() {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
        }
    }
}
