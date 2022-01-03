package nucleus.common.test.content

import nucleus.common.builtin.division.content.ItemGroupRegistrar
import nucleus.common.test.NucleusTest

open class TItemGroupRegistrar(root: NucleusTest) : ItemGroupRegistrar<NucleusTest>(root) {
    val nucleus by memberOf(root.identify("nucleus")) { groupOf(it) }.apply {
        lang(::readableEnglish)
    }
}