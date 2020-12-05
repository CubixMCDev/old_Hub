package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import eu.cubix.mc.hub.tools.MountManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static eu.cubix.mc.hub.tools.ItemsBuilder.setSkullID;

public class Mounts implements GuiBuilder {
    private final Main main;

    public Mounts(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Cosmétiques » Monture";
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

        if(!main.getCosmeticsManager().hasCosmetic("petVillager",player.getUniqueId())) {
            ItemsBuilder Villager = new ItemsBuilder(setSkullID("822d8e751c8f2fd4c8942c44bdb2f5ca4d8ae8e575ed3eb34c18a86e93b"))
                    .setName("§6§nVillageois");
            inv.setItem(10,Villager.toItemStack());
        } else {
            ItemsBuilder Villager = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nVillageois");
            inv.setItem(10,Villager.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petCow",player.getUniqueId())) {
            ItemsBuilder Cow = new ItemsBuilder(setSkullID("5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5"))
                    .setName("§6§nVache");
            inv.setItem(11,Cow.toItemStack());
        } else {
            ItemsBuilder Cow = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nVache");
            inv.setItem(11,Cow.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petSheep",player.getUniqueId())) {
            ItemsBuilder Sheep = new ItemsBuilder(setSkullID("f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70"))
                    .setName("§6§nMouton");
            inv.setItem(12,Sheep.toItemStack());
        } else {
            ItemsBuilder Sheep = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nMouton");
            inv.setItem(12,Sheep.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petCat",player.getUniqueId())) {
            ItemsBuilder Cat = new ItemsBuilder(setSkullID("5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1"))
                    .setName("§6§nChat");
            inv.setItem(13,Cat.toItemStack());
        } else {
            ItemsBuilder Cat = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nChat");
            inv.setItem(13,Cat.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petPig",player.getUniqueId())) {
            ItemsBuilder Pig = new ItemsBuilder(setSkullID("621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4"))
                    .setName("§6§nCochon §c(Early access)");
            inv.setItem(14,Pig.toItemStack());
        } else {
            ItemsBuilder Pig = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCochon");
            inv.setItem(14,Pig.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petHorse",player.getUniqueId())) {
            ItemsBuilder Horse = new ItemsBuilder(setSkullID("628d1ab4be1e28b7b461fdea46381ac363a7e5c3591c9e5d2683fbe1ec9fcd3"))
                    .setName("§6§nCheval");
            inv.setItem(15,Horse.toItemStack());
        } else {
            ItemsBuilder Horse = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCheval");
            inv.setItem(15,Horse.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petRabbit",player.getUniqueId())) {
            ItemsBuilder Rabbit = new ItemsBuilder(setSkullID("7d1169b2694a6aba826360992365bcda5a10c89a3aa2b48c438531dd8685c3a7"))
                    .setName("§6§nLapin");
            inv.setItem(16,Rabbit.toItemStack());
        } else {
            ItemsBuilder Rabbit = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nLapin");
            inv.setItem(16,Rabbit.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petChicken",player.getUniqueId())) {
            ItemsBuilder Chicken = new ItemsBuilder(setSkullID("1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893"))
                    .setName("§6§nPoule");
            inv.setItem(19,Chicken.toItemStack());
        } else {
            ItemsBuilder Chicken = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPoule");
            inv.setItem(19,Chicken.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petCreeper",player.getUniqueId())) {
            ItemsBuilder Creeper = new ItemsBuilder(setSkullID("f4254838c33ea227ffca223dddaabfe0b0215f70da649e944477f44370ca6952"))
                    .setName("§6§nCreeper");
            inv.setItem(20,Creeper.toItemStack());
        } else {
            ItemsBuilder Creeper = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCreeper");
            inv.setItem(20,Creeper.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petSpider",player.getUniqueId())) {
            ItemsBuilder Spider = new ItemsBuilder(setSkullID("cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1"))
                    .setName("§6§nAraignée");
            inv.setItem(21,Spider.toItemStack());
        } else {
            ItemsBuilder Spider = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nAraignée");
            inv.setItem(21,Spider.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petZombie",player.getUniqueId())) {
            ItemsBuilder Zombie = new ItemsBuilder(setSkullID("56fc854bb84cf4b7697297973e02b79bc10698460b51a639c60e5e417734e11"))
                    .setName("§6§nZombie");
            inv.setItem(22,Zombie.toItemStack());
        } else {
            ItemsBuilder Zombie = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nZombie");
            inv.setItem(22,Zombie.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petWolf",player.getUniqueId())) {
            ItemsBuilder Wolf = new ItemsBuilder(setSkullID("69d1d3113ec43ac2961dd59f28175fb4718873c6c448dfca8722317d67"))
                    .setName("§6§nChien");
            inv.setItem(23,Wolf.toItemStack());
        } else {
            ItemsBuilder Wolf = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nChien");
            inv.setItem(23,Wolf.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petSkeleton",player.getUniqueId())) {
            ItemsBuilder Skeleton = new ItemsBuilder(setSkullID("301268e9c492da1f0d88271cb492a4b302395f515a7bbf77f4a20b95fc02eb2"))
                    .setName("§6§nSquelette");
            inv.setItem(24,Skeleton.toItemStack());
        } else {
            ItemsBuilder Skeleton = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nSquelette");
            inv.setItem(24,Skeleton.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petSlime",player.getUniqueId())) {
            ItemsBuilder Slime = new ItemsBuilder(setSkullID("895aeec6b842ada8669f846d65bc49762597824ab944f22f45bf3bbb941abe6c"))
                    .setName("§6§nCube de Slime");
            inv.setItem(25,Slime.toItemStack());
        } else {
            ItemsBuilder Slime = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCube de Slime");
            inv.setItem(25,Slime.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petMagmaCube",player.getUniqueId())) {
            ItemsBuilder MagmaCube = new ItemsBuilder(setSkullID("38957d5023c937c4c41aa2412d43410bda23cf79a9f6ab36b76fef2d7c429"))
                    .setName("§6§nCube de Magma");
            inv.setItem(28,MagmaCube.toItemStack());
        } else {
            ItemsBuilder MagmaCube = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCube de Magma");
            inv.setItem(28,MagmaCube.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petPigZombie",player.getUniqueId())) {
            ItemsBuilder PigZombie = new ItemsBuilder(setSkullID("74e9c6e98582ffd8ff8feb3322cd1849c43fb16b158abb11ca7b42eda7743eb"))
                    .setName("§6§nZombie Pigman");
            inv.setItem(29,PigZombie.toItemStack());
        } else {
            ItemsBuilder PigZombie = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nZombie Pigman");
            inv.setItem(29,PigZombie.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petEnderman",player.getUniqueId())) {
            ItemsBuilder Enderman = new ItemsBuilder(setSkullID("96c0b36d53fff69a49c7d6f3932f2b0fe948e032226d5e8045ec58408a36e951"))
                    .setName("§6§nEnderman§r §c(Early access)");
            inv.setItem(30,Enderman.toItemStack());
        } else {
            ItemsBuilder Enderman = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nEnderman");
            inv.setItem(30,Enderman.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petEndermite",player.getUniqueId())) {
            ItemsBuilder Endermite = new ItemsBuilder(setSkullID("5bc7b9d36fb92b6bf292be73d32c6c5b0ecc25b44323a541fae1f1e67e393a3e"))
                    .setName("§6§nEndermite");
            inv.setItem(31,Endermite.toItemStack());
        } else {
            ItemsBuilder Endermite = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nEndermite");
            inv.setItem(31,Endermite.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petSilverfish",player.getUniqueId())) {
            ItemsBuilder Silverfish = new ItemsBuilder(setSkullID("92ec2c3cb95ab77f7a60fb4d160bced4b879329b62663d7a9860642e588ab210"))
                    .setName("§6§nPoisson d'argent");
            inv.setItem(32,Silverfish.toItemStack());
        } else {
            ItemsBuilder Silverfish = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPoisson d'argent");
            inv.setItem(32,Silverfish.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petBlaze",player.getUniqueId())) {
            ItemsBuilder Blaze = new ItemsBuilder(setSkullID("b78ef2e4cf2c41a2d14bfde9caff10219f5b1bf5b35a49eb51c6467882cb5f0"))
                    .setName("§6§nBlaze");
            inv.setItem(33,Blaze.toItemStack());
        } else {
            ItemsBuilder Blaze = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nBlaze");
            inv.setItem(33,Blaze.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petWitch",player.getUniqueId())) {
            ItemsBuilder Witch = new ItemsBuilder(setSkullID("fce6604157fc4ab5591e4bcf507a749918ee9c41e357d47376e0ee7342074c90"))
                    .setName("§6§nSorcière");
            inv.setItem(34,Witch.toItemStack());
        } else {
            ItemsBuilder Witch = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nSorcière");
            inv.setItem(34,Witch.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petCaveSpider",player.getUniqueId())) {
            ItemsBuilder CaveSpider = new ItemsBuilder(setSkullID("41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224"))
                    .setName("§6§nAraignée des caves");
            inv.setItem(37,CaveSpider.toItemStack());
        } else {
            ItemsBuilder CaveSpider = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nAraignée des caves");
            inv.setItem(37,CaveSpider.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("petMushroomCow",player.getUniqueId())) {
            ItemsBuilder MushroomCow = new ItemsBuilder(setSkullID("d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db"))
                    .setName("§6§nVache champi'");
            inv.setItem(38,MushroomCow.toItemStack());
        } else {
            ItemsBuilder MushroomCow = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nVache champi'");
            inv.setItem(38,MushroomCow.toItemStack());
        }

        ItemsBuilder Retired = new ItemsBuilder(Material.BARRIER)
                .setName("§6§nRetirer votre monture");
        inv.setItem(49,Retired.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nVillageois")) {
            MountManager.rideVillager(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nVache")) {
            MountManager.rideCow(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nMouton")) {
            MountManager.rideSheep(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nChat")) {
            MountManager.rideCat(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCochon§r §c(Early access)")) {
            MountManager.ridePig(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCheval")) {
            MountManager.rideHorse(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nLapin")) {
            MountManager.rideRabbit(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nPoule")) {
            MountManager.rideChicken(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCreeper")) {
            MountManager.rideCreeper(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nAraignée")) {
            MountManager.rideSpider(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nZombie")) {
            MountManager.rideZombie(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nChien")) {
            MountManager.rideWolf(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nSquelette")) {
            MountManager.rideSkeleton(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCube de Slime")) {
            MountManager.rideSlime(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nCube de Magma")) {
            MountManager.rideMagmaCube(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nZombie Pigman")) {
            MountManager.ridePigZombie(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nEnderman§r §c(Early access)")) {
            MountManager.rideEnderman(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nEndermite")) {
            MountManager.rideEndermite(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nPoisson d'argent")) {
            MountManager.rideSilverfish(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nBlaze")) {
            MountManager.rideBlaze(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nSorcière")) {
            MountManager.rideWitch(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nAraignée des caves")) {
            MountManager.rideCaveSpider(main, player);
            player.closeInventory();
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nVache champi'")) {
            MountManager.rideMushroomCow(main, player);
            player.closeInventory();
        }

        switch (current.getType()) {

            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Cosmetics.class);
                break;

            case BARRIER:
                player.setSneaking(true);
                player.closeInventory();
                break;

            default: break;
        }
    }
}
