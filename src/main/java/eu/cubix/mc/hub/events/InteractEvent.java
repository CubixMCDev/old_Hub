package eu.cubix.mc.hub.events;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.inventory.Cosmetics;
import eu.cubix.mc.hub.inventory.Menu;
import eu.cubix.mc.hub.inventory.Profile;
import eu.cubix.mc.hub.inventory.Shop;
import eu.cubix.mc.hub.queue.Queue;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractEvent implements Listener {

    Main main;

    public InteractEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack it = e.getItem();

        if(it != null && it.getType() == Material.SKULL_ITEM && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Profil")){
            main.getGuiManager().open(player, Profile.class);
        }
        if(it != null && it.getType() == Material.COMPASS && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Menu")){
            main.getGuiManager().open(player, Menu.class);
        }
        if(it != null && it.getType() == Material.FLINT && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Rejoindre le chef de groupe")){
            player.chat("/party tp");
        }
        if(it != null && it.getType() == Material.ENDER_CHEST && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Cosmétiques")){
            main.getGuiManager().open(player, Cosmetics.class);
        }
        if(it != null && it.getType() == Material.GOLD_INGOT && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Boutique")){
            main.getGuiManager().open(player, Shop.class);
        }
        if(it != null && it.getType() == Material.BARRIER && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Quitter la file d'attente")) {
            Queue.getPlayers().remove(player);
            player.getInventory().setItem(4, new ItemStack(Material.AIR));
            player.sendMessage("§eCubixMC §6» §eVous avez quitter la file d'attente.");
        }
    }
}