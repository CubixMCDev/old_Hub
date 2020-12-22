package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import org.bukkit.*;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EtherealPearl extends GadgetBuilder implements Listener {

    private Main main;

    Random r = new Random();

    HashMap<Player, BukkitRunnable> runnableHashMap = new HashMap<>();
    ArrayList<EnderPearl> pearls = new ArrayList<>();

    public EtherealPearl(Main main) {
        this.main = main;

        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ChatColor.YELLOW+"Perle de l'Ender";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.ENDER_PEARL, 1);
    }

    @Override
    public int cooldown() {
        return 10;
    }

    @Override
    public void onInteract(Player player) {
        if (runnableHashMap.containsKey(player.getPlayer())) {
            if (player.getPlayer().getVehicle() != null)
                player.getPlayer().remove();
            player.getPlayer().eject();
            if (player.getPlayer().getGameMode() != GameMode.CREATIVE)
                player.getPlayer().setAllowFlight(false);
            runnableHashMap.get(player.getPlayer()).cancel();
            runnableHashMap.remove(player.getPlayer());
            spawnRandomFirework(player.getPlayer().getLocation(), player);
        }
        final EnderPearl pearl = player.getPlayer().launchProjectile(EnderPearl.class);
        pearl.setVelocity(player.getPlayer().getEyeLocation().getDirection().multiply(1.53d));
        pearl.setPassenger(player.getPlayer());
        player.getPlayer().teleport(player.getPlayer().getLocation().add(0, 5, 0));
        pearls.add(pearl);
        if (!player.getPlayer().getAllowFlight()) {
            player.getPlayer().setAllowFlight(true);
        }
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if (pearl.isValid()) {
                    player.getPlayer().eject();
                    pearl.setPassenger(player.getPlayer());
                } else {
                    pearl.remove();
                    player.getPlayer().eject();
                    if (player.getPlayer().getGameMode() != GameMode.CREATIVE && player.hasPermission("staff.use")) {
                        player.getPlayer().setAllowFlight(true);
                    } else if(player.getPlayer().getGameMode() != GameMode.CREATIVE){
                        player.getPlayer().setAllowFlight(false);
                    }
                    runnableHashMap.remove(player.getPlayer());
                    spawnRandomFirework(player.getPlayer().getLocation(), player);
                    cancel();
                }
            }
        };
        runnableHashMap.put(player.getPlayer(), runnable);
        runnable.runTaskTimer(main, 0, 10);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && runnableHashMap.containsKey((Player) event.getEntity()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onToggleSneak(PlayerToggleSneakEvent event) {
        if (runnableHashMap.containsKey(event.getPlayer()) && event.getPlayer().getName().equals(event.getPlayer().getName())) {
            event.getPlayer().eject();
            if (event.getPlayer().getGameMode() != GameMode.CREATIVE)
                event.getPlayer().setAllowFlight(false);
            runnableHashMap.get(event.getPlayer()).cancel();
            runnableHashMap.remove(event.getPlayer());
            spawnRandomFirework(event.getPlayer().getLocation(), event.getPlayer());
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof EnderPearl) {
            if (pearls.contains(event.getEntity())) {
                pearls.remove(event.getEntity());
                event.getEntity().remove();
            }
            /*if (event.getEntity().getPassenger() != null) {
                Bukkit.broadcastMessage("b");
                // && event.getEntity().getPassenger() == getPlayer()
                if (runnableHashMap.containsKey(event.getEntity().getPassenger())) {
                    Bukkit.broadcastMessage("c");
                    if (((Player) event.getEntity().getPassenger()).getName().equals(getPlayer().getName())){
                        Bukkit.broadcastMessage("d");
                        getPlayer().eject();
                        runnableHashMap.remove( event.getEntity().getPassenger());
                        event.getEntity().remove();
                    }
                }
            }*/
        }
    }

    public FireworkEffect getRandomFireworkEffect() {
        FireworkEffect.Builder builder = FireworkEffect.builder();
        FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.fromRGB(100, 0, 100)).withFade(Color.fromRGB(30, 0, 30)).build();
        return effect;
    }

    public void spawnRandomFirework(Location location, Player player) {
        final ArrayList<Firework> fireworks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final Firework f = player.getPlayer().getWorld().spawn(location, Firework.class);

            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(getRandomFireworkEffect());
            f.setFireworkMeta(fm);
            fireworks.add(f);
        }
        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                for (Firework f : fireworks)
                    f.detonate();
            }
        }, 2);
    }
}
