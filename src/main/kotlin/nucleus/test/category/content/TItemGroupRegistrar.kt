package nucleus.test.category.content

import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.registrar.type.content.world.item.ItemGroupRegistrar
import nucleus.test.category.TestCategory

open class TItemGroupRegistrar(namespace: String, pack: RegistrarPack) : ItemGroupRegistrar(namespace, pack) {
    val test by memberOf("test") { groupOf(it, iconProviderOf(TestCategory.content.item::test)) }.apply {
        readableEnglishLang()
    }
}