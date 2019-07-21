package pw.kitl.oldboosters;

import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1.ConfigHolder;
import me.sargunvohra.mcmods.autoconfig1.serializer.JanksonConfigSerializer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

@SuppressWarnings("unused") // entrypoint
public class OldBoostersInit implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(
            OldBoostersConfig.class,
            JanksonConfigSerializer::new
        );
    }
}
