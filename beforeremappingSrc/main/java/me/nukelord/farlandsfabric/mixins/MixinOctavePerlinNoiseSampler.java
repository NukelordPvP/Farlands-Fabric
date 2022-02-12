// Decompiled with: CFR 0.152
// Class Version: 16
package me.nukelord.farlandsfabric.mixins;

import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={OctavePerlinNoiseSampler.class})
public abstract class MixinOctavePerlinNoiseSampler {
    @Inject(method={"maintainPrecision"}, at={@At(value="RETURN")}, cancellable=true)
    private static void maintainPrecision(double value, CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue((Object)value);
    }
}
