package net.diemond_player.idmid.mixin;

import net.diemond_player.idmid.util.IDMIDAccessor;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements IDMIDAccessor {
    @Unique
    public boolean isDeathDrop = false;

    @Override
    public boolean idmid$isDeathDrop() {
        return this.isDeathDrop;
    }

    @Override
    public void idmid$setAsDeathDrop(boolean bl) {
        this.isDeathDrop = bl;
    }
}
