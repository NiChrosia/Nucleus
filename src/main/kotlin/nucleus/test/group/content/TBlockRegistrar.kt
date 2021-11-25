package nucleus.test.group.content

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import nucleus.common.registrar.builtin.content.BlockRegistrar

open class TBlockRegistrar(group: TContentGroup) : BlockRegistrar(group) {
    val test by member("test") { Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(5f, 100f)) }.apply {
        lang(::readableEnglish)
        blockstate(::staticBlockstate)
        model(::omnidirectionalModel)

        tag { group.parent.tag.block.pickaxeMineable }
        tag { group.parent.tag.block.needsToolLevel4 }
    }
}