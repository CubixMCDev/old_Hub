package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.pets.Pet;
import eu.cubix.mc.hub.tools.CustomSkull;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemFactory;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Pets implements GuiBuilder {
    private final Main main;

    public Pets(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Cosmétiques » Compagnons";
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

        if(main.getCosmeticsManager().hasCosmetic("petVillager",player.getUniqueId())) {
            inv.setItem(10, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/822d8e751c8f2fd4c8942c44bdb2f5ca4d8ae8e575ed3eb34c18a86e93b"))
                    .withName("§6§nVillageois")
                    .done());
        } else {
            ItemsBuilder Villager = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nVillageois");
            inv.setItem(10,Villager.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petCow",player.getUniqueId())) {
            inv.setItem(11, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5"))
                    .withName("§6§nVache")
                    .done());
        } else {
            ItemsBuilder Cow = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nVache");
            inv.setItem(11,Cow.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petSheep",player.getUniqueId())) {
            inv.setItem(12, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70"))
                    .withName("§6§nMouton")
                    .done());
        } else {
            ItemsBuilder Sheep = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nMouton");
            inv.setItem(12,Sheep.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petCat",player.getUniqueId())) {
            inv.setItem(13, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1"))
                    .withName("§6§nChat")
                    .done());
        } else {
            ItemsBuilder Cat = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nChat");
            inv.setItem(13,Cat.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petPig",player.getUniqueId())) {
            inv.setItem(14, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4"))
                    .withName("§6§nCochon")
                    .done());
        } else {
            ItemsBuilder Pig = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCochon");
            inv.setItem(14,Pig.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petHorse",player.getUniqueId())) {
            inv.setItem(15, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/628d1ab4be1e28b7b461fdea46381ac363a7e5c3591c9e5d2683fbe1ec9fcd3"))
                    .withName("§6§nCheval")
                    .done());
        } else {
            ItemsBuilder Horse = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCheval");
            inv.setItem(15,Horse.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petRabbit",player.getUniqueId())) {
            inv.setItem(16, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/7d1169b2694a6aba826360992365bcda5a10c89a3aa2b48c438531dd8685c3a7"))
                    .withName("§6§nLapin")
                    .done());
        } else {
            ItemsBuilder Rabbit = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nLapin");
            inv.setItem(16,Rabbit.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petChicken",player.getUniqueId())) {
            inv.setItem(19, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893"))
                    .withName("§6§nPoule")
                    .done());
        } else {
            ItemsBuilder Chicken = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPoule");
            inv.setItem(19,Chicken.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petCreeper",player.getUniqueId())) {
            inv.setItem(20, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/f4254838c33ea227ffca223dddaabfe0b0215f70da649e944477f44370ca6952"))
                    .withName("§6§nCreeper")
                    .done());
        } else {
            ItemsBuilder Creeper = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCreeper");
            inv.setItem(20,Creeper.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petSpider",player.getUniqueId())) {
            inv.setItem(21, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1"))
                    .withName("§6§nAraignée")
                    .done());
        } else {
            ItemsBuilder Spider = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nAraignée");
            inv.setItem(21,Spider.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petZombie",player.getUniqueId())) {
            inv.setItem(22, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/56fc854bb84cf4b7697297973e02b79bc10698460b51a639c60e5e417734e11"))
                    .withName("§6§nZombie")
                    .done());
        } else {
            ItemsBuilder Spider = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nZombie");
            inv.setItem(22,Spider.toItemStack());
        }

        if(main.getCosmeticsManager().hasCosmetic("petWolf",player.getUniqueId())) {
            inv.setItem(23, new ItemFactory(CustomSkull.getCustomSkull("http://textures.minecraft.net/texture/69d1d3113ec43ac2961dd59f28175fb4718873c6c448dfca8722317d67"))
                    .withName("§6§nChien")
                    .done());
        } else {
            ItemsBuilder Wolf = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nChien");
            inv.setItem(23,Wolf.toItemStack());
        }

        ItemsBuilder Retired = new ItemsBuilder(Material.BARRIER)
                .setName("§6§nRetirer votre compagnon");
        inv.setItem(49,Retired.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nVillageois")) {
            new Pet().createPet(player, EntityType.VILLAGER);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nVache")) {
            new Pet().createPet(player, EntityType.COW);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nMouton")) {
            new Pet().createPet(player, EntityType.SHEEP);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nChat")) {
            new Pet().createPet(player, EntityType.OCELOT);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCochon")) {
            new Pet().createPet(player, EntityType.PIG);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCheval")) {
            new Pet().createPet(player, EntityType.HORSE);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nLapin")) {
            new Pet().createPet(player, EntityType.RABBIT);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nPoule")) {
            new Pet().createPet(player, EntityType.CHICKEN);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCreeper")) {
            new Pet().createPet(player, EntityType.CREEPER);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nAraignée")) {
            new Pet().createPet(player, EntityType.SPIDER);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nZombie")) {
            new Pet().createPet(player, EntityType.ZOMBIE);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nChien")) {
            new Pet().createPet(player, EntityType.WOLF);
            player.closeInventory();
        }

        switch (current.getType()) {

            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Cosmetics.class);
                break;

            case BARRIER:
                if(Main.Pets.containsKey(player.getName())){
                    Main.Pets.get(player.getName()).remove();
                }
                player.closeInventory();
                break;

            default: break;
        }
    }
}
