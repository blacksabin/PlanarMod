package com.github.blacksabin.planar.Dimensions;

import static com.github.blacksabin.planar.PlanarInit.MOD_ID;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public final class DimensionManager {
    // The dimension options refer to the JSON-file in the dimension subfolder of the datapack,
    // which will always share it's ID with the world that is created from it
    private static final RegistryKey<DimensionOptions> DIMENSION_KEY = RegistryKey.of(
            Registry.DIMENSION_KEY,
            new Identifier(MOD_ID, "hidden_path")
    );

    private static RegistryKey<World> HIDDEN_PATH_WORLD_KEY = RegistryKey.of(
            Registry.WORLD_KEY,
            DIMENSION_KEY.getValue()
    );

    private static final RegistryKey<DimensionType> DIMENSION_TYPE_KEY = RegistryKey.of(
            Registry.DIMENSION_TYPE_KEY,
            new Identifier(MOD_ID, "path")
    );

    public static ServerWorld DIMENSION_HIDDEN_PATH;

    public static void init() {

        HIDDEN_PATH_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, new Identifier(MOD_ID, "hidden_path"));

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            DimensionManager.DIMENSION_HIDDEN_PATH = server.getWorld(HIDDEN_PATH_WORLD_KEY);
        });

        Registry.register(Registry.CHUNK_GENERATOR, new Identifier(MOD_ID, "aberrant"), PlanarChunkGenerator.CODEC);

    }

}