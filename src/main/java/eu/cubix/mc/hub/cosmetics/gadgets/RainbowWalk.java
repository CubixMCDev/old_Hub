package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import eu.cubix.mc.hub.tools.SimpleBlock;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class RainbowWalk extends GadgetBuilder implements Listener {

    private final Main main;
    private Player player;
    protected final Map<Location, SimpleBlock> blocksUsed;
    protected final Map<Location, SimpleBlock> blocksBefore;
    protected final List<UUID> interactingPlayers;

    public RainbowWalk(Main main, Player player) {
        this.main = main;
        this.player = player;

        this.blocksUsed = new HashMap<>();
        this.blocksBefore = new HashMap<>();
        this.interactingPlayers = new ArrayList<>();
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ChatColor.YELLOW+"Promenade Arc-en-ciel";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.STAINED_CLAY, 1, (byte) 4);
    }

    @Override
    public int cooldown() {
        return 20;
    }

    @Override
    public void onInteract(Player player) {
        new BukkitRunnable()
        {
            private int times = 0;

            @Override
            public void run()
            {
                if (this.times < 50)
                {
                    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);

                    if (block.getType() != Material.AIR && !isBlockGloballyUsed(block.getLocation()))
                    {
                        SimpleBlock simpleBlock = new SimpleBlock(Material.STAINED_CLAY, DyeColor.values()[new Random().nextInt(DyeColor.values().length)].getWoolData());
                        addBlockToUse(block.getLocation(), simpleBlock);

                        block.setType(simpleBlock.getType());
                        block.setData(simpleBlock.getData());

                        main.getServer().getScheduler().runTaskLater(main, () -> restore(block.getLocation()), 20L * 5);
                    }
                }
                else if (this.times == 150)
                {
                    restore();

                    this.cancel();
                }

                this.times++;
            }
        }.runTaskTimer(main, 5L, 5L);
    }

    public void addBlockToUse(Location location, SimpleBlock block)
    {
        this.blocksUsed.put(new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ()), block);
        this.blocksBefore.put(new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ()), new SimpleBlock(location.getBlock()));
    }

    public void addBlocksToUse(Map<Location, SimpleBlock> blocks)
    {
        for (Location block : blocks.keySet())
        {
            this.blocksUsed.put(new Location(block.getWorld(), block.getBlockX(), block.getBlockY(), block.getBlockZ()), blocks.get(block));
            this.blocksBefore.put(new Location(block.getWorld(), block.getBlockX(), block.getBlockY(), block.getBlockZ()), new SimpleBlock(block.getBlock()));
        }
    }

    public void interactWith(Player player)
    {
        this.interactingPlayers.add(player.getUniqueId());
    }

    public boolean isBlockGloballyUsed(Location location)
    {
        return isBlockUsed(location);
    }

    public void restore()
    {
        for (Location block : this.blocksUsed.keySet())
        {
            block.getBlock().setType(this.blocksBefore.get(block).getType());
            block.getBlock().setData(this.blocksBefore.get(block).getData());
        }

        this.blocksUsed.clear();
        this.blocksBefore.clear();
    }

    public void restore(Location location)
    {
        Location finalLocation = new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());

        if (this.blocksUsed.containsKey(finalLocation) && this.blocksBefore.containsKey(finalLocation))
        {
            this.blocksUsed.remove(finalLocation);
            finalLocation.getBlock().setType(this.blocksBefore.get(finalLocation).getType());
            finalLocation.getBlock().setData(this.blocksBefore.get(finalLocation).getData());
            this.blocksBefore.remove(finalLocation);
        }
    }

    public Player getPlayer()
    {
        return this.player;
    }

    public Map<Location, SimpleBlock> getBlocksUsed()
    {
        return this.blocksUsed;
    }

    public boolean isBlockUsed(Location location)
    {
        return this.blocksUsed.containsKey(new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ()));
    }

    public boolean isInteractingWith(Player player)
    {
        return this.interactingPlayers.contains(player.getUniqueId());
    }
}
