package eu.cubix.mc.hub.tools;

import eu.cubix.mc.hub.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class GadgetsManager implements Listener {

    private final Main main;
    private final HashMap<String, Long> cooldowns = new HashMap<>();

    public GadgetsManager(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onClickInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        ItemStack it = event.getItem();

        if(it == null) return;

        main.getGadgets().stream().filter(gadget -> it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(gadget.name())).forEach(gadget -> {
                    int cooldowntime = gadget.cooldown();
                    if(cooldowns.containsKey(player.getName())) {

                        long seconds = ((cooldowns.get(player.getName()) / 1000) + cooldowntime) - (System.currentTimeMillis() / 1000);

                        if(seconds > 0){
                            player.sendMessage("§eCubixMC §6» §eVous devez attendre §6" + seconds + " seconde(s) §eavant d'utiliser ce gadget.");
                            return;
                        }
                    }

                    event.setCancelled(true);
                    cooldowns.put(player.getName(), System.currentTimeMillis());

                    gadget.onInteract(player);
        });
        player.updateInventory();
    }
}
