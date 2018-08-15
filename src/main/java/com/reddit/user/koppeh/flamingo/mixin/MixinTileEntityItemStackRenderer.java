package com.reddit.user.koppeh.flamingo.mixin;

import com.reddit.user.koppeh.flamingo.ItemBlockFlamingo;
import com.reddit.user.koppeh.flamingo.TileEntityFlamingo;
import com.reddit.user.koppeh.flamingo.TileEntityFlamingoRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntityItemStackRenderer.class)
public class MixinTileEntityItemStackRenderer {
	@Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
	public void renderByItem(ItemStack stack, CallbackInfo callback) {
		if (stack.getItem() instanceof ItemBlockFlamingo) {
			TileEntityFlamingoRenderer.INSTANCE.func_199341_a(null, 0.0D, 0.0D, 0.0D, 0.0F, -1);
			callback.cancel();
		}
	}
}
