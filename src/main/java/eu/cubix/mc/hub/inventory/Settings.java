package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.task.JoinTask;
import eu.cubix.mc.hub.task.SettingsUpdateTask;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class Settings implements GuiBuilder {

    private final Main main;

    public Settings(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Profil » Paramètres";
    }

    @Override
    public int getSize() {
        return 54;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        ItemsBuilder Separateur = new ItemsBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4)
                .setName(" ");
        inv.setItem(0, Separateur.toItemStack());
        inv.setItem(1, Separateur.toItemStack());
        inv.setItem(2, Separateur.toItemStack());
        inv.setItem(3, Separateur.toItemStack());
        inv.setItem(4, Separateur.toItemStack());
        inv.setItem(5, Separateur.toItemStack());
        inv.setItem(6, Separateur.toItemStack());
        inv.setItem(7, Separateur.toItemStack());
        inv.setItem(8, Separateur.toItemStack());
        inv.setItem(9, Separateur.toItemStack());
        inv.setItem(17, Separateur.toItemStack());
        inv.setItem(18, Separateur.toItemStack());
        inv.setItem(26, Separateur.toItemStack());
        inv.setItem(27, Separateur.toItemStack());
        inv.setItem(35, Separateur.toItemStack());
        inv.setItem(36, Separateur.toItemStack());
        inv.setItem(44, Separateur.toItemStack());
        inv.setItem(45, Separateur.toItemStack());
        inv.setItem(46, Separateur.toItemStack());
        inv.setItem(47, Separateur.toItemStack());
        inv.setItem(48, Separateur.toItemStack());
        inv.setItem(49, Separateur.toItemStack());
        inv.setItem(50, Separateur.toItemStack());
        inv.setItem(51, Separateur.toItemStack());
        inv.setItem(52, Separateur.toItemStack());

        ItemsBuilder Friends = new ItemsBuilder(Material.RAW_FISH)
                .setName("§6§nAmis")
                .setLore("§eActiver/Désactiver les demandes d'amis");
        inv.setItem(20, Friends.toItemStack());

        ItemsBuilder PrivateMessage = new ItemsBuilder(Material.PAPER)
                .setName("§6§nMessages privé")
                .setLore("§eActiver/Désactiver les messages privés");
        inv.setItem(23, PrivateMessage.toItemStack());

        ItemsBuilder Party = new ItemsBuilder(Material.COMMAND_MINECART)
                .setName("§6§nGroupe")
                .setLore("§eActiver/Désactiver les demandes de groupes");
        inv.setItem(29, Party.toItemStack());

        ItemsBuilder PartyFollow = new ItemsBuilder(Material.MINECART)
                .setName("§6§nSuivi groupe")
                .setLore("§eActiver/Désactiver le suivi de groupe");
        inv.setItem(32, PartyFollow.toItemStack());

        if (main.getAPI().getFriendsManager().isAllowed(player.getUniqueId()) == 1) {
            ItemsBuilder Friends_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 10)
                    .setName("§6§nOption ami")
                    .setLore(Arrays.asList("§eClic gauche pour désactiver", "§eStatus : §6Activer"));
            inv.setItem(21, Friends_option.toItemStack());
        } else if (main.getAPI().getFriendsManager().isAllowed(player.getUniqueId()) == 0) {
            ItemsBuilder Friends_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§6§nOption ami")
                    .setLore(Arrays.asList("§eClic gauche pour activer", "§eStatus : §6Désactiver"));
            inv.setItem(21, Friends_option.toItemStack());
        }

        if (main.getAPI().getFriendsManager().hasAllowedMessages(player.getUniqueId())) {
            ItemsBuilder PrivateMessage_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 10)
                    .setName("§6§nOption msg")
                    .setLore(Arrays.asList("§eClic gauche pour activer", "§eStatus : §6Activer"));
            inv.setItem(24, PrivateMessage_option.toItemStack());
        } else if (!main.getAPI().getFriendsManager().hasAllowedMessages(player.getUniqueId())) {
            ItemsBuilder PrivateMessage_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§6§nOption msg")
                    .setLore(Arrays.asList("§eClic gauche pour activer", "§eStatus : §6Désactiver"));
            inv.setItem(24, PrivateMessage_option.toItemStack());
        }

        if (main.getAPI().getPartyManager().getAllow(player.getUniqueId()) == 1) {
            ItemsBuilder Party_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 10)
                    .setName("§6§nOption groupe")
                    .setLore(Arrays.asList("§eClic gauche pour désactiver", "§eStatus : §6Activer"));
            inv.setItem(30, Party_option.toItemStack());
        } else if (main.getAPI().getPartyManager().getAllow(player.getUniqueId()) == 0) {
            ItemsBuilder Party_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§6§nOption groupe")
                    .setLore(Arrays.asList("§eClic gauche pour activer", "§eStatus : §6Désactiver"));
            inv.setItem(30, Party_option.toItemStack());
        }

        if (main.getAPI().getPartyManager().getFollow(player.getUniqueId()) == 1) {
            ItemsBuilder PartyFollow_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 10)
                    .setName("§6§nOption suivi groupe")
                    .setLore(Arrays.asList("§eClic gauche pour désactiver", "§eStatus : §6Activer"));
            inv.setItem(33, PartyFollow_option.toItemStack());
        } else if (main.getAPI().getPartyManager().getFollow(player.getUniqueId()) == 0) {
            ItemsBuilder PartyFollow_option = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§6§nOption suivi groupe")
                    .setLore(Arrays.asList("§eClic gauche pour activer", "§eStatus : §6Désactiver"));
            inv.setItem(33, PartyFollow_option.toItemStack());
        }

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53, Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        SettingsUpdateTask task = new SettingsUpdateTask(main, player);

        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Profile.class);
                break;
        }

        if (current != null && current.getType() == Material.INK_SACK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nOption ami")) {
            if (main.getAPI().getFriendsManager().isAllowed(player.getUniqueId()) == 1) {
                main.getAPI().getFriendsManager().setAllow(0, player.getUniqueId());
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            } else if (main.getAPI().getFriendsManager().isAllowed(player.getUniqueId()) == 0) {
                main.getAPI().getFriendsManager().setAllow(1, player.getUniqueId());
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            }
        }
        if (current != null && current.getType() == Material.INK_SACK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nOption msg")) {
            if (main.getAPI().getFriendsManager().hasAllowedMessages(player.getUniqueId())) {
                main.getAPI().getFriendsManager().setAllowMessages(player.getUniqueId(),0);
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            } else if (!main.getAPI().getFriendsManager().hasAllowedMessages(player.getUniqueId())) {
                main.getAPI().getFriendsManager().setAllowMessages(player.getUniqueId(),1);
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            }
        }
        if (current != null && current.getType() == Material.INK_SACK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nOption groupe")) {
            if (main.getAPI().getPartyManager().getAllow(player.getUniqueId()) == 1) {
                main.getAPI().getPartyManager().setAllow(0, player.getUniqueId());
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            } else if (main.getAPI().getPartyManager().getAllow(player.getUniqueId()) == 0) {
                main.getAPI().getPartyManager().setAllow(1, player.getUniqueId());
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            }
        }
        if (current != null && current.getType() == Material.INK_SACK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nOption suivi groupe")) {
            if (main.getAPI().getPartyManager().getFollow(player.getUniqueId()) == 1) {
                main.getAPI().getPartyManager().setFollow(0, player.getUniqueId());
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            } else if (main.getAPI().getPartyManager().getFollow(player.getUniqueId()) == 0) {
                main.getAPI().getPartyManager().setFollow(1, player.getUniqueId());
                player.closeInventory();
                player.sendMessage("§eCubixMC §6» §eRechargement des paramètres...");
                task.runTaskTimer(main, 0, 20);
            }
        }
    }
}
