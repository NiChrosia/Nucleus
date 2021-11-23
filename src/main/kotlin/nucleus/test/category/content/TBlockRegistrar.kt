package nucleus.test.category.content

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import nucleus.common.registrar.type.content.world.block.BlockRegistrar

open class TBlockRegistrar(namespace: String) : BlockRegistrar(namespace) {
    val test by memberOf("test") { Block(FabricBlockSettings.of(Material.STONE)) }
}