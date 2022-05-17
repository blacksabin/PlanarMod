package com.github.blacksabin.planar.Biomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import static com.github.blacksabin.planar.PlanarInit.MOD_ID;

public final class BiomeManager {

    public static final RegistryKey<Biome> ABERRANT_KEY;

    public static final Biome BIOME_ABERRANT;
    public static void init(){
        Registry.register(BuiltinRegistries.BIOME, ABERRANT_KEY.getValue(), BIOME_ABERRANT);
    }

    static {
        ABERRANT_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "aberrant"));
        BIOME_ABERRANT = new Biome.Builder()
                .category(Biome.Category.NONE)
                .downfall(0.0f)
                .effects(new BiomeEffects.Builder()
                        .fogColor(0x404040)
                        .waterColor(0x101010)
                        .foliageColor(0)
                        .waterFogColor(0)
                        .skyColor(0x404040)
                        .grassColor(0)
                        .build()
                )
                .generationSettings(new GenerationSettings.Builder()
                                .build()
                )
                .precipitation(Biome.Precipitation.NONE)
                .spawnSettings(new SpawnSettings.Builder()
                        .build()
                )
                .temperature(0.5f)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .build();
    }

}
