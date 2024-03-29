package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static eu.cubix.mc.hub.tools.ItemsBuilder.setSkullID;

public class Profile implements GuiBuilder {

    private final Main main;

    public Profile(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Profil";
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

        ItemsBuilder profil = new ItemsBuilder(Material.SKULL_ITEM, 1, (byte) 3)
                .setName("§6§n"+player.getName())
                .setSkullOwner(player.getName());
        if(player.hasPermission("staff.use") && player.hasPermission("vipplus.use") || player.hasPermission("friend.use") && player.hasPermission("vipplus.use") || player.hasPermission("partner.use") && player.hasPermission("vipplus.use") || player.hasPermission("youtuber.use") && player.hasPermission("vipplus.use")) {
                    profil.setLore(Arrays.asList("§eGrade: "+ main.getAPI().get().getRankWithColors(player.getUniqueId())+ ChatColor.GRAY+"/"+ChatColor.GOLD+"VIP+",
                            "§eCrédits: §6" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                            "§eCoins: §6"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                            "§eNiveau: §6" + main.getAPI().get().getLevel(player.getUniqueId()),
                            "§eExp: §6"+ main.getAPI().get().getExp(player.getUniqueId())+" / "+ main.getAPI().get().getXPfromLevel(main.getAPI().get().getLevel(player.getUniqueId()))));

        } else if(player.hasPermission("staff.use") && player.hasPermission("vip.use") || player.hasPermission("friend.use") && player.hasPermission("vip.use") || player.hasPermission("partner.use") && player.hasPermission("vip.use") || player.hasPermission("youtuber.use") && player.hasPermission("vip.use")) {
            profil.setLore(Arrays.asList("§eGrade: "+ main.getAPI().get().getRankWithColors(player.getUniqueId())+ ChatColor.GRAY+"/"+ChatColor.YELLOW+"VIP",
                    "§eCrédits: §6" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                    "§eCoins: §6"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                    "§eNiveau: §6" + main.getAPI().get().getLevel(player.getUniqueId()),
                    "§eExp: §6"+ main.getAPI().get().getExp(player.getUniqueId())+" / "+ main.getAPI().get().getXPfromLevel(main.getAPI().get().getLevel(player.getUniqueId()))));

        } else if(player.hasPermission("vipplus.use")){
            profil.setLore(Arrays.asList("§eGrade: "+ChatColor.GOLD+"VIP+",
                    "§eCrédits: §6" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                    "§eCoins: §6"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                    "§eNiveau: §6" + main.getAPI().get().getLevel(player.getUniqueId()),
                    "§eExp: §6"+ main.getAPI().get().getExp(player.getUniqueId())+" / "+ main.getAPI().get().getXPfromLevel(main.getAPI().get().getLevel(player.getUniqueId()))));

        } else if(player.hasPermission("vip.use")){
            profil.setLore(Arrays.asList("§eGrade: "+ChatColor.GOLD+"VIP",
                    "§eCrédits: §6" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                    "§eCoins: §6"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                    "§eNiveau: §6" + main.getAPI().get().getLevel(player.getUniqueId()),
                    "§eExp: §6"+ main.getAPI().get().getExp(player.getUniqueId())+" / "+ main.getAPI().get().getXPfromLevel(main.getAPI().get().getLevel(player.getUniqueId()))));
        } else {
            profil.setLore(Arrays.asList("§eGrade: "+ main.getAPI().get().getRankWithColors(player.getUniqueId()),
                    "§eCrédits: §6" + main.getAPI().get().getCredits(player.getUniqueId()) + " \u24D2",
                    "§eCoins: §6"+ main.getAPI().get().getCoins(player.getUniqueId()) + " \u26C3",
                    "§eNiveau: §6" + main.getAPI().get().getLevel(player.getUniqueId()),
                    "§eExp: §6"+ main.getAPI().get().getExp(player.getUniqueId())+" / "+ main.getAPI().get().getXPfromLevel(main.getAPI().get().getLevel(player.getUniqueId()))));
        }
        inv.setItem(4,profil.toItemStack());

        ItemsBuilder Pvpbox = new ItemsBuilder(Material.IRON_SWORD)
                .setName("§6§nPvpbox")
                .setFlags(ItemFlag.HIDE_ATTRIBUTES)
                .setLore(Arrays.asList("§eKills: §6"+"main.getAPI().getUserManager().getUser(player.getUniqueId()).getKills(player)", "§eMorts: §6"+"api.getPvPBoxManager().getDeaths(player)"));
        inv.setItem(20,Pvpbox.toItemStack());

        ItemsBuilder DeACoudre = new ItemsBuilder(Material.WOOL, 1, (byte) 1)
                .setName("§6§nDéACoudre")
                .setLore(Arrays.asList("§eDAC réalisé: §60","§ePartie gagnée: §60", "§ePartie perdue: §60"));
        inv.setItem(21,DeACoudre.toItemStack());

        ItemsBuilder Punch = new ItemsBuilder(Material.STICK)
                .setName("§6§nPunch")
                .setLore(Arrays.asList("§ePartie gagnée: §60", "§ePartie perdue: §60"));
        inv.setItem(22,Punch.toItemStack());

        ItemsBuilder UHCRun = new ItemsBuilder(Material.GOLDEN_APPLE)
                .setName("§6§nUHC Run")
                .setLore(Arrays.asList("§eKills: §60", "§ePartie gagnée: §60", "§ePartie perdue: §60"));
            inv.setItem(23,UHCRun.toItemStack());

        ItemsBuilder DeathNoteUHC = new ItemsBuilder(Material.BOOK)
                .setName("§6§nDeathNoteUHC")
                .setLore(Arrays.asList("§eKills: §60", "§ePartie gagnée: §60", "§ePartie perdue: §60"));
        inv.setItem(24,DeathNoteUHC.toItemStack());

        ItemsBuilder SurvivalGames = new ItemsBuilder(Material.APPLE)
                .setName("§6§nSurvival Games")
                .setLore(Arrays.asList("§eKills: §60", "§ePartie gagnée: §60", "§ePartie perdue: §60"));
        inv.setItem(29,SurvivalGames.toItemStack());

        ItemsBuilder HideAndSeek = new ItemsBuilder(Material.SLIME_BLOCK)
                .setName("§6§nHide And Seek")
                .setLore(Arrays.asList("§eKills: §60", "§ePartie gagnée: §60", "§ePartie perdue: §60"));
        inv.setItem(30,HideAndSeek.toItemStack());

        ItemsBuilder PlantTheBomb = new ItemsBuilder(Material.REDSTONE_TORCH_ON)
                .setName("§6§nPlant The Bomb")
                .setLore(Arrays.asList("§eKills: §60", "§ePartie gagnée: §60", "§ePartie perdue: §60"));
        inv.setItem(32,PlantTheBomb.toItemStack());

        ItemsBuilder AmongBlocks = new ItemsBuilder(Material.POWERED_RAIL)
                .setName("§6§nAmong Blocks")
                .setLore(Arrays.asList("§eTâches faites: §60", "§eKills: §60","§ePartie gagnée: §60", "§ePartie perdue: §60"));
        inv.setItem(33,AmongBlocks.toItemStack());

        ItemsBuilder Amis = new ItemsBuilder(Material.RAW_FISH)
                .setName("§6§nAmis")
                .setLore("§eVous avez des amis?");
        inv.setItem(45,Amis.toItemStack());

        ItemsBuilder Parametres = new ItemsBuilder(Material.REDSTONE_COMPARATOR)
                .setName("§6§nParamètres")
                .setLore("§eQuels sont vos préférences?");
        inv.setItem(47,Parametres.toItemStack());
        
        ItemsBuilder Languages = new ItemsBuilder(setSkullID("98daa1e3ed94ff3e33e1d4c6e43f024c47d78a57ba4d38e75e7c9264106"))
                .setName("§6§nLangues")
                .setLore("§eVous parler français?");
        inv.setItem(49,Languages.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                player.closeInventory();
                break;

            case REDSTONE_COMPARATOR:
                main.getGuiManager().open(player, Settings.class);
                break;

            default: break;
        }

        if (current.getType() == Material.RAW_FISH) {
            main.getGuiManager().open(player, Friends.class);
        }

        if (current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nLangues")) {
            main.getGuiManager().open(player, Languages.class);
        }
    }
}
