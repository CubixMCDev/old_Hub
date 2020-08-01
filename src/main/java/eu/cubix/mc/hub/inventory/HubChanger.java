package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class HubChanger implements GuiBuilder {

    private final Main main;

    public HubChanger(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Menu » Hubs";
    }

    @Override
    public int getSize() {
        return 27;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        ItemsBuilder Separateur = new ItemsBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4)
                .setName(" ");
        inv.setItem(0,Separateur.toItemStack());
        inv.setItem(1,Separateur.toItemStack());
        inv.setItem(2,Separateur.toItemStack());
        inv.setItem(3,Separateur.toItemStack());
        inv.setItem(4,Separateur.toItemStack());
        inv.setItem(5,Separateur.toItemStack());
        inv.setItem(6,Separateur.toItemStack());
        inv.setItem(7,Separateur.toItemStack());
        inv.setItem(8,Separateur.toItemStack());
        inv.setItem(9,Separateur.toItemStack());
        inv.setItem(17,Separateur.toItemStack());
        inv.setItem(18,Separateur.toItemStack());
        inv.setItem(19,Separateur.toItemStack());
        inv.setItem(20,Separateur.toItemStack());
        inv.setItem(21,Separateur.toItemStack());
        inv.setItem(22,Separateur.toItemStack());
        inv.setItem(23,Separateur.toItemStack());
        inv.setItem(24,Separateur.toItemStack());
        inv.setItem(25,Separateur.toItemStack());

        ItemsBuilder HubChanger = new ItemsBuilder(Material.ENDER_PORTAL_FRAME)
                .setName("§6§nHub #1")
                .addEnchant(Enchantment.LUCK,1)
                .setFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        inv.setItem(10,HubChanger.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(26,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Menu.class);
                break;

            default: break;
        }
    }
}
