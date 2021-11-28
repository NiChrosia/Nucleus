package nucleus.test.content

import net.minecraft.item.BlockItem
import nucleus.common.Nucleus
import nucleus.common.builtin.division.content.GroupedItemRegistrar

open class TItemRegistrar(root: Nucleus) : GroupedItemRegistrar<Nucleus>(root, { root.content.itemGroup.nucleus }) {
    val test by memberOf(root.identify("test")) { BlockItem(root.content.block.test, groupedSettings) }.apply {
        lang(::readableEnglish)
        model { blockModel(root.content.block.test) }
        loot { blockLoot(root.content.block.test) }
    }
}