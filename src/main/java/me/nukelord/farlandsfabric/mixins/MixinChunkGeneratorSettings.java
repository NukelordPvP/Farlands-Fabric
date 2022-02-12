package me.nukelord.farlandsfabric.mixins;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.source.util.VanillaTerrainParametersCreator;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ChunkGeneratorSettings.class})
public class MixinChunkGeneratorSettings {
    @Inject(method="createSurfaceSettings", at=@At("RETURN"), cancellable=true)
    private static void createSurfaceSettings(boolean amplified, boolean largeBiomes, CallbackInfoReturnable<ChunkGeneratorSettings> cir) {
        final double scale = 2.0;
        cir.setReturnValue(new ChunkGeneratorSettings(new StructuresConfig(true),
                GenerationShapeConfig.create(-64, 384, new NoiseSamplingConfig(scale, 1.0D, 80.0D, 160.0D),
                new SlideConfig(-0.078125D, 2, amplified ? 0 : 8), new SlideConfig(amplified ? 0.4D : 0.1171875D, 3, 0),
                1, 2, false, amplified, largeBiomes, VanillaTerrainParametersCreator.createSurfaceParameters(amplified)),
                Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), VanillaSurfaceRules.createOverworldSurfaceRule(), 63, false,
                true, true, true, true, false));
    }

    @Inject(method="createCavesSettings", at={@At(value="RETURN")}, cancellable=true)
    private static void createUndergroundSettings(CallbackInfoReturnable<ChunkGeneratorSettings> cir) {
        final double scale = 2.0;
        cir.setReturnValue( new ChunkGeneratorSettings(new StructuresConfig(false),
                GenerationShapeConfig.create(-64, 192, new NoiseSamplingConfig(scale, 3.0D, 80.0D, 60.0D),
                new SlideConfig(0.9375D, 3, 0), new SlideConfig(2.5D, 4, -1), 1, 2,
                false, false, false, VanillaTerrainParametersCreator.createCavesParameters()),
                Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), VanillaSurfaceRules.createDefaultRule(false, true, true),
                32, false, false, false, false, false, true));
    }

    @Inject(method={"createFloatingIslandsSettings"}, at={@At(value="RETURN")}, cancellable=true)
    private static void createIslandSettings(CallbackInfoReturnable<ChunkGeneratorSettings> cir) {
        final double scale = 2.0;
        cir.setReturnValue(new ChunkGeneratorSettings(new StructuresConfig(true),
                GenerationShapeConfig.create(0, 256, new NoiseSamplingConfig(scale, 1.0D, 80.0D, 160.0D),
                        new SlideConfig(-23.4375D, 64, -46), new SlideConfig(-0.234375D, 7, 1), 2,
                        1, false, false, false, VanillaTerrainParametersCreator.createFloatingIslandsParameters()),
                Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), VanillaSurfaceRules.createDefaultRule(false, false, false),
                -64, false, false, false, false, false, true));
    }
}