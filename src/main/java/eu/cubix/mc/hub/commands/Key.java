package eu.cubix.mc.hub.commands;

import eu.cubix.mc.hub.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Key implements CommandExecutor {

    private final Main main;

    public Key(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(!(cs instanceof Player)) {
            return true;
        }
        Player player = (Player) cs;

        if(cmd.getName().equalsIgnoreCase("key")) {
            if (player.hasPermission("*")) {
                ItemStack voteKey = new ItemStack(Material.TRIPWIRE_HOOK);
                ItemMeta meta = voteKey.getItemMeta();
                meta.setDisplayName("§6Clé de vote");
                meta.setLore(Collections.singletonList("§eType: Commun"));
                meta.addEnchant(Enchantment.LUCK, 10, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                voteKey.setItemMeta(meta);

                player.getInventory().addItem(voteKey);
            } else {
                player.sendMessage("§cCubixMC §4» §cErreur: commande inconnue.");
            }
        }
        return false;
    }
}
