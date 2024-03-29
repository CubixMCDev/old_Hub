package eu.cubix.mc.hub.commands;

import eu.cubix.mc.hub.Main;
import org.bukkit.ChatColor;
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
            if (player.hasPermission("*") || player.hasPermission("key.use")) {
                ItemStack voteKey = new ItemStack(Material.TRIPWIRE_HOOK);
                ItemMeta meta = voteKey.getItemMeta();
                meta.setDisplayName(ChatColor.GOLD+"Clé de vote");
                meta.setLore(Collections.singletonList(ChatColor.YELLOW+"Type: Commun"));
                meta.addEnchant(Enchantment.LUCK, 10, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                voteKey.setItemMeta(meta);

                player.getInventory().addItem(voteKey);
            } else {
                player.sendMessage(main.prefixError+ChatColor.RED+"Erreur: commande inconnue.");
            }
        }
        return false;
    }
}
