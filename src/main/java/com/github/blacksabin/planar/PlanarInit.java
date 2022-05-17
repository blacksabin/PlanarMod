package com.github.blacksabin.planar;

import com.github.blacksabin.planar.Biomes.BiomeManager;
import com.github.blacksabin.planar.Blocks.BlockPlanarScaffold;
import com.github.blacksabin.planar.Blocks.BlockPortstone;
import com.github.blacksabin.planar.Dimensions.DimensionManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanarInit implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "planar";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Block BLOCK_ABSTRACT_STONE = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static final BlockPlanarScaffold BLOCK_PLANAR_SCAFFOLD = new BlockPlanarScaffold(FabricBlockSettings.of(Material.STONE).hardness(4.0f));
	public static final BlockPortstone BLOCK_PORTSTONE = new BlockPortstone(FabricBlockSettings.of(Material.STONE).hardness(4.0f));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		// BLOCKS - SIMPLE
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "abstract_stone"), BLOCK_ABSTRACT_STONE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "abstract_stone"), new BlockItem(BLOCK_ABSTRACT_STONE, new FabricItemSettings().group(ItemGroup.MISC)));

		// BLOCKS - COMPLEX
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "planar_scaffold"), BLOCK_PLANAR_SCAFFOLD);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "planar_scaffold"), new BlockItem(BLOCK_PLANAR_SCAFFOLD, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "portstone"), BLOCK_PORTSTONE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "portstone"), new BlockItem(BLOCK_PORTSTONE, new FabricItemSettings().group(ItemGroup.MISC)));

		// DIMENSIONS

		BiomeManager.init();
		DimensionManager.init();


	}
}
