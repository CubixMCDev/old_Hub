package eu.cubix.mc.hub.cosmetics.particles;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.tools.ParticleData;
import eu.cubix.mc.hub.tools.ParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
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

    private final double RADIUS = 1.1;
    private final double ROD_HEIGHT = 1;
    private final int TOTAL_COLUMNS = 8;
    private final double BASE_HEIGHT = 0.4;
    private final double MIN_HEIGHT = 0;
    private final double MAX_HEIGHT = 0.6;
    private final double HEIGHT_STEP = 0.03;
    private final double MAX_HEIGHT_DIFF = 0.5;
    private final double HEIGHT_DIFF_STEP = 0.04;

    private boolean heightDirectionUp;
    private boolean hoveringDirectionUp;
    private double height = 0;
    private double angle = 0;
    private double heightDiffFactor = MAX_HEIGHT_DIFF;

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

    private void drawColumns(Double height, double suppAngle) {
        int cycles = TOTAL_COLUMNS / COLORS.size();
        double workingSpace = 2 * Math.PI / cycles;
        double startAngle = 0;
        Vector v = new Vector(0, 0, 0);
        Location loc;
        ParticleEffect particleEffect = new ParticleEffect(player);

        for (int i = 0; i < cycles; i++) {
            double angleStep = startAngle;
            for (int j = 0; j < COLORS.size(); j++) {
                v.setX(Math.cos(angleStep + suppAngle) * RADIUS);
                v.setZ(Math.sin(angleStep + suppAngle) * RADIUS);
                v.setY(BASE_HEIGHT + Math.sin(angleStep * 3) * heightDiffFactor);
                loc = player.getPlayer().getLocation().add(v);

                particleEffect.drawParticle(EnumParticle.REDSTONE, loc.clone().add(0, ROD_HEIGHT, 0),
                        0.1f, 0.1f, 0.1f, 0.07f, ((int) ROD_HEIGHT) * 5);
                for(Player p : Bukkit.getOnlinePlayers())
                    particleEffect.sendToPlayer(p);

                angleStep += workingSpace / COLORS.size();
                height += (i >= 3 && i <= 5) ? heightDiffFactor : -heightDiffFactor;
            }
            startAngle += workingSpace;
        }
    }
}
