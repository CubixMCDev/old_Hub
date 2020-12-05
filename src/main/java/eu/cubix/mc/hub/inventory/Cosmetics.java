package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Cosmetics implements GuiBuilder {

    private final Main main;

    public Cosmetics(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Cosmétiques";
    }

    @Override
    public int getSize() {
        return 54;
    }

    @Override
    public void contents(Player player, Inventory inv) {

        ItemsBuilder Separateur = new ItemsBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4)
                .setName(" ");
        inv.setItem(0,Separateur.toItemStack());
        inv.setItem(1,Separateur.toItemStack());
        inv.setItem(2,Separateur.toItemStack());
        inv.setItem(3,Separateur.toItemStack());
        inv.setItem(4,Separateur.toItemStack());
        inv.setItem(5,Separateur.toItemStack());
        inv.setItem(6,Separateur.toItemStack());
        inv.setItem(7,Separateur.toItemStack());
        inv.setItem(8,Separateur.toItemStack());
        inv.setItem(9,Separateur.toItemStack());
        inv.setItem(17,Separateur.toItemStack());
        inv.setItem(18,Separateur.toItemStack());
        inv.setItem(26,Separateur.toItemStack());
        inv.setItem(27,Separateur.toItemStack());
        inv.setItem(35,Separateur.toItemStack());
        inv.setItem(36,Separateur.toItemStack());
        inv.setItem(44,Separateur.toItemStack());
        inv.setItem(46,Separateur.toItemStack());
        inv.setItem(45,Separateur.toItemStack());
        inv.setItem(47,Separateur.toItemStack());
        inv.setItem(48,Separateur.toItemStack());
        inv.setItem(50,Separateur.toItemStack());
        inv.setItem(51,Separateur.toItemStack());
        inv.setItem(52,Separateur.toItemStack());

        ItemsBuilder Pets = new ItemsBuilder(Material.BONE)
                .setName("§6§nCompagnons");
        inv.setItem(20,Pets.toItemStack());

        ItemsBuilder Gadgets = new ItemsBuilder(Material.PISTON_BASE)
                .setName("§6§nGadgets");
        inv.setItem(22,Gadgets.toItemStack());

        ItemsBuilder Particles = new ItemsBuilder(Material.REDSTONE)
                .setName("§6§nParticules");
        inv.setItem(24,Particles.toItemStack());

        ItemsBuilder Mounts = new ItemsBuilder(Material.SADDLE)
                .setName("§6§nMontures");
        inv.setItem(30,Mounts.toItemStack());

        ItemsBuilder Effects = new ItemsBuilder(Material.REDSTONE_BLOCK)
                .setName("§6§nEffets");
        inv.setItem(32,Effects.toItemStack());

        ItemsBuilder Retired = new ItemsBuilder(Material.BARRIER)
                .setName("§6§nRetirer vos cosmétiques");
        inv.setItem(49,Retired.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            case BONE:
                main.getGuiManager().open(player, Pets.class);
                break;

            case PISTON_BASE:
                main.getGuiManager().open(player, Gadgets.class);
                break;

            case REDSTONE:
                main.getGuiManager().open(player, Particles.class);
                break;

            case SADDLE:
                main.getGuiManager().open(player, Mounts.class);
                break;

            case REDSTONE_BLOCK:
                main.getGuiManager().open(player, Effects.class);
                break;

            case BARRIER:
                ParticleData particle = new ParticleData(player.getUniqueId());

                player.getInventory().setItem(6,new ItemStack(Material.AIR));
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                for (PotionEffect effect : player.getActivePotionEffects())
                    player.removePotionEffect(effect.getType());
                player.setSneaking(true);
                player.closeInventory();
                break;

            case DARK_OAK_DOOR_ITEM:
                player.closeInventory();
                break;

            default: break;
        }
    }
}
