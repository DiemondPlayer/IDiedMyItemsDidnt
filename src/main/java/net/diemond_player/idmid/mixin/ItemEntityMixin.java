package net.diemond_player.idmid.mixin;

import net.diemond_player.idmid.util.IDMIDAccessor;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin implements IDMIDAccessor {
    @Shadow
    private int itemAge;

    @Override
    public void idmid$setItemAge(int itemAge) {
        this.itemAge = itemAge;
    }
}
