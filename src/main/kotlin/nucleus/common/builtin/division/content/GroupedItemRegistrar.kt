package nucleus.common.builtin.division.content

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.ItemGroup
import nucleus.common.builtin.division.ModRoot

open class GroupedItemRegistrar<R : ModRoot<R>>(root: R, val group: () -> ItemGroup) : ItemRegistrar<R>(root) {
    val groupedSettings: FabricItemSettings
        get() = FabricItemSettings().group(group())
}