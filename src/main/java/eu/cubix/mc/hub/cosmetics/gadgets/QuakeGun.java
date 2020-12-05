package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QuakeGun extends GadgetBuilder implements Listener {

    private final Main main;

    public QuakeGun(Main main) {
        this.main = main;
    }

    Map<UUID, ArrayList<Projectile>> projectiles = new HashMap<>();

    int radius = 2;

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ChatColor.YELLOW+"PaintBall";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.FIREWORK_CHARGE, 1);
    }

    @Override
    public int cooldown() {
        return 10;
    }

    @Override
    public void onInteract(Player player) {

    }
}
