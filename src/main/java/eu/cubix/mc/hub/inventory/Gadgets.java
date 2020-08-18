package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.cosmetics.gadgets.SheepExplode;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Gadgets implements GuiBuilder {

    private final Main main;

    public Gadgets(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Cosmétiques » Gadgets";
    }

    @Override
    public int getSize() {
        return 54;
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
        inv.setItem(26,Separateur.toItemStack());
        inv.setItem(27,Separateur.toItemStack());
        inv.setItem(35,Separateur.toItemStack());
        inv.setItem(36,Separateur.toItemStack());
        inv.setItem(44,Separateur.toItemStack());
        inv.setItem(46,Separateur.toItemStack());
        inv.setItem(45,Separateur.toItemStack());
        inv.setItem(47,Separateur.toItemStack());
        inv.setItem(48,Separateur.toItemStack());
        inv.setItem(50,Separateur.toItemStack());
        inv.setItem(51,Separateur.toItemStack());
        inv.setItem(52,Separateur.toItemStack());

        if(main.getCosmeticsManager().hasCosmetic("gadgetSheepExplode",player.getUniqueId())) {
            ItemsBuilder SheepExplode = new ItemsBuilder(Material.WOOL, 1, (byte) 14)
                    .setName("§6§nMouton explosif");
            inv.setItem(10,SheepExplode.toItemStack());
        } else {
            ItemsBuilder SheepExplode = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nMouton explosif");
            inv.setItem(10,SheepExplode.toItemStack());
        }

        ItemsBuilder Retired = new ItemsBuilder(Material.BARRIER)
                .setName("§6§nRetirer votre gadget");
        inv.setItem(49,Retired.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {

            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Cosmetics.class);
                break;

            case BARRIER:
                player.getInventory().setItem(6,new ItemStack(Material.AIR));
                player.closeInventory();
                break;

            case WOOL:
                main.give(SheepExplode.class, player);
                player.closeInventory();
                break;

            default: break;
        }
    }
}
