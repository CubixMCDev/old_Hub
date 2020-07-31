package eu.cubix.mc.hub.tools;

import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.PacketPlayOutChat;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar {
    private final PacketPlayOutChat packet;

    public ActionBar(String message) {
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\""+message+"\"}"), (byte) 2);
        this.packet = packet;
    }

    public void send(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}