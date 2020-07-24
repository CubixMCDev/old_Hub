package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.task.TaskGadgetSheepExplode;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class GadgetSheepExplodeConfirm implements GuiBuilder {

    @Override
    public String name() {
        return "§0Boutique » Gadgets » Mouton";
    }

    public int getSize() {
        return 45;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        ItemsBuilder Separateur = new ItemsBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4)
                .setName(" ");
        inv.setItem(0,Separateur.toItemStack());
        inv.setItem(1,Separateur.toItemStack());
        inv.setItem(2,Separateur.toItemStack());
        inv.setItem(3,Separateur.toItemStack());
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
        inv.setItem(37,Separateur.toItemStack());
        inv.setItem(38,Separateur.toItemStack());
        inv.setItem(39,Separateur.toItemStack());
        inv.setItem(40,Separateur.toItemStack());
        inv.setItem(41,Separateur.toItemStack());
        inv.setItem(42,Separateur.toItemStack());
        inv.setItem(43,Separateur.toItemStack());
        inv.setItem(44,Separateur.toItemStack());

        ItemsBuilder VIP = new ItemsBuilder(Material.WOOL, 1, (byte) 14)
                .setName("§6§nMouton explosif")
                .setLore(Arrays.asList(" ", "§e§l• Prix: 10 \u24D2"));
        inv.setItem(4, VIP.toItemStack());

        ItemsBuilder Confirm = new ItemsBuilder(Material.INK_SACK, 1, (byte) 10)
                .setName("§aConfirmer");
        inv.setItem(21, Confirm.toItemStack());

        ItemsBuilder Cancel = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                .setName("§cAnnuler");
        inv.setItem(23, Cancel.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {

        if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§aConfirmer")) {
            player.closeInventory();
            player.sendMessage("§eCubixMC §6» §eAchat en cours...");
            TaskGadgetSheepExplode task = new TaskGadgetSheepExplode(Main.getInstance(),player);
            task.runTaskTimer(Main.getInstance(), 0, 20);
        }

        if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cAnnuler")) {
            Main.getInstance().getGuiManager().open(player, ShopGadgets.class);
        }
    }
}