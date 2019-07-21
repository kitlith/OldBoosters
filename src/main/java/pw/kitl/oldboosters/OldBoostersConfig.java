package pw.kitl.oldboosters;

import me.sargunvohra.mcmods.autoconfig1.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1.ConfigData;

@Config(name = "oldboosters")
public class OldBoostersConfig implements ConfigData {
    public boolean defaultBoosters = true;
    public boolean defaultInfCap = true;

    @ConfigEntry.Gui.Tooltip
    public double defaultCap = 2.0;
}
