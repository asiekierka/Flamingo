package com.reddit.user.koppeh.flamingo.mixin;

import org.dimdev.riftloader.listener.InitializationListener;
import org.spongepowered.asm.mixin.Mixins;

public class FlamingoMixins implements InitializationListener {
	@Override
	public void onInitialization() {
		Mixins.addConfiguration("mixins.flamingo.json");
	}
}
