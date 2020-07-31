package eu.cubix.mc.hub.tools;

import net.minecraft.server.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hologram {

    public static final double distance = 0.25;
    public List<String> lines = new ArrayList<String>();
    private Location location;
    private final List<Integer> ids;

    public Hologram(String...lines){
        this.lines.addAll(Arrays.asList(lines));
        this.ids = new ArrayList<Integer>();
    }

    public void change(Player p, Location location, String...lines){
        destroy(p);
        this.lines = Arrays.asList(lines);
        show(p, location);
    }

    public void show(Player p, Location loc) {
        Location first = loc.clone().add(0, (this.lines.size() / 2) * distance, 0);
        for(int i = 0; i < this.lines.size(); i++){
            showLine(p, first.clone(), this.lines.get(i));
            first.subtract(0, distance, 0);
        }
    }

    public void destroy(Player p) {
        int[] ints = new int[this.ids.size()];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = ids.get(j);
        }
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(ints);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        this.location = null;
    }

    private void showLine(Player p , Location loc, String text){

        EntityPlayer nmsPlayer = ((CraftPlayer) p).getHandle();
        WorldServer world = ((CraftWorld) loc.getWorld()).getHandle();
        EntityArmorStand as = new EntityArmorStand(world);
        as.setCustomName(text);
        as.setCustomNameVisible(true);
        as.setGravity(false);
        as.setBasePlate(false);
        as.setInvisible(true);
        as.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());

        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(as);

        nmsPlayer.playerConnection.sendPacket(packet);

    }
}
