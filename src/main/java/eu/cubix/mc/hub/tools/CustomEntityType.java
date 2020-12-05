package eu.cubix.mc.hub.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.cubix.mc.hub.cosmetics.mounts.*;
import net.minecraft.server.v1_8_R3.*;
import net.minecraft.server.v1_8_R3.BiomeBase.BiomeMeta;

public class CustomEntityType {

    private static HashMap<String, Integer> ensI = new HashMap<>();
    private static HashMap<Integer, String> ensN = new HashMap<>();


    public static void registerAllEntities() {
        registerEntity("Ocelot", 98, EntityOcelot.class, RideableOcelot.class);
        registerEntity("Chicken", 93, EntityChicken.class, RideableChicken.class);
        registerEntity("Cow", 92, EntityCow.class, RideableCow.class);
        registerEntity("Creeper", 50, EntityCreeper.class, RideableCreeper.class);
        registerEntity("Horse", 100, EntityHorse.class, RideableHorse.class);
        registerEntity("Pig", 90, EntityPig.class, RideablePig.class);
        registerEntity("Rabbit", 101, EntityRabbit.class, RideableRabbit.class);
        registerEntity("Sheep", 91, EntitySheep.class, RideableSheep.class);
        registerEntity("Spider", 52, EntitySpider.class, RideableSpider.class);
        registerEntity("Villager", 120, EntityVillager.class, RideableVillager.class);
        registerEntity("Zombie", 54, EntityZombie.class, RideableZombie.class);
        registerEntity("Wolf", 95, EntityWolf.class, RideableWolf.class);
        registerEntity("Skeleton", 51, EntitySkeleton.class, RideableSkeleton.class);
        registerEntity("Slime", 55, EntitySlime.class, RideableSlime.class);
        registerEntity("MagmaCube", 62, EntityMagmaCube.class, RideableMagmaCube.class);
        registerEntity("PigZombie", 57, EntityPigZombie.class, RideablePigZombie.class);
        registerEntity("Enderman", 58, EntityEnderman.class, RideableEnderman.class);
        registerEntity("Endermite", 67, EntityEndermite.class, RideableEndermite.class);
        registerEntity("Silverfish", 60, EntitySilverfish.class, RideableSilverfish.class);
        registerEntity("Blaze", 61, EntityBlaze.class, RideableBlaze.class);
        registerEntity("Guardian", 68, EntityGuardian.class, RideableGuardian.class);
        registerEntity("Squid", 94, EntitySquid.class, RideableSquid.class);
        registerEntity("Witch", 66, EntityWitch.class, RideableWitch.class);
        registerEntity("CaveSpider", 59, EntityCaveSpider.class, RideableCaveSpider.class);
        registerEntity("MushroomCow", 96, EntityMushroomCow.class, RideableMushroomCow.class);
    }

    public static void registerEntity(String name, int id, Class<? extends EntityInsentient> nmsClass,
                                      Class<? extends EntityInsentient> customClass) {
        try {

            List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
            for (Field f : EntityTypes.class.getDeclaredFields()) {
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
                    f.setAccessible(true);
                    dataMaps.add((Map<?, ?>) f.get(null));
                }
            }

            if (dataMaps.get(2).containsKey(id)) {
                dataMaps.get(0).remove(name);
                dataMaps.get(2).remove(id);
            }

            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);

            for (Field f : BiomeBase.class.getDeclaredFields()) {
                if (f.getType().getSimpleName().equals(BiomeBase.class.getSimpleName())) {
                    if (f.get(null) != null) {

                        for (Field list : BiomeBase.class.getDeclaredFields()) {
                            if (list.getType().getSimpleName().equals(List.class.getSimpleName())) {
                                list.setAccessible(true);
                                @SuppressWarnings("unchecked")
                                List<BiomeMeta> metaList = (List<BiomeMeta>) list.get(f.get(null));

                                for (BiomeMeta meta : metaList) {
                                    Field clazz = BiomeMeta.class.getDeclaredFields()[0];
                                    if (clazz.get(meta).equals(nmsClass)) {
                                        clazz.set(meta, customClass);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ensI.put(name, id);
            ensN.put(id, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getID(String name) {
        return ensI.get(name);
    }

    public static String getName(int id) {
        return ensN.get(id);
    }
}