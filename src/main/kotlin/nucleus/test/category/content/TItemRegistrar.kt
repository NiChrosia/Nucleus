package nucleus.test.category.content

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.BlockItem
import nucleus.common.registrar.type.content.world.item.ItemRegistrar
import nucleus.test.category.TestCategory

open class TItemRegistrar(namespace: String) : ItemRegistrar(namespace) {
    val test by memberOf("test") { BlockItem(TestCategory.content.block.test, FabricItemSettings()) }
}