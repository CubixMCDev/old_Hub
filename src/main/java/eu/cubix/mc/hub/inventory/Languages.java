package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static eu.cubix.mc.hub.tools.ItemsBuilder.setSkullID;

public class Languages implements GuiBuilder {

    private final Main main;

    public Languages(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Profil » Langues";
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

        ItemsBuilder France = new ItemsBuilder(setSkullID("51269a067ee37e63635ca1e723b676f139dc2dbddff96bbfef99d8b35c996bc"))
                .setName("§6§nFrançais§r §7(Sélectionné)");
        inv.setItem(19,France.toItemStack());

        ItemsBuilder England = new ItemsBuilder(setSkullID("4cac9774da1217248532ce147f7831f67a12fdcca1cf0cb4b3848de6bc94b4"))
                .setName("§6§nEnglish§r §c(Coming Soon)");
        inv.setItem(20,England.toItemStack());

        ItemsBuilder Spain = new ItemsBuilder(setSkullID("32bd4521983309e0ad76c1ee29874287957ec3d96f8d889324da8c887e485ea8"))
                .setName("§6§nEspañol§r §c(Próximamente)");
        inv.setItem(21,Spain.toItemStack());

        ItemsBuilder Germany = new ItemsBuilder(setSkullID("5e7899b4806858697e283f084d9173fe487886453774626b24bd8cfecc77b3f"))
                .setName("§6§nDeutsch§r §c(Kommt bald)");
        inv.setItem(22,Germany.toItemStack());

        ItemsBuilder Netherlands = new ItemsBuilder(setSkullID("c23cf210edea396f2f5dfbced69848434f93404eefeabf54b23c073b090adf"))
                .setName("§6§nNederlands§r §c(Komt binnenkort)");
        inv.setItem(23,Netherlands.toItemStack());

        ItemsBuilder Russia = new ItemsBuilder(setSkullID("16eafef980d6117dabe8982ac4b4509887e2c4621f6a8fe5c9b735a83d775ad"))
                .setName("§6§nРусский§r §c(Скоро будет)");
        inv.setItem(24,Russia.toItemStack());


        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(44,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Profile.class);
                break;

            default: break;
        }
    }
}
