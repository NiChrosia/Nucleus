package nucleus.test.category.content

import net.minecraft.item.BlockItem
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.registrar.type.content.world.item.GroupedItemRegistrar
import nucleus.test.category.TestCategory

open class TItemRegistrar(namespace: String, pack: RegistrarPack) : GroupedItemRegistrar(namespace, pack, TestCategory.content.itemGroup::test) {
    val test by memberOf("test") { BlockItem(TestCategory.content.block.test, groupedSettings) }.apply {
        readableEnglishLang()
    }
}