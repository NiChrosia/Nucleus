package nucleus.test.group.content

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.BlockItem
import nucleus.common.registrar.builtin.content.ItemRegistrar

open class TItemRegistrar(group: TContentGroup) : ItemRegistrar(group) {
    val test by member("test") { BlockItem(group.block.test, FabricItemSettings()) }.apply {
        lang(::readableEnglish)
        model { blockModel(group.block.test) }
        loot { itemLoot(group.block.test) }
    }
}