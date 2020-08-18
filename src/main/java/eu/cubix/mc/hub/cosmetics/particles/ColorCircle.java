package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorCircle {

    private final Main main;
    private int taskID;
    private final Player player;
    private static final List<Color> COLORS = new ArrayList<>();

    static {
        COLORS.add(Color.GREEN);
        COLORS.add(new Color(0, 128, 0));
        COLORS.add(new Color(0, 74, 0));
        COLORS.add(new Color(0, 36, 0));
    }

    private final double RADIUS = 1.1; // radius between player and rods
    private final double ROD_HEIGHT = 1; // Height of each height
    private final int TOTAL_COLUMNS = 8; // Amount of rods (columns)
    private final double BASE_HEIGHT = 0.4; // Added to avoid rods in the floor.
    private final double MIN_HEIGHT = 0; // Min height...
    private final double MAX_HEIGHT = 0.6; // Max height...
    private final double HEIGHT_STEP = 0.03; // Height step...
    private final double MAX_HEIGHT_DIFF = 0.5; // Max height diff between columns
    private final double HEIGHT_DIFF_STEP = 0.04; // Height diff step...

    private boolean heightDirectionUp; // Indicates whether the "overall" height is going up or down
    private boolean hoveringDirectionUp; // Indicates whether the height diff between columns is going up or down (gives dynamism)
    private double height = 0; // Current height
    private double angle = 0; // Current angle
    private double heightDiffFactor = MAX_HEIGHT_DIFF; // Height diff between columns. Variates over time with hoveringDirectionUp.

    public ColorCircle(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void startColorCircle() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            final ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                if (heightDirectionUp) {
                    if (height < MAX_HEIGHT) height += HEIGHT_STEP;
                    else heightDirectionUp = false;
                } else {
                    if (height > MIN_HEIGHT) height -= HEIGHT_STEP;
                    else heightDirectionUp = true;
                }
                if (hoveringDirectionUp) {
                    if (heightDiffFactor < MAX_HEIGHT_DIFF) heightDiffFactor += HEIGHT_DIFF_STEP;
                    else hoveringDirectionUp = false;
                } else {
                    if (heightDiffFactor > -MAX_HEIGHT_DIFF) heightDiffFactor -= HEIGHT_DIFF_STEP;
                    else hoveringDirectionUp = true;
                }

                drawColumns(height, angle);

                angle += Math.toRadians(1);
            }
        }, 0, 3);
    }

    /**
     * Draws the rods around the player.
     *
     * @param height    The current height to work with.
     * @param suppAngle Angle rotation step
     */
    private void drawColumns(Double height, double suppAngle) {
        int cycles = TOTAL_COLUMNS / COLORS.size();
        double workingSpace = 2 * Math.PI / cycles; // Each cycle has its angle span.
        double startAngle = 0; // Step angle for each cycle.
        Vector v = new Vector(0, 0, 0);
        Location loc;

        for (int i = 0; i < cycles; i++) {
            double angleStep = startAngle; // Angle for each column.
            for (int j = 0; j < COLORS.size(); j++) {
                v.setX(Math.cos(angleStep + suppAngle) * RADIUS);
                v.setZ(Math.sin(angleStep + suppAngle) * RADIUS);
                v.setY(BASE_HEIGHT + Math.sin(angleStep * 3) * heightDiffFactor); // The height of the columns is a sine wave.
                loc = player.getPlayer().getLocation().add(v);

                /*
                ParticleEffect packet1 = new ParticleEffect(EnumParticle.REDSTONE, loc.clone().add(0, ROD_HEIGHT, 0),
                        0.1f, 0.1f, 0.1f, 0.07f, ((int) ROD_HEIGHT) * 5);
                for(Player p : Bukkit.getOnlinePlayers())
                    packet1.sendToPlayer(p);
                 */

                angleStep += workingSpace / COLORS.size();
                height += (i >= 3 && i <= 5) ? heightDiffFactor : -heightDiffFactor;
            }
            startAngle += workingSpace;
        }
    }
}
