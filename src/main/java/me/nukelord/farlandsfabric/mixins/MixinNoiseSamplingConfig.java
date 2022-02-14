package me.nukelord.farlandsfabric.mixins;

import com.mojang.serialization.Codec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.world.gen.chunk.NoiseSamplingConfig;

@Mixin(NoiseSamplingConfig.class)
public class MixinNoiseSamplingConfig {
	@Redirect(method = "<clinit>", at = @At(target = "Lcom/mojang/serialization/Codec;doubleRange(DD)Lcom/mojang/serialization/Codec;", value = "INVOKE"))
	private static Codec<Double> fixRange(double min, double max) {
		max = Double.MAX_VALUE;
		return Codec.doubleRange(min, max);

		// changes datapack xzScale range and other ranges
		// to be 0.001 to max a double can handle instead of 1 thousand
		// so you can move farlands within 125 of spawn and EVEN generate the 64bit farlands.
	}
}