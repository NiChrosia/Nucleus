package nucleus.test.content

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.BlockItem
import net.minecraft.util.Identifier
import nucleus.common.Nucleus
import nucleus.common.builtin.division.content.ItemRegistrar

open class TItemRegistrar(root: Nucleus) : ItemRegistrar<Nucleus>(root) {
    val test by memberOf(root.identify("test")) { BlockItem(root.content.block.test, FabricItemSettings()) }.apply {
        lang(::readableEnglish)
        model { blockModel(root.content.block.test) }
        loot { blockLoot(root.content.block.test) }

        old(Identifier("grass_block"), Identifier("dirt"), Identifier("bedrock"))
    }
}