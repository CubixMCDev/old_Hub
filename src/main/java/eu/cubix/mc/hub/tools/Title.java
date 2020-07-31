package eu.cubix.mc.hub.tools;

import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.PacketPlayOutTitle;
import net.minecraft.server.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class Title {

    private String title;
    private String subtitle;

    /**
     * Cr�er un Title avec un message principal
     * @param title le message principal
     */
    public Title(String title) {
        this.title = title;
        subtitle = "";
    }

    /**
     * Cr�er un Title avec un message principal et un sous-message
     * @param title le message principal
     * @param subtitle le sous-message
     */
    public Title(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    /**
     * Envoyer le Title � un joueur
     * @param player le joueur � qui envoyer le Title
     * @param fadeIn le temps de fondu en ouverture
     * @param stay le temps d'affichage
     * @param fadeOut le temps de fondu en fermeture
     */
    public void send(Player player, int fadeIn, int stay, int fadeOut) {
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn * 20, stay * 20, fadeOut * 20);
        connection.sendPacket(packetPlayOutTimes);
        if (subtitle != null) {
            subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
            subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
            IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
            PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
            connection.sendPacket(packetPlayOutSubTitle);
        }
        if (title != null) {
            title = title.replaceAll("%player%", player.getDisplayName());
            title = ChatColor.translateAlternateColorCodes('&', title);
            IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
            PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
            connection.sendPacket(packetPlayOutTitle);
        }
    }

    /**
     * Envoyer le Title � plusieurs joueurs
     * @param players les joueurs � qui envoyer le Title
     * @param fadeIn le temps de fondu en ouverture
     * @param stay le temps d'affichage
     * @param fadeOut le temps de fondu en fermeture
     */
    public void send(Collection<? extends Player> players, int fadeIn, int stay, int fadeOut){
        players.forEach(p -> send(p, fadeIn, stay, fadeOut));
    }
}