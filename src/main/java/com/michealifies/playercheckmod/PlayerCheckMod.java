package com.michealifies.playercheckmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerCheckMod implements ModInitializer {
    public static final String MOD_ID = "playercheckmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing PlayerCheckMod");
        registerCommands();
    }

    private void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("check")
                .then(CommandManager.argument("target", EntityArgumentType.player())
                    .executes(context -> {
                        ServerPlayerEntity target = EntityArgumentType.getPlayer(context, "target");
                        ServerPlayerEntity checker = context.getSource().getPlayer();
                        // Implement check logic here
                        return 1;
                    })));

            dispatcher.register(CommandManager.literal("uncheck")
                .executes(context -> {
                    ServerPlayerEntity checker = context.getSource().getPlayer();
                    // Implement uncheck logic here
                    return 1;
                }));
        });
    }
}