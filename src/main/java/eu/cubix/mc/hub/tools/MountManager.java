package eu.cubix.mc.hub.tools;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.cosmetics.mounts.*;
import net.minecraft.server.v1_8_R3.EntityAgeable;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MountManager {

    public static float mountSpeed = 0.15f;

    public static boolean shouldDie(EntityLiving  mount, Player player) {
        if(mount.passenger == null || !(mount.passenger instanceof EntityHuman)) {
            mount.die();
            return true;
        }
        return false;
    }

    public static void rideVillager(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableVillager(nmsWorld), player);
    }

    public static void rideCat(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableOcelot(nmsWorld), player);
    }

    public static void rideChicken(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableChicken(nmsWorld), player);
    }

    public static void rideCow(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableCow(nmsWorld), player);
    }

    public static void rideCreeper(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableCreeper(nmsWorld), player);
    }

    public static void rideHorse(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableHorse(nmsWorld), player);
    }

    public static void ridePig(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideablePig(nmsWorld), player);
    }

    public static void rideRabbit(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableRabbit(nmsWorld), player);
    }

    public static void rideSheep(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableSheep(nmsWorld), player);
    }

    public static void rideSpider(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableSpider(nmsWorld), player);
    }

    public static void rideZombie(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableZombie(nmsWorld), player);
    }

    public static void rideBlaze(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableBlaze(nmsWorld), player);
    }

    public static void rideCaveSpider(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableCaveSpider(nmsWorld), player);
    }

    public static void rideEnderman(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableEnderman(nmsWorld), player);
    }

    public static void rideEndermite(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableEndermite(nmsWorld), player);
    }

    public static void rideGuardian(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableGuardian(nmsWorld), player);
    }

    public static void rideMagmaCube(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableMagmaCube(nmsWorld), player);
    }

    public static void rideMushroomCow(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableMushroomCow(nmsWorld), player);
    }

    public static void ridePigZombie(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideablePigZombie(nmsWorld), player);
    }

    public static void rideSilverfish(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableSilverfish(nmsWorld), player);
    }

    public static void rideSkeleton(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableSkeleton(nmsWorld), player);
    }

    public static void rideSlime(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableSlime(nmsWorld), player);
    }

    public static void rideSquid(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableSquid(nmsWorld), player);
    }

    public static void rideWitch(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableWitch(nmsWorld), player);
    }

    public static void rideWolf(Main main, Player player) {
        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        make(main, new RideableWolf(nmsWorld), player);
    }

    public static void make(Main main, EntityLiving nmsEntity, Player player) {
        if(!canSummonMount(player.getLocation())) {
            player.sendMessage(main.prefixError+ ChatColor.RED+"Il n'y a pas assez de place pour invoquer la monture !");
            return;
        }

        LivingEntity mount = (LivingEntity) nmsEntity.getBukkitEntity();

        if(mount instanceof EntityAgeable) ((EntityAgeable) mount).setAge(0);

        Location loc = player.getLocation();
        World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        nmsEntity.setPosition(loc.getX(), loc.getY()+0.3, loc.getZ());
        nmsWorld.addEntity(nmsEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        mount.setPassenger(player);
        mount.resetMaxHealth();
    }

    public static boolean canSummonMount(Location loc) {
        org.bukkit.World world = loc.getWorld();
        Block block = loc.getBlock();

        for(int x = loc.getBlockX() - 1; x <= loc.getBlockX() + 1; x++) {
            for(int y = loc.getBlockY(); y <= loc.getBlockY() + 1; y++) {
                for(int z = loc.getBlockZ() - 1; z <= loc.getBlockZ() + 1; z++) {
                    block = world.getBlockAt(x,y,z);
                    if(block.getType().isSolid()) return false;
                }
            }
        }
        return true;
    }
}
