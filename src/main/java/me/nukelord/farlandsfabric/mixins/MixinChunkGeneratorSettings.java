// Decompiled with: CFR 0.152
// Class Version: 16
package me.nukelord.farlandsfabric.mixins;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Optional;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseSamplingConfig;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.chunk.SlideConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.chunk.StructureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ChunkGeneratorSettings.class})
public class MixinChunkGeneratorSettings {
    @Inject(method={"createSurfaceSettings"}, at={@At(value="RETURN")}, cancellable=true)
    private static void createSurfaceSettings(StructuresConfig structuresConfig, boolean amplified, CallbackInfoReturnable<ChunkGeneratorSettings> cir) {
        cir.setReturnValue((Object)new ChunkGeneratorSettings(structuresConfig, GenerationShapeConfig.create(0, 256, new NoiseSamplingConfig(251016.0, 0.9999999814507745, 80.0, 160.0), new SlideConfig(-10, 3, 0), new SlideConfig(15, 3, 0), 1, 2, 1.0, -0.46875, true, true, false, amplified), Blocks.	STONE.getDefaultState(), Blocks.WATER.getDefaultState(), Integer.MIN_VALUE, 0, 63, 0, false, false, false, false, false, false));
    }

    @Inject(method={"createUndergroundSettings"}, at={@At(value="RETURN")}, cancellable=true)
    private static void createUndergroundSettings(StructuresConfig structuresConfig, BlockState defaultBlock, BlockState defaultFluid, CallbackInfoReturnable<ChunkGeneratorSettings> cir) {
        HashMap<StructureFeature, StructureConfig> map = Maps.newHashMap(StructuresConfig.DEFAULT_STRUCTURES);
        map.put(StructureFeature.RUINED_PORTAL, new StructureConfig(25, 10, 34222645));
        cir.setReturnValue((Object)new ChunkGeneratorSettings(new StructuresConfig(Optional.ofNullable(structuresConfig.getStronghold()), map), GenerationShapeConfig.	create(0, 128, new NoiseSamplingConfig(251016.0, 3.0, 80.0, 60.0), new SlideConfig(120, 3, 0), new SlideConfig(320, 4, -1), 1, 2, 0.0, 0.019921875, false, false, false, false), defaultBlock, defaultFluid, 0, 0, 32, 0, false, false, false, false, false, false));
    }

    @Inject(method={"createIslandSettings"}, at={@At(value="RETURN")}, cancellable=true)
    private static void createIslandSettings(StructuresConfig structuresConfig, BlockState defaultBlock, BlockState defaultFluid, boolean bl, boolean bl2, CallbackInfoReturnable<ChunkGeneratorSettings> cir) {
        cir.setReturnValue((Object)new ChunkGeneratorSettings(structuresConfig, GenerationShapeConfig.create(0, 128, new NoiseSamplingConfig(6275400.0, 1.0, 80.0, 160.0), new SlideConfig(-3000, 64, -46), new SlideConfig(-30, 7, 1), 2, 1, 0.0, 0.0, true, false, bl2, false), defaultBlock, defaultFluid, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 0, bl, false, false, false, false, false));
    }
}