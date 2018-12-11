package pw.kitl.oldboosters.mixin;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import pw.kitl.oldboosters.OldBoostersMod;
import pw.kitl.oldboosters.OldBoostersConfig;

@Mixin(EntityMinecart.class)
public abstract class MixinEntityMinecart extends Entity {
    MixinEntityMinecart(World worldIn) {
        super(worldIn);
    }

    private boolean boosterEnabled = OldBoostersConfig.defaultBoosters;

    @Inject(method = "readEntityFromNBT", at = @At("HEAD"))
    protected void readEntityFromNBT(NBTTagCompound compound, CallbackInfo ci) {
        boosterEnabled = compound.getBoolean("EnableBoosters");
    }

    @Inject(method = "writeEntityToNBT", at = @At("HEAD"))
    protected void writeEntityToNBT(NBTTagCompound compound, CallbackInfo ci) {
        if (boosterEnabled) {
            compound.setBoolean("EnableBoosters", true);
        }
    }

    @ModifyConstant(method = "applyEntityCollision", constant = @Constant(doubleValue = 0.800000011920929D))
    private double enableBoosters(double origConst) {
        if (boosterEnabled) {
            return -1;
        } else {
            return origConst;
        }
    }

    // @ModifyConstant(method = "moveAlongTrack", constant = @Constant(doubleValue = 0.06D))
    // private double motionMultiplicand(double origConst) {
    //     if (boosterEnabled) {
    //         return 0.04D;
    //     } else {
    //         return origConst;
    //     }
    // }
    //
    // @ModifyConstant(method = "moveAlongTrack", constant = @Constant(doubleValue = 2.0D, ordinal = 0))
    // private double removeCap(double origConst) {
    //     if (boosterEnabled) {
    //         return Double.POSITIVE_INFINITY;
    //     } else {
    //         return origConst;
    //     }
    // }
}
