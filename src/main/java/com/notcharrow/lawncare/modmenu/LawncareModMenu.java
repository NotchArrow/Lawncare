package com.notcharrow.lawncare.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import com.notcharrow.lawncare.config.ConfigManager;

import java.util.function.Consumer;

public class LawncareModMenu implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return this::createConfigScreen;
	}

	private Screen createConfigScreen(Screen parent) {
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(Text.of("Lawncare Config"))
				.setSavingRunnable(ConfigManager::saveConfig);

		ConfigCategory general = builder.getOrCreateCategory(Text.of("Block Spawn Chances"));
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		addPercentSlider(entryBuilder, general, "Wildflowers", "Chance for wildflowers to generate",
				ConfigManager.config.wildflowers, v -> ConfigManager.config.wildflowers = v);

		addPercentSlider(entryBuilder, general, "Leaf Litter", "Chance for leaf litter to generate",
				ConfigManager.config.leafLitter, v -> ConfigManager.config.leafLitter = v);

		addPercentSlider(entryBuilder, general, "Pink Petals", "Chance for pink petals to generate",
				ConfigManager.config.pinkPetals, v -> ConfigManager.config.pinkPetals = v);


		addPercentSlider(entryBuilder, general, "Short Grass", "Chance for short grass to generate",
				ConfigManager.config.shortGrass, v -> ConfigManager.config.shortGrass = v);

		addPercentSlider(entryBuilder, general, "Tall Grass", "Chance for tall grass to generate",
				ConfigManager.config.tallGrass, v -> ConfigManager.config.tallGrass = v);

		addPercentSlider(entryBuilder, general, "Short Dry Grass", "Chance for short dry grass to generate",
				ConfigManager.config.shortDryGrass, v -> ConfigManager.config.shortDryGrass = v);

		addPercentSlider(entryBuilder, general, "Tall Dry Grass", "Chance for short dry grass to generate",
				ConfigManager.config.tallDryGrass, v -> ConfigManager.config.tallDryGrass = v);

		addPercentSlider(entryBuilder, general, "Short Ferns", "Chance for short ferns to generate",
				ConfigManager.config.shortFerns, v -> ConfigManager.config.shortFerns = v);

		addPercentSlider(entryBuilder, general, "Tall Ferns", "Chance for tall ferns to generate",
				ConfigManager.config.tallFerns, v -> ConfigManager.config.tallFerns = v);

		addPercentSlider(entryBuilder, general, "Short Seagrass", "Chance for short seagrass to generate",
				ConfigManager.config.shortSeagrass, v -> ConfigManager.config.shortSeagrass = v);

		addPercentSlider(entryBuilder, general, "Tall Seagrass", "Chance for tall seagrass to generate",
				ConfigManager.config.tallSeagrass, v -> ConfigManager.config.tallSeagrass = v);


		addPercentSlider(entryBuilder, general, "Bushes", "Chance for bushes to generate",
				ConfigManager.config.bushes, v -> ConfigManager.config.bushes = v);

		addPercentSlider(entryBuilder, general, "Firefly Bushes", "Chance for firefly bushes to generate",
				ConfigManager.config.fireflyBushes, v -> ConfigManager.config.fireflyBushes = v);

		addPercentSlider(entryBuilder, general, "Dead Bushes", "Chance for dead bushes to generate",
				ConfigManager.config.deadBushes, v -> ConfigManager.config.deadBushes = v);

		addPercentSlider(entryBuilder, general, "Flowers", "Chance for flowers to generate",
				ConfigManager.config.flowers, v -> ConfigManager.config.flowers = v);


		addPercentSlider(entryBuilder, general, "Moss Carpet", "Chance for moss carpet to generate",
				ConfigManager.config.mossCarpet, v -> ConfigManager.config.mossCarpet = v);

		addPercentSlider(entryBuilder, general, "Vines", "Chance for vines to generate",
				ConfigManager.config.vines, v -> ConfigManager.config.vines = v);

		addPercentSlider(entryBuilder, general, "Sweet Berries", "Chance for sweet berries to generate",
				ConfigManager.config.sweetBerries, v -> ConfigManager.config.sweetBerries = v);

		addPercentSlider(entryBuilder, general, "Cactus", "Chance for cactus to generate",
				ConfigManager.config.cactus, v -> ConfigManager.config.cactus = v);

		return builder.build();
	}

	private void addPercentSlider(ConfigEntryBuilder entryBuilder, ConfigCategory category,
								  String label, String tooltip, int currentValue, Consumer<Integer> onSave) {
		category.addEntry(entryBuilder.startIntSlider(Text.of(label), currentValue, 0, 100)
				.setTooltip(Text.of(tooltip))
				.setDefaultValue(100)
				.setSaveConsumer(onSave)
				.build());
	}
}