package eu.cubix.mc.hub.cosmetics.gadgets;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.inventory.Particles;
import eu.cubix.mc.hub.tools.GadgetBuilder;
import eu.cubix.mc.hub.tools.ItemUtil;
import eu.cubix.mc.hub.tools.ParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree extends GadgetBuilder implements Listener {

    private final Main main;

    private List<Projectile> projectiles = new ArrayList<>();

    public ChristmasTree(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return ChatColor.GOLD+"Gadget: "+ ChatColor.YELLOW+"Arbre de Noël";
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.SAPLING, 1, (byte) 1);
    }

    @Override
    public int cooldown() {
        return 8;
    }

    @Override
    public void onInteract(Player player) {
        for (int i = 0; i < 5; i++)
            projectiles.add(player.getPlayer().launchProjectile(Snowball.class));
        new BukkitRunnable() {
            @Override
            public void run() {
                HandlerList.unregisterAll(ChristmasTree.this);
            }
        }.runTaskTimer(main, 20, 0);
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        ParticleEffect particleEffect = new ParticleEffect(player);

        if (!projectiles.contains(projectile)) return;

        Location location = projectile.getLocation();

        for (Projectile snowball : projectiles)
            snowball.remove();

        particleEffect.drawParticle(EnumParticle.LAVA, event.getLocation(),0,0,0,
                0f, 16);
        for(Player p : Bukkit.getOnlinePlayers())
            particleEffect.sendToPlayer(p);
        particleEffect.drawParticle(EnumParticle.HEART, event.getLocation(),0,0,0,
                0f, 20);
        for(Player p : Bukkit.getOnlinePlayers())
            particleEffect.sendToPlayer(p);
        player.playSound(player.getLocation(), Sound.CAT_PURREOW, 1.4f, 1.5f);
    }
}
