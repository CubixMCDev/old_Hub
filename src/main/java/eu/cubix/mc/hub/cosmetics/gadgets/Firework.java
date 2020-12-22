package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class Firework extends GadgetBuilder {

    private final Main main;

    private static Random random = new Random();

    public Firework(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ ChatColor.YELLOW+"Feu d'artifice";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.FIREWORK, 1);
    }

    @Override
    public int cooldown() {
        return 8;
    }

    @Override
    public void onInteract(Player player) {
        org.bukkit.entity.Firework fw = (org.bukkit.entity.Firework) player.getPlayer().getWorld().spawnEntity(player.getPlayer().getLocation(), EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        int rt = random.nextInt(5);
        FireworkEffect.Type type = FireworkEffect.Type.values()[rt];

        Color c1 = Color.fromRGB(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        Color c2 = Color.fromRGB(random.nextInt(256), random.nextInt(256), random.nextInt(256));

        FireworkEffect effect = FireworkEffect.builder().flicker(random.nextBoolean())
                .withColor(c1).withFade(c2).with(type)
                .trail(random.nextBoolean()).build();

        fwm.addEffect(effect);

        fwm.setPower(random.nextInt(3));

        fw.setFireworkMeta(fwm);
    }
}
