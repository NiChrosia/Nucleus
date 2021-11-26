package nucleus.test.content

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.util.Identifier
import nucleus.common.Nucleus
import nucleus.common.builtin.division.content.BlockRegistrar

open class TBlockRegistrar(root: Nucleus) : BlockRegistrar<Nucleus>(root) {
    val test by memberOf(root.identify("test")) { Block(FabricBlockSettings.of(Material.STONE)) }.apply {
        lang(::readableEnglish)
        model(::omnidirectionalModel)
        blockstate(::staticBlockstate)

        tag { root.content.tag.pickaxeMineable }
        tag { root.content.tag.requiresMiningLevel4 }

        old(Identifier("grass_block"), Identifier("dirt"), Identifier("bedrock"))
    }
}