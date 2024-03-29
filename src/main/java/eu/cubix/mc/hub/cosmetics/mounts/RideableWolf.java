package eu.cubix.mc.hub.cosmetics.mounts;

import java.lang.reflect.Field;

import eu.cubix.mc.hub.tools.MountManager;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityWolf;
import net.minecraft.server.v1_8_R3.MathHelper;
import net.minecraft.server.v1_8_R3.World;

public class RideableWolf extends EntityWolf {

    protected Field FIELD_JUMP = null;
    private Player rider;

    public RideableWolf(World world) {
        super(world);
    }

    @Override
    public void g(float f, float f1) {

        if (MountManager.shouldDie(this, rider)) return;

        if (this.passenger != null && this.passenger instanceof EntityHuman)  {
            this.lastYaw = this.yaw = this.passenger.yaw;
            this.pitch = this.passenger.pitch * 0.5F;
            this.setYawPitch(this.yaw, this.pitch);
            this.aK = this.aI = this.yaw;
            f = ((EntityLiving)this.passenger).aZ * 0.5F;
            f1 = ((EntityLiving)this.passenger).ba;

            if(f1 <= 0.0F) {
                f1 *= 0.25F;
            }

            Field jump = null;
            try {
                jump = EntityLiving.class.getDeclaredField("aY");
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            } catch (SecurityException e1) {
                e1.printStackTrace();
            }
            jump.setAccessible(true);

            if (jump != null && this.onGround) {
                try {
                    if (jump.getBoolean(this.passenger)) {
                        double jumpHeight = 0.5D;
                        this.motY = jumpHeight;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            this.S = 1.0F; this.aM = this.bI() * 0.1F; if(!this.world.isClientSide)  {
                this.k((float) MountManager.mountSpeed);
                super.g(f, f1);
            }

            this.aA = this.aB; double d0 = this.locX - this.lastX; double d1 = this.locZ - this.lastZ; float f4 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;
            if(f4 > 1.0F)
            {
                f4 = 1.0F;
            }

            this.aB += (f4 - this.aB) * 0.4F; this.aC += this.aB;
        } else {
            this.S = 0.5F; this.aM = 0.02F; super.g(f, f1);
        }
    }
}