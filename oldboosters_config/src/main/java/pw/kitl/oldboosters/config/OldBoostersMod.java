package pw.kitl.oldboosters.config;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import org.apache.logging.log4j.Logger;

import java.lang.NoClassDefFoundError;

import pw.kitl.oldboosters.OldBoostersConfig;

@Mod(modid = OldBoostersMod.MODID, name = OldBoostersMod.NAME, version = OldBoostersMod.VERSION, acceptableRemoteVersions = "*")
public class OldBoostersMod {
    public static final String MODID = "oldboosters";
    public static final String NAME = "Old Boosters Mod";
    public static final String VERSION = "1.1";

    public static Logger logger;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        logger = event.getModLog();
        OldBoostersForgeConfig.syncConfig();
    }
}

@Config(modid = OldBoostersMod.MODID)
@Config.LangKey("oldboosters.general")
class OldBoostersForgeConfig {
    public static boolean defaultBoosters = true;
    public static boolean defaultRemoveCap = true;

    @Mod.EventBusSubscriber
    private static class EventHandler {
        /**
         * Inject the new values and save to the config file when the config has been changed from the GUI.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(OldBoostersMod.MODID)) {
                ConfigManager.sync(OldBoostersMod.MODID, Config.Type.INSTANCE);
            }
            syncConfig();
        }
    }

    public static void syncConfig() {
        // try {
            OldBoostersConfig.defaultBoosters = defaultBoosters;
            OldBoostersConfig.defaultRemoveCap = defaultRemoveCap;
        // } catch (NoClassDefFoundError blah) {
        //     OldBoostersMod.logger.error("Coremod not found!");
        // }
    }
}
