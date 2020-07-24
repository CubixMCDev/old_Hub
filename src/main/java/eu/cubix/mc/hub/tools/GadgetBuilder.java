package eu.cubix.mc.hub.tools;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class GadgetBuilder {

    public abstract String name();

    public abstract ItemStack item();

    public abstract int cooldown();

    public abstract void onInteract(Player player);

    public void give(Player player, int position) {
        ItemStack it = item();
        ItemMeta iM = it.getItemMeta();
        iM.setDisplayName(name());
        it.setItemMeta(iM);
        player.getInventory().setItem(position, it);
    }
}