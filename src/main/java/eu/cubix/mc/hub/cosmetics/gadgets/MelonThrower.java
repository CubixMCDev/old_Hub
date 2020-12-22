package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import eu.cubix.mc.hub.tools.ItemUtil;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class MelonThrower extends GadgetBuilder implements Listener {

    Random random = new Random();

    ArrayList<Item> melons = new ArrayList<>();
    ArrayList<Item> melonBlocks = new ArrayList<>();

    private Main main;

    public MelonThrower(Main main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ChatColor.YELLOW+"Lanceur de melon";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.MELON, 1);
    }

    @Override
    public int cooldown() {
        return 10;
    }

    @Override
    public void onInteract(Player player) {
        player.getPlayer().playSound(player.getPlayer().getLocation(), Sound.EXPLODE, 1, 1);
        Item item = player.getPlayer().getWorld().dropItem(player.getPlayer().getEyeLocation(), ItemUtil.create(Material.MELON_BLOCK, (byte) 0x0, UUID.randomUUID().toString()));
        item.setPickupDelay(0);
        item.setVelocity(player.getPlayer().getEyeLocation().getDirection().multiply(1.3d));
        melonBlocks.add(item);

        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    for (Item item1 : melonBlocks) {
                        if (item1.isOnGround()) {
                            item1.getWorld().playEffect(item1.getLocation(), Effect.STEP_SOUND, 103);
                            for (int i = 0; i < 8; i++) {
                                final Item melon = player.getPlayer().getWorld().dropItem(item1.getLocation(), ItemUtil.create(Material.MELON, (byte) 0x0, UUID.randomUUID().toString()));
                                melon.setVelocity(new Vector(random.nextDouble() - 0.5, random.nextDouble() / 2.0, random.nextDouble() - 0.5).multiply(0.75D));
                                melons.add(melon);
                                Bukkit.getScheduler().runTaskLaterAsynchronously(main, new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        if (melon.isValid()) {
                                            melon.remove();
                                            melons.remove(melon);
                                        }
                                    }
                                }, 100);
                            }
                            melonBlocks.remove(item1);
                            item1.remove();
                        }
                    }
                } catch (Exception exc) {}
            }
        }.runTaskTimer(main, 20, 0);
    }

    @EventHandler
    public void onTakeUpMelon(PlayerPickupItemEvent event) {
        if (melons.contains(event.getItem()) && event.getItem().getTicksLived() > 5) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5 * 20, 2));
            event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.BURP, 1, 1f);
            event.setCancelled(true);
            melons.remove(event.getItem());
            event.getItem().remove();
        }
        if (melonBlocks.contains(event.getItem()))
            event.setCancelled(true);
    }
}
