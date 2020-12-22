package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import eu.cubix.mc.hub.tools.MathUtil;
import eu.cubix.mc.hub.tools.ParticleEffect;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tsunami extends GadgetBuilder {

    private final Main main;

    Random r = new Random();
    List<Entity> cooldownJump = new ArrayList<>();
    List<ArmorStand> armorStands = new ArrayList<>();

    public Tsunami(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ ChatColor.YELLOW+"Tsunami";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.WATER_BUCKET, 1);
    }

    @Override
    public int cooldown() {
        return 8;
    }

    @Override
    public void onInteract(Player player) {
        final org.bukkit.util.Vector v = player.getPlayer().getLocation().getDirection().normalize().multiply(0.3);
        v.setY(0);
        final Location loc = player.getPlayer().getLocation().subtract(0, 1, 0).add(v);
        final int i = Bukkit.getScheduler().runTaskTimer(main, new Runnable() {
            @Override
            public void run() {
                if(loc.getBlock().getType() != Material.AIR
                        && net.minecraft.server.v1_8_R3.Block.getById(loc.getBlock().getTypeId()).getMaterial().isSolid()) {
                    loc.add(0, 1, 0);
                }
                if(loc.clone().subtract(0, 1, 0).getBlock().getType() == Material.AIR) {
                    loc.add(0, -1, 0);
                }
                for (int i = 0; i < 5; i++) {
                    final ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc.clone().add(MathUtil.randomDouble(-1.5, 1.5), MathUtil.randomDouble(0, .5) - 0.75, MathUtil.randomDouble(-1.5, 1.5)), EntityType.ARMOR_STAND);
                    as.setSmall(true);
                    as.setVisible(false);
                    as.setGravity(false);
                    as.setHeadPose(new EulerAngle(r.nextInt(50), r.nextInt(50), r.nextInt(50)));
                    armorStands.add(as);
                    loc.getWorld().spigot().playEffect(loc.clone().add(MathUtil.randomDouble(-1.5, 1.5), MathUtil.randomDouble(1.3, 1.8) - 0.75, MathUtil.randomDouble(-1.5, 1.5)), Effect.CLOUD, 0, 0, 0.2f, 0.2f, 0.2f, 0f, 1, 64);
                    loc.getWorld().spigot().playEffect(loc.clone().add(MathUtil.randomDouble(-1.5, 1.5), MathUtil.randomDouble(0, .5) - 0.75, MathUtil.randomDouble(-1.5, 1.5)), Effect.WATERDRIP, 0, 0, 0.5f, 0.5f, 0.5f, 0.4f, 2, 64);

                    float finalR = -255 / 255;
                    float finalG = -255 / 255;
                    float finalB = 255 / 255;
                    ParticleEffect particleEffect = new ParticleEffect(player);

                    for (int a = 0; a < 20; a++) {
                        particleEffect.drawColorParticle(loc.clone().add(MathUtil.randomDouble(-1.5, 1.5), MathUtil.randomDouble(1, 1.6) - 0.75, MathUtil.randomDouble(-1.5, 1.5)), finalR, finalG, finalB);
                        for (Player p : Bukkit.getOnlinePlayers()) particleEffect.sendToPlayer(p);
                    }
                    Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                        @Override
                        public void run() {
                            armorStands.remove(as);
                            as.remove();
                        }
                    }, 20);
                    for(final Entity ent : as.getNearbyEntities(0.5, 0.5, 0.5)) {
                        if(!cooldownJump.contains(ent) && ent != player.getPlayer() && !(ent instanceof ArmorStand)) {
                            MathUtil.applyVector(ent, new Vector(0, 1, 0).add(v.clone().multiply(2)));
                            cooldownJump.add(ent);
                            Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                                @Override
                                public void run() {
                                    cooldownJump.remove(ent);
                                }
                            }, 20);
                        }
                    }
                }
                loc.add(v);
            }
        }, 0, 1).getTaskId();

        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                for(ArmorStand as : armorStands) {
                    as.remove();
                }
                Bukkit.getScheduler().cancelTask(i);
            }
        }, 40);
    }
}
