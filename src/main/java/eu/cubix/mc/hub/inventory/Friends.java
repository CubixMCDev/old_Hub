package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static eu.cubix.mc.hub.Main.api;

public class Friends implements GuiBuilder {

    @Override
    public String name() {
        return "§0Profil » Amis";
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


        List<UUID> friends = api.getFriendsManager().getFriends(player.getUniqueId());
        for(int i = 0; i < friends.size(); i++) {
            OfflinePlayer friend = Bukkit.getOfflinePlayer(friends.get(i));
            if (friend.isOnline()) {
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§eStatut : §6Connecté");
                lore.add("§eServeur : §6(In dev)");
                lore.add("§e» Clic gauche pour se téléporter §6(In dev)");
                ItemsBuilder head = new ItemsBuilder(Material.SKULL_ITEM, 1, (byte) 3)
                        .setName("§6§n"+friend.getName())
                        .setLore(lore)
                        .setSkullOwner(friend.getName());
                inv.setItem(i + 10, head.toItemStack());
            } else {
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§eStatut : §6Déconnecté");
                ItemsBuilder head = new ItemsBuilder(Material.SKULL_ITEM, 1, (byte) 3)
                        .setName("§6§n"+friend.getName())
                        .setLore(lore)
                        .setSkullOwner(friend.getName());
                inv.setItem(i + 10, head.toItemStack());
            }
        }

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(44,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        // TELEPORTATION ect

        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                Main.getInstance().getGuiManager().open(player, Profile.class);
                break;

            default: break;
        }
    }
}
