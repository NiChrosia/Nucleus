package nucleus.common.test.content

import net.minecraft.item.BlockItem
import nucleus.common.builtin.division.content.GroupedItemRegistrar
import nucleus.common.test.NucleusTest

open class TItemRegistrar(root: NucleusTest) : GroupedItemRegistrar<NucleusTest>(root, { root.content.itemGroup.nucleus }) {
    val test by memberOf(root.identify("test")) { BlockItem(root.content.block.test, groupedSettings) }.apply {
        lang(::readableEnglish)
        model { blockModel(root.content.block.test) }
        loot { blockLoot(root.content.block.test) }
    }
}