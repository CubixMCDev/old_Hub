package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import eu.cubix.mc.hub.tools.ItemUtil;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Chickenator extends GadgetBuilder {

    static Random r = new Random();
    ArrayList<Item> items = new ArrayList<>();

    private Main main;

    public Chickenator(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ChatColor.YELLOW+"Poule explosive";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.EGG, 1);
    }

    @Override
    public int cooldown() {
        return 8;
    }

    @Override
    public void onInteract(Player player) {
        final Chicken CHICKEN = (Chicken) player.getPlayer().getWorld().spawnEntity(player.getPlayer().getEyeLocation(), EntityType.CHICKEN);
        CHICKEN.setNoDamageTicks(500);
        CHICKEN.setVelocity(player.getPlayer().getLocation().getDirection().multiply(Math.PI / 1.5));
        player.getPlayer().playSound(player.getPlayer().getLocation(), Sound.CHICKEN_IDLE, 1.4f, 1.5f);
        player.getPlayer().playSound(player.getPlayer().getLocation(), Sound.EXPLODE, 0.3f, 1.5f);
        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                spawnRandomFirework(CHICKEN.getLocation(), player);
                player.getPlayer().playSound(player.getPlayer().getLocation(), Sound.CHICKEN_HURT, 1.4f, 1.5f);
                CHICKEN.remove();
                for (int i = 0; i < 30; i++) {
                    final Item ITEM = CHICKEN.getWorld().dropItem(CHICKEN.getLocation(), ItemUtil.create(Material.COOKED_CHICKEN, (byte) 0, UUID.randomUUID().toString()));
                    ITEM.setPickupDelay(30000);
                    ITEM.setVelocity(new Vector(r.nextDouble() - 0.5, r.nextDouble() / 2.0, r.nextDouble() - 0.5));
                    items.add(ITEM);
                }
                Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                    @Override
                    public void run() {
                        for (Item i : items)
                            i.remove();
                    }
                }, 50);
            }
        }, 9);
        player.getPlayer().updateInventory();
    }

    public static FireworkEffect getRandomFireworkEffect() {
        FireworkEffect.Builder builder = FireworkEffect.builder();
        FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))).withFade(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))).build();
        return effect;
    }

    public void spawnRandomFirework(Location location, Player player) {
        final ArrayList<org.bukkit.entity.Firework> fireworks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final org.bukkit.entity.Firework f = player.getPlayer().getWorld().spawn(location, org.bukkit.entity.Firework.class);

            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(getRandomFireworkEffect());
            f.setFireworkMeta(fm);
            fireworks.add(f);
        }
        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                for (org.bukkit.entity.Firework f : fireworks)
                    f.detonate();
            }
        }, 2);
    }
}
