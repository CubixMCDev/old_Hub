package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.cosmetics.particles.*;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Particles implements GuiBuilder {
    private final Main main;

    public Particles(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Cosmétiques » Particules";
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

        if(!main.getCosmeticsManager().hasCosmetic("particleEmerald",player.getUniqueId())) {
            ItemsBuilder Emerald = new ItemsBuilder(Material.EMERALD)
                    .setName("§6§nEmeraude");
            inv.setItem(10, Emerald.toItemStack());
        } else {
            ItemsBuilder Emerald = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nEmeraude");
            inv.setItem(10,Emerald.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("particleHeart",player.getUniqueId())) {
            ItemsBuilder Heart = new ItemsBuilder(Material.RED_ROSE)
                    .setName("§6§nCoeur");
            inv.setItem(11,Heart.toItemStack());
        } else {
            ItemsBuilder Heart = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCoeur");
            inv.setItem(11,Heart.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("particleAngry",player.getUniqueId())) {
            ItemsBuilder Angry = new ItemsBuilder(Material.FIREBALL)
                    .setName("§6§nColère");
            inv.setItem(12,Angry.toItemStack());
        } else {
            ItemsBuilder Angry = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nColère");
            inv.setItem(12,Angry.toItemStack());
        }

        if(!main.getCosmeticsManager().hasCosmetic("particleFlame",player.getUniqueId())) {
            ItemsBuilder Flame = new ItemsBuilder(Material.FLINT_AND_STEEL)
                    .setName("§6§nFeu");
            inv.setItem(13,Flame.toItemStack());
        } else {
            ItemsBuilder Flame = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nFeu");
            inv.setItem(13,Flame.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleSpeed",player.getUniqueId())) {
            ItemsBuilder Speed = new ItemsBuilder(Material.FEATHER)
                    .setName("§6§nVitesse");
            inv.setItem(14,Speed.toItemStack());
        } else {
            ItemsBuilder Speed = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nVitesse");
            inv.setItem(14,Speed.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleRain",player.getUniqueId())) {
            ItemsBuilder Rain = new ItemsBuilder(Material.WATER_BUCKET)
                    .setName("§6§nPluie");
            inv.setItem(15,Rain.toItemStack());
        } else {
            ItemsBuilder Rain = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPluie");
            inv.setItem(15,Rain.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleRainLava",player.getUniqueId())) {
            ItemsBuilder RainLava = new ItemsBuilder(Material.LAVA_BUCKET)
                    .setName("§6§nPluie de feu");
            inv.setItem(16,RainLava.toItemStack());
        } else {
            ItemsBuilder RainLava = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nPluie de feu");
            inv.setItem(16,RainLava.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleEnderAura",player.getUniqueId())) {
            ItemsBuilder EnderAura = new ItemsBuilder(Material.ENDER_PEARL)
                    .setName("§6§nAura de l'end");
            inv.setItem(19,EnderAura.toItemStack());
        } else {
            ItemsBuilder EnderAura = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nAura de l'end");
            inv.setItem(19,EnderAura.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleCrit",player.getUniqueId())) {
            ItemsBuilder Crit = new ItemsBuilder(Material.DIAMOND_SWORD)
                    .setName("§6§nCage de critique");
            inv.setItem(20,Crit.toItemStack());
        } else {
            ItemsBuilder Crit = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCage de critique");
            inv.setItem(20,Crit.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleAngelWings",player.getUniqueId())) {
            ItemsBuilder AngelWings = new ItemsBuilder(Material.SUGAR)
                    .setName("§6§nAile d'ange");
            inv.setItem(21,AngelWings.toItemStack());
        } else {
            ItemsBuilder AngelWings = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nAile d'ange");
            inv.setItem(21,AngelWings.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleChristmasHat",player.getUniqueId())) {
            ItemsBuilder ChristmasHat = new ItemsBuilder(Material.SNOW_BALL)
                    .setName("§6§nChapeau de noël");
            inv.setItem(22,ChristmasHat.toItemStack());
        } else {
            ItemsBuilder ChristmasHat = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nChapeau de noël");
            inv.setItem(22,ChristmasHat.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleSuperHero",player.getUniqueId())) {
            ItemsBuilder SuperHero = new ItemsBuilder(Material.DIAMOND_HELMET)
                    .setName("§6§nSuper héro");
            inv.setItem(23,SuperHero.toItemStack());
        } else {
            ItemsBuilder SuperHero = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nSuper héro");
            inv.setItem(23,SuperHero.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleEnchanted",player.getUniqueId())) {
            ItemsBuilder Enchanted = new ItemsBuilder(Material.ENCHANTMENT_TABLE)
                    .setName("§6§nEnchanté");
            inv.setItem(24,Enchanted.toItemStack());
        } else {
            ItemsBuilder Enchanted = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nEnchanté");
            inv.setItem(24,Enchanted.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleBloodHelix",player.getUniqueId())) {
            ItemsBuilder BloodHelix = new ItemsBuilder(Material.REDSTONE)
                    .setName("§6§nHélice de couleur");
            inv.setItem(25,BloodHelix.toItemStack());
        } else {
            ItemsBuilder BloodHelix = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nHélice de couleur");
            inv.setItem(25,BloodHelix.toItemStack());
        }


        if(!main.getCosmeticsManager().hasCosmetic("particleColorCircle",player.getUniqueId())) {
            ItemsBuilder ColorCircle = new ItemsBuilder(Material.BLAZE_ROD)
                    .setName("§6§nCercle de couleur");
            inv.setItem(28,ColorCircle.toItemStack());
        } else {
            ItemsBuilder ColorCircle = new ItemsBuilder(Material.INK_SACK, 1, (byte) 8)
                    .setName("§7§nCercle de couleur");
            inv.setItem(28,ColorCircle.toItemStack());
        }


        ItemsBuilder Retired = new ItemsBuilder(Material.BARRIER)
                .setName("§6§nRetirer votre particule");
        inv.setItem(49,Retired.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        ParticleData particle = new ParticleData(player.getUniqueId());

        switch (current.getType()) {

            case EMERALD:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Emerald emeraldTrail = new Emerald(player);
                emeraldTrail.startEmerald();
                player.closeInventory();
                break;

            case RED_ROSE:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Heart heartTrail = new Heart(player);
                heartTrail.startHeart();
                player.closeInventory();
                break;

            case FIREBALL:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Angry angryTrail = new Angry(player);
                angryTrail.startAngry();
                player.closeInventory();
                break;

            case FLINT_AND_STEEL:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Flame flameTrail = new Flame(player);
                flameTrail.startFlame();
                player.closeInventory();
                break;

            case FEATHER:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Speed speedTrail = new Speed(player);
                speedTrail.startSpeed();
                player.closeInventory();
                break;

            case WATER_BUCKET:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Rain rainTrail = new Rain(player);
                rainTrail.startRain();
                player.closeInventory();
                break;

            case LAVA_BUCKET:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                RainLava lavaTrail = new RainLava(player);
                lavaTrail.startRainLava();
                player.closeInventory();
                break;

            case ENDER_PEARL:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                EnderAura enderAuraTrail = new EnderAura(player);
                enderAuraTrail.startEnderAura();
                player.closeInventory();
                break;

            case DIAMOND_SWORD:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Crit critTrail = new Crit(player);
                critTrail.startCrit();
                player.closeInventory();
                break;

            case SUGAR:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                AngelWings angelWingsTrail = new AngelWings(player);
                angelWingsTrail.startAngelWings();
                player.closeInventory();
                break;

            case ENCHANTMENT_TABLE:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                Enchanted enchantedTrail = new Enchanted(player);
                enchantedTrail.startEnchanted();
                player.closeInventory();
                break;

            case SNOW_BALL:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                ChristmasHat christmasHatTrail = new ChristmasHat(player);
                christmasHatTrail.startChristmasHat();
                player.closeInventory();
                break;

            case DIAMOND_HELMET:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                SuperHero superHeroTrail = new SuperHero(player);
                superHeroTrail.startSuperHero();
                player.closeInventory();
                break;

            case REDSTONE:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                BloodHelix bloodHelixTrail = new BloodHelix(player);
                bloodHelixTrail.startBloodHelix();
                player.closeInventory();
                break;

            case BLAZE_ROD:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                ColorCircle colorCircleTrail = new ColorCircle(player);
                colorCircleTrail.startColorCircle();
                player.closeInventory();
                break;

            case DARK_OAK_DOOR_ITEM:
                Main.getInstance().getGuiManager().open(player, Cosmetics.class);
                break;

            case BARRIER:
                if(particle.hasID()) {
                    particle.endTask();
                    particle.removeID();
                }
                for (PotionEffect effect : player.getActivePotionEffects())
                    player.removePotionEffect(effect.getType());
                player.closeInventory();
                break;

            default: break;
        }
    }
}
