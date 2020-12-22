package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.cosmetics.gadgets.*;
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

        if(!main.getCosmeticsManager().hasCosmetic("gadgetSheepExplode",player.getUniqueId())) {
            ItemsBuilder SheepExplode = new ItemsBuilder(Material.WOOL, 1, (byte) 14)
                    .setName("§6§nMouton explosif");
            inv.setItem(10,SheepExplode.toItemStack());
        } else {
            ItemsBuilder SheepExplode = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nMouton explosif");
            inv.setItem(10,SheepExplode.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetRainbowWalk",player.getUniqueId())) {
            ItemsBuilder RainbowWalk = new ItemsBuilder(Material.STAINED_CLAY, 1, (byte) 4)
                    .setName("§6§nPromenade arc-en-ciel");
            inv.setItem(11,RainbowWalk.toItemStack());
        } else {
            ItemsBuilder RainbowWalk = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPromenade arc-en-ciel");
            inv.setItem(11,RainbowWalk.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetTsunami",player.getUniqueId())) {
            ItemsBuilder Tsunami = new ItemsBuilder(Material.WATER_BUCKET, 1)
                    .setName("§6§nTsunami");
            inv.setItem(12,Tsunami.toItemStack());
        } else {
            ItemsBuilder Tsunami = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nTsunami");
            inv.setItem(12,Tsunami.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetAntiGravity",player.getUniqueId())) {
            ItemsBuilder AntiGravity = new ItemsBuilder(Material.SEA_LANTERN, 1)
                    .setName("§6§nAnti gravité");
            inv.setItem(13,AntiGravity.toItemStack());
        } else {
            ItemsBuilder AntiGravity = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nAnti gravité");
            inv.setItem(13,AntiGravity.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetMelonThrower",player.getUniqueId())) {
            ItemsBuilder MelonThrower = new ItemsBuilder(Material.MELON, 1)
                    .setName("§6§nLanceur de melon");
            inv.setItem(14,MelonThrower.toItemStack());
        } else {
            ItemsBuilder MelonThrower = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nLanceur de melon");
            inv.setItem(14,MelonThrower.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetChickenator",player.getUniqueId())) {
            ItemsBuilder Chickenator = new ItemsBuilder(Material.EGG, 1)
                    .setName("§6§nPoule explosive");
            inv.setItem(15,Chickenator.toItemStack());
        } else {
            ItemsBuilder Chickenator = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPoule explosive");
            inv.setItem(15,Chickenator.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetEtherealPearl",player.getUniqueId())) {
            ItemsBuilder EtherealPearl = new ItemsBuilder(Material.ENDER_PEARL, 1)
                    .setName("§6§nPerle de l'Ender");
            inv.setItem(16,EtherealPearl.toItemStack());
        } else {
            ItemsBuilder EtherealPearl = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPerle de l'Ender");
            inv.setItem(16,EtherealPearl.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetFirework",player.getUniqueId())) {
            ItemsBuilder Firework = new ItemsBuilder(Material.FIREWORK, 1)
                    .setName("§6§nFeu d'artifice");
            inv.setItem(19,Firework.toItemStack());
        } else {
            ItemsBuilder Firework = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nFeu d'artifice");
            inv.setItem(19,Firework.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("gadgetChristmasTree",player.getUniqueId())) {
            ItemsBuilder ChristmasTree = new ItemsBuilder(Material.SAPLING, 1, (byte) 1)
                    .setName("§6§nArbre de Noël");
            inv.setItem(20,ChristmasTree.toItemStack());
        } else {
            ItemsBuilder ChristmasTree = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nArbre de Noël");
            inv.setItem(20,ChristmasTree.toItemStack());
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

        if (current.getType() == Material.WOOL && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nMouton explosif")) {
            main.give(SheepExplode.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.STAINED_CLAY && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nPromenade arc-en-ciel")) {
            main.give(RainbowWalk.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.WATER_BUCKET && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nTsunami")) {
            main.give(Tsunami.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SEA_LANTERN && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nAnti gravité")) {
            main.give(AntiGravity.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.MELON && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nLanceur de melon")) {
            main.give(MelonThrower.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.EGG && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nPoule explosive")) {
            main.give(Chickenator.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.ENDER_PEARL && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nPerle de l'Ender")) {
            main.give(EtherealPearl.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.FIREWORK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nFeu d'artifice")) {
            main.give(Firework.class, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SAPLING && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nArbre de Noël")) {
            main.give(ChristmasTree.class, player);
            player.closeInventory();
        }

        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Cosmetics.class);
                break;

            case BARRIER:
                player.getInventory().setItem(6,new ItemStack(Material.AIR));
                player.closeInventory();
                break;

            default: break;
        }
    }
}
