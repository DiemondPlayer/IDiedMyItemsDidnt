package net.diemond_player.idmid.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class IDMIDTags {
    public static class Items {
        public static final TagKey<Item> FORCE_DESPAWN =
                createItemTag("force_despawn");

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier("idmid", name));
        }
    }
}
