package eu.cubix.mc.hub.tools;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemFactory {

    private ItemStack item;

    public ItemFactory(ItemStack item) {
        this.item = item;
    }

    /**
     * Changer le nom de l'Item.
     */
    public ItemFactory withName(String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return this;
    }

    /**
     * Changer la description de l'Item.
     */
    public ItemFactory withLore(String... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return this;
    }

    /**
     * Valider la construction de l'Item.
     */
    public ItemStack done() {
        return item;
    }

}
