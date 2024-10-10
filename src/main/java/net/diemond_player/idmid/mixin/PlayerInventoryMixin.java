package net.diemond_player.idmid.mixin;

import net.diemond_player.idmid.util.IDMIDAccessor;
import net.diemond_player.idmid.util.IDMIDTags;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {
	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;"), method = "dropAll")
	private ItemStack idmid$dropAll(ItemStack stack) {
		if(!(stack.isIn(IDMIDTags.Items.FORCE_DESPAWN))){
			((IDMIDAccessor)((Object)stack)).idmid$setAsDeathDrop(true);
		}
		return stack;
	}
}