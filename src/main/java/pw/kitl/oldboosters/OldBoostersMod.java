package pw.kitl.oldboosters;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.launch.MixinBootstrap;

@Mod(modid = OldBoostersMod.MODID, name = OldBoostersMod.NAME, version = OldBoostersMod.VERSION, acceptableRemoteVersions = "*")
public class OldBoostersMod {
    public static final String MODID = "oldboosters";
    public static final String NAME = "Old Boosters Mod";
    public static final String VERSION = "1.0";
}
