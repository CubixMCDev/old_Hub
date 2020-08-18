package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import eu.cubix.mc.hub.tools.MathUtil;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SheepExplode extends GadgetBuilder {
    public static final List<SheepExplode> EXPLOSIVE_SHEEP = new ArrayList<>();

    private final ArrayList<Sheep> sheepArrayList = new ArrayList<>();

    private final Main main;

    public SheepExplode(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§6Gadget: §eMouton explosif";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.WOOL, 1, (byte) 14);
    }

    @Override
    public int cooldown() {
        return 15;
    }

    @Override
    public void onInteract(Player player) {
        Location loc = player.getPlayer().getLocation().add(player.getPlayer().getEyeLocation().getDirection().multiply(0.5));
        loc.setY(player.getPlayer().getLocation().getBlockY() + 1);
        Sheep s = player.getPlayer().getWorld().spawn(loc, Sheep.class);

        s.setNoDamageTicks(100000);
        sheepArrayList.add(s);

        EXPLOSIVE_SHEEP.add(this);

        new SheepColorRunnable(7, true, s, this, player);
    }

    class SheepColorRunnable extends BukkitRunnable {
        private boolean red;
        private double time;
        private final Sheep s;
        private final SheepExplode gadgetExplosiveSheep;
        Player player;

        public SheepColorRunnable(double time, boolean red, Sheep s, SheepExplode gadgetExplosiveSheep, Player player) {
            this.red = red;
            this.time = time;
            this.s = s;
            this.runTaskLater(main, (int) time);
            this.gadgetExplosiveSheep = gadgetExplosiveSheep;
            this.player = player;
        }

        @Override
        public void run() {
            if (player.getPlayer() == null) {
                cancel();
                return;
            }
            if (red) s.setColor(DyeColor.RED);
            else s.setColor(DyeColor.WHITE);
            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.4f, 1.5f);
            red = !red;
            time -= 0.2;

            if (time < 0.5) {
                player.playSound(player.getLocation(), Sound.EXPLODE, 1.4f, 1.5f);
                /*
                ParticleEffect packet = new ParticleEffect(EnumParticle.EXPLOSION_HUGE, s.getLocation(),
                        0.5f, 0.5f, 0.5f, 0.07f, 1);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet.sendToPlayer(p);
                 */
                for (int i = 0; i < 50; i++) {
                    final Sheep sheep = player.getPlayer().getWorld().spawn(s.getLocation(), Sheep.class);
                    try {
                        sheep.setColor(DyeColor.values()[MathUtil.randomRangeInt(0, 15)]);
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                    Random r = new Random();
                    MathUtil.applyVelocity(main, sheep, new Vector(r.nextDouble() - 0.5, r.nextDouble() / 2, r.nextDouble() - 0.5).multiply(2).add(new Vector(0, 0.8, 0)));
                    sheep.setBaby();
                    sheep.setAgeLock(true);
                    sheep.setNoDamageTicks(120);
                    sheepArrayList.add(sheep);
                    Bukkit.getScheduler().runTaskLater(main, () -> {
                        /*
                        ParticleEffect pa = new ParticleEffect(EnumParticle.FLAME, sheep.getLocation(),
                                0.5f, 0.5f, 0.5f, 0.07f, 1);
                        for(Player p : Bukkit.getOnlinePlayers())
                            pa.sendToPlayer(p);
                         */
                        sheep.remove();
                        sheep.remove();
                        EXPLOSIVE_SHEEP.remove(gadgetExplosiveSheep);
                    }, 110);
                }
                sheepArrayList.remove(s);
                s.remove();
                cancel();
            } else {
                Bukkit.getScheduler().cancelTask(getTaskId());
                new SheepColorRunnable(time, red, s, gadgetExplosiveSheep, player);
            }
        }
    }
}
