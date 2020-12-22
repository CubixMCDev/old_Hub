package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import eu.cubix.mc.hub.tools.MathUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class AntiGravity extends GadgetBuilder {

    private Main main;

    public AntiGravity(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ChatColor.YELLOW+"Anti gravité";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.SEA_LANTERN, 1);
    }

    @Override
    public int cooldown() {
        return 17;
    }

    @Override
    public void onInteract(Player player) {
        final ArmorStand as = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), ArmorStand.class);
        as.setGravity(false);
        as.setSmall(true);
        as.setVisible(false);
        as.setHelmet(new ItemStack(Material.SEA_LANTERN));
        final int taskId = Bukkit.getScheduler().runTaskTimer(main, new Runnable() {
            @Override
            public void run() {
                as.setHeadPose(as.getHeadPose().add(0, 0.1, 0));
                as.getWorld().spigot().playEffect(as.getEyeLocation(), Effect.PORTAL, 0, 0, 3, 3, 3, 0, 150, 64);
                as.getWorld().spigot().playEffect(as.getEyeLocation(), Effect.WITCH_MAGIC, 0, 0, .3f, 0.3f, 0.3f, 0, 5, 64);
                for(Entity ent : as.getNearbyEntities(3, 2, 3)) {
                    MathUtil.applyVector(ent, new Vector(0, 0.1, 0));
                }
            }
        }, 0, 2).getTaskId();
        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                as.remove();
                Bukkit.getScheduler().cancelTask(taskId);
            }
        }, 220);
    }
}
