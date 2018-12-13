package pw.kitl.oldboosters;

import pw.kitl.oldboosters.OldBoostersMod;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = OldBoostersMod.MODID)
@Config.LangKey("oldboosters.general")
public class OldBoostersConfig {
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
		}
}
}
