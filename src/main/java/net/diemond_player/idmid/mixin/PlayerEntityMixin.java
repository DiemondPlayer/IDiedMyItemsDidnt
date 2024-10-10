package net.diemond_player.idmid.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.diemond_player.idmid.util.IDMIDAccessor;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;setPickupDelay(I)V"), method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;")
    private void idmid$dropItem(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir, @Local ItemEntity itemEntity) {
        if(((IDMIDAccessor)((Object)stack)).idmid$isDeathDrop()){
            ((IDMIDAccessor)itemEntity).idmid$setItemAge(-32768);
        }
    }
}
