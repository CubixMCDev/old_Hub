package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.task.TaskVIP;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class GradeVIPConfirm implements GuiBuilder {

    @Override
    public String name() {
        return "§0Boutique » Grades » VIP";
    }

    @Override
    public int getSize() {
        return 27;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        ItemsBuilder Separateur = new ItemsBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4)
                .setName(" ");
        inv.setItem(0, Separateur.toItemStack());
        inv.setItem(1, Separateur.toItemStack());
        inv.setItem(2, Separateur.toItemStack());
        inv.setItem(3, Separateur.toItemStack());
        inv.setItem(5, Separateur.toItemStack());
        inv.setItem(6, Separateur.toItemStack());
        inv.setItem(7, Separateur.toItemStack());
        inv.setItem(8, Separateur.toItemStack());
        inv.setItem(9, Separateur.toItemStack());
        inv.setItem(17, Separateur.toItemStack());
        inv.setItem(18, Separateur.toItemStack());
        inv.setItem(19, Separateur.toItemStack());
        inv.setItem(20, Separateur.toItemStack());
        inv.setItem(21, Separateur.toItemStack());
        inv.setItem(22, Separateur.toItemStack());
        inv.setItem(23, Separateur.toItemStack());
        inv.setItem(24, Separateur.toItemStack());
        inv.setItem(25, Separateur.toItemStack());
        inv.setItem(26, Separateur.toItemStack());

        ItemsBuilder VIP = new ItemsBuilder(Material.IRON_INGOT)
                .setName("§6VIP")
                .setLore(Arrays.asList(" ", "§e§l• Prix: 2325 \u24D2", "§e§l• Avantages:", "§e- ..."));
        inv.setItem(4, VIP.toItemStack());

        ItemsBuilder Confirm = new ItemsBuilder(Material.INK_SACK, 1, (byte) 10)
                .setName("§aConfirmer");
        inv.setItem(12, Confirm.toItemStack());

        ItemsBuilder Cancel = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                .setName("§cAnnuler");
        inv.setItem(14, Cancel.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) throws InterruptedException {

        if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§aConfirmer")) {
            player.closeInventory();
            player.sendMessage("§eCubixMC §6» §eAchat en cours...");
            TaskVIP task = new TaskVIP(player);
            task.runTaskTimer(Main.getInstance(), 0, 20);
        }

        if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cAnnuler")) {
            Main.getInstance().getGuiManager().open(player, ShopGrades.class);
        }
    }
}
