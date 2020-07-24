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

import java.util.Arrays;

import static eu.cubix.mc.hub.Main.api;

public class ShopGrades implements GuiBuilder {
    private Main main;

    public ShopGrades(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Boutique » Grades";
    }

    @Override
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
        inv.setItem(37,Separateur.toItemStack());
        inv.setItem(38,Separateur.toItemStack());
        inv.setItem(39,Separateur.toItemStack());
        inv.setItem(40,Separateur.toItemStack());
        inv.setItem(41,Separateur.toItemStack());
        inv.setItem(42,Separateur.toItemStack());
        inv.setItem(43,Separateur.toItemStack());

        if(main.api.getRankManager().getRank(player).getPower() >= 10) {
            ItemsBuilder VIP = new ItemsBuilder(Material.IRON_INGOT)
                    .setName("§6§nVIP§n §7(Acheté)")
                    .addEnchant(Enchantment.LUCK,1)
                    .setFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE)
                    .setLore(Arrays.asList(" ","§e§l• Prix: 2325 \u24D2","§e§l• Avantages:","§e- ..."));
            inv.setItem(21,VIP.toItemStack());
        } else {
            ItemsBuilder VIP = new ItemsBuilder(Material.IRON_INGOT)
                    .setName("§6§nVIP")
                    .setLore(Arrays.asList(" ","§e§l• Prix: 2325 \u24D2","§e§l• Avantages:","§e- ..."));
            inv.setItem(21,VIP.toItemStack());
        }

        if(main.api.getRankManager().getRank(player).getPower() >= 20) {
            ItemsBuilder VIPplus = new ItemsBuilder(Material.GOLD_INGOT)
                .setName("§6§nVIP+§n §7(Acheté)")
                .addEnchant(Enchantment.LUCK,1)
                .setFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE)
                .setLore(Arrays.asList(" ","§e§l• Prix: 4650 \u24D2","§e§l• Avantages:","§e- ..."));
            inv.setItem(23,VIPplus.toItemStack());
        } else {
            ItemsBuilder VIPplus = new ItemsBuilder(Material.GOLD_INGOT)
                    .setName("§6§nVIP+")
                    .setLore(Arrays.asList(" ","§e§l• Prix: 4650 \u24D2","§e§l• Avantages:","§e- ..."));
            inv.setItem(23,VIPplus.toItemStack());
        }

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(44,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6VIP")) {
            if(main.api.getEcoManager().getBalanceCredits(player) >= 2325) {
                main.getGuiManager().open(player, GradeVIPConfirm.class);
            } else {
                player.closeInventory();
                player.sendMessage("§cCubixMC §4» §cErreur: vous n'avez pas assez de crédits pour vous payer ce grade.");
            }
        }

        if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6VIP+")) {
            if(main.api.getEcoManager().getBalanceCredits(player) >= 4650) {
                main.getGuiManager().open(player, GradeVIPplusConfirm.class);
            } else {
                player.closeInventory();
                player.sendMessage("§cCubixMC §4» §cErreur: vous n'avez pas assez de crédits pour vous payer ce grade.");
            }
        }

        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Shop.class);
                break;

            default: break;
        }
    }
}
