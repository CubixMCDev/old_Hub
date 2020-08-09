package eu.cubix.mc.hub.crates;

import eu.cubix.mc.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Vote implements Listener {

    private final Main main;
    Map<UUID, Integer> crateUsesMap;
    Random random;

    String[] prizes = {"Material:Diamond:&e&lDiamant", "Material:Dirt:&e&lTerre", "Money:Coins:&e&lCoins"};

    public Vote(Main main) {
        this.main = main;
        this.random = new Random();
        this.crateUsesMap = new HashMap<UUID, Integer>();
    }

    String choosePrize() {
        return prizes[this.random.nextInt(prizes.length)];
    }

    Material[] items = {Material.DIAMOND, Material.DIRT};

    public void activateCrate(Player player) {
        this.crateUsesMap.putIfAbsent(player.getUniqueId(), 0);
        this.crateUsesMap.put(player.getUniqueId(), this.crateUsesMap.get(player.getUniqueId()) + 1);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.BLACK + "Caisse | Clé vote");
        player.openInventory(inventory);
        startInventory(inventory, player);
    }

    void startInventory(final Inventory inventory, final Player player) {
        startFrame((short) 5, 0L, ChatColor.GOLD, inventory, player);
        startFrame((short) 6, 10L, ChatColor.GOLD, inventory, player);
        startFrame((short) 7, 15L, ChatColor.GOLD, inventory, player);
        startFrame((short) 1, 20L, ChatColor.GOLD, inventory, player);
        startFrame((short) 2, 25L, ChatColor.GOLD, inventory, player);
        startFrame((short) 3, 30L, ChatColor.GOLD, inventory, player);
        startFrame((short) 4, 35L, ChatColor.GOLD, inventory, player);
        startFrame((short) 9, 40L, ChatColor.GOLD, inventory, player);
        startFrame((short) 10, 45L, ChatColor.GOLD, inventory, player);
        selectPrize(player, inventory);
    }

     void startFrame(final short sh, final long delay, final ChatColor chatColor, final Inventory inventory, final Player player) {
        final Sound sound = Sound.ORB_PICKUP;

        new BukkitRunnable() {
            public void run() {
                for (int x = 0; x < inventory.getSize(); x++) {
                    inventory.setItem(x, new ItemStack(Material.STAINED_GLASS_PANE, 1, sh));
                }
                ItemStack is = new ItemStack(items[random.nextInt(items.length)]);
                ItemMeta im = is.getItemMeta();
                im.setDisplayName(chatColor + "?");
                is.setItemMeta(im);
                inventory.setItem(13, is);
                player.playSound(player.getLocation(), sound, 1, 1);

                cancel();
            }
        }.runTaskLater(main, delay);
    }

    void selectPrize(final  Player player, final Inventory inventory) {
        new BukkitRunnable() {

            @Override
            public void run() {
                String prize = choosePrize();
                String[] prizeIndex = prize.split(":");

                if (prize.contains("Money")) {
                    // CODE POUR GAGNER

                    ItemStack prizeItem = new ItemStack(Material.DOUBLE_PLANT);
                    ItemMeta prizeMeta = prizeItem.getItemMeta();
                    prizeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6Item "+prizeIndex[2]));
                    prizeItem.setItemMeta(prizeMeta);
                    inventory.setItem(13, prizeItem);
                } else if (prize.contains("Material")) {
                    player.getInventory().addItem(new ItemStack(Material.valueOf(prizeIndex[1].toUpperCase())));

                    ItemStack prizeItem = new ItemStack(Material.matchMaterial(prizeIndex[1].toUpperCase()));
                    ItemMeta prizeMeta = prizeItem.getItemMeta();
                    prizeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6Item: "+prizeIndex[2]));
                    prizeItem.setItemMeta(prizeMeta);
                    inventory.setItem(13, prizeItem);
                }
            }
        }.runTaskLater(main, 55L);
    }

    @EventHandler
    public void onInterract(PlayerInteractEvent e) {

        if(!e.hasItem()) {
            return;
        } else if(!e.hasBlock()) {
            return;
        } else if(!e.getItem().hasItemMeta()) {
            return;
        } else if(e.getClickedBlock().getType() != Material.ENDER_CHEST) {
            return;
        } else if(e.getItem().getType() != Material.TRIPWIRE_HOOK) {
            return;
        } else if(!e.getItem().getItemMeta().getDisplayName().equals("§6Clé de vote")) {
            return;
        }

        Player player = e.getPlayer();
        ItemStack newItemStack = new ItemStack(e.getItem().getType(), e.getItem().getAmount()-1);
        ItemMeta newItemStackMeta = e.getItem().getItemMeta();

        newItemStack.setItemMeta(newItemStackMeta);

        player.setItemInHand(newItemStack);

        this.activateCrate(player);

        e.setCancelled(true);

        player.sendMessage("§eCubixMC §6» §eVous avez utilisé votre §6Clé de vote§e.");
    }

}
