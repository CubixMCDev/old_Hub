package eu.cubix.mc.hub.tools;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ParticleEffect {

    PacketPlayOutWorldParticles packet;
    Player player;

    public ParticleEffect(Player player) {
        this.player = player;
    }

    public void drawParticle(EnumParticle particle, Location loc, float xOffset, float yOffset, float zOffset, float speed, int count) {
        float x = (float) loc.getX();
        float y = (float) loc.getY();
        float z = (float) loc.getZ();
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, true, x, y, z, xOffset, yOffset,
                zOffset, speed, count, null);
        this.packet = packet;
    }

    public void drawColorParticle(Location loc, float r, float g, float b) {
        float x = (float) loc.getX();
        float y = (float) loc.getY();
        float z = (float) loc.getZ();

        float finalR = r / 255;
        float finalG = g / 255;
        float finalB = b / 255;

        Location location = player.getLocation().add(0, 2, 0);
        Color color = Color.fromBGR(193, 255, 0);
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float) x, y, z, finalR, finalG, finalB, (float) 1, 0);
        this.packet = packet;
    }

    public void sendToPlayer(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}