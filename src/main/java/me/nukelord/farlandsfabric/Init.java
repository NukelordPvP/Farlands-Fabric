package me.nukelord.farlandsfabric;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public class Init implements ModInitializer {
    public void onInitialize() {
        LogManager.getLogger().info("Initializing FarLands mod...");
    }
}
