package pw.kitl.oldboosters.mixin;

import net.minecraft.client.resources.Locale;
import org.apache.logging.log4j.LogManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Mixin used for debugging lang file issues. Usually disabled.
@Mixin(Locale.class)
public abstract class MixinLocale {
    @Shadow
    public abstract boolean hasKey(String key);

    @Inject(method = "translateKeyPrivate", at = @At("HEAD"))
    private void onTranslateKey(String key, CallbackInfoReturnable<String> ci) {
        if (!hasKey(key)) {
            LogManager.getLogger("lang_info").error("Translation key lookup failed: '{}'", key);
        }
    }
}
