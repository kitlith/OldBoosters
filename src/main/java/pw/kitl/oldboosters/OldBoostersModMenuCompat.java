package pw.kitl.oldboosters;

import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

import java.util.function.Function;

@SuppressWarnings("unused") // entrypoint
@Environment(EnvType.CLIENT)
public class OldBoostersModMenuCompat implements ModMenuApi {
    @Override
    public String getModId() {
        return "oldboosters";
    }

    @Override
    public Function<Screen, ? extends Screen> getConfigScreenFactory() {
        return screen -> AutoConfig.getConfigScreen(OldBoostersConfig.class, screen).get();
    }
}
