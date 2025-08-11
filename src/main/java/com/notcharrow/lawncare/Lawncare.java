package com.notcharrow.lawncare;

import com.notcharrow.lawncare.config.ConfigManager;
import net.fabricmc.api.ModInitializer;

public class Lawncare implements ModInitializer {

	@Override
	public void onInitialize() {
		ConfigManager.loadConfig();
	}
}
