package eu.cubix.mc.hub.tools;

import eu.cubix.mc.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.Random;

public class MathUtil {

    static public final float nanoToSec = 1 / 1000000000f;

    static public final float FLOAT_ROUNDING_ERROR = 0.000001f; // 32 bits

    static public final float PI = 3.141592653589793238462643383279f;

    static public final float PI2 = PI * 2;

    static public final float SQRT_3 = 1.73205080757f;

    static public final float E = 2.7182818284590452354f;

    static private final int SIN_BITS = 14; // 16KB. Adjust for accuracy.

    static private final int SIN_MASK = ~(-1 << SIN_BITS);

    static private final int SIN_COUNT = SIN_MASK + 1;

    static private final float radFull = PI * 2;

    static private final float degFull = 360;

    static private final float radToIndex = SIN_COUNT / radFull;

    static private final float degToIndex = SIN_COUNT / degFull;

    /**
     * multiply by this to convert from radians to degrees
     */
    static public final float radiansToDegrees = 180f / PI;

    static public final float radDeg = radiansToDegrees;
    /**
     * multiply by this to convert from degrees to radians
     */
    static public final float degreesToRadians = PI / 180;

    static public final float degRad = degreesToRadians;

    /**
     * Returns a random integer between the value min and the value max.
     *
     * @param min the minimum integer value.
     * @param max the maximum integer value.
     * @return a random integer between two values.
     */
    public static int randomRangeInt(int min, int max) {
        return (int) (java.lang.Math.random() < 0.5 ? ((1 - java.lang.Math.random()) * (max - min) + min) : (java.lang.Math.random() * (max - min) + min));
    }

    public static void applyVelocity(final Entity ent, Vector v) {
        ent.setVelocity(v);
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), () -> FallDamageManager.addNoFall(ent), 5);
    }

    public static void applyVelocity(final Entity ent, Vector v, boolean ignoreGadgetsEnabled) {
        ent.setVelocity(v);
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), () -> FallDamageManager.addNoFall(ent), 4);
    }

    public static final Vector rotateAroundAxisZ(Vector v, double angle) {
        double x, y, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos - v.getY() * sin;
        y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }

    public static double randomDouble(double min, double max) {
        return Math.random() < 0.5 ? ((1 - Math.random()) * (max - min) + min) : (Math.random() * (max - min) + min);
    }

    static public Random random = new Random();

    /**
     * Returns a random number between 0 (inclusive) and the specified value (inclusive).
     */
    static public final int random(int range) {
        return random.nextInt(range + 1);
    }

    /**
     * Returns a random number between start (inclusive) and end (inclusive).
     */
    static public final int random(int start, int end) {
        return start + random.nextInt(end - start + 1);
    }

    /**
     * Returns a random boolean value.
     */
    static public final boolean randomBoolean() {
        return random.nextBoolean();
    }

    /**
     * Returns true if a random value between 0 and 1 is less than the specified value.
     */
    static public final boolean randomBoolean(float chance) {
        return MathUtil.random() < chance;
    }

    /**
     * Returns random number between 0.0 (inclusive) and 1.0 (exclusive).
     */
    static public final float random() {
        return random.nextFloat();
    }

    /**
     * Returns a random number between 0 (inclusive) and the specified value (exclusive).
     */
    static public final float random(float range) {
        return random.nextFloat() * range;
    }

    /**
     * Returns a random number between start (inclusive) and end (exclusive).
     */
    static public final float random(float start, float end) {
        return start + random.nextFloat() * (end - start);
    }

}
