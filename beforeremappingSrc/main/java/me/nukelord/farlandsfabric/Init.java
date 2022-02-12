// Decompiled with: CFR 0.152
// Class Version: 16
package me.nukelord.farlandsfabric;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.CommandManager.RegistrationEnvironment;
import net.minecraft.server.network.ServerPlayerEntity;

public class Init
        implements ModInitializer {
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register((LiteralArgumentBuilder)((Object)((LiteralArgumentBuilder)((Object)RegistrationEnvironment.literal("flyspeed").requires(p_198496_0_ -> p_198496_0_.hasPermissionLevel(2)))).then(RegistrationEnvironment.argument("level", FloatArgumentType.floatArg()).executes(commandContext -> {
            ServerPlayerEntity player = ((ServerCommandSource)commandContext.getSource()).getPlayer();
            player.getAbilities().setFlySpeed(FloatArgumentType.getFloat(commandContext, "level") * 0.05f);
            player.	sendAbilitiesUpdate();
            return 1;
        })))));
    }
}
