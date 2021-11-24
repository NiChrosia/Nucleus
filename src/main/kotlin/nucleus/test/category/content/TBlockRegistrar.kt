package nucleus.test.category.content

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.registrar.type.content.world.block.BlockRegistrar

open class TBlockRegistrar(namespace: String, pack: RegistrarPack) : BlockRegistrar(namespace, pack) {
    val test by memberOf("test") { Block(FabricBlockSettings.of(Material.STONE)) }.apply {
        readableEnglishLang()
    }
}