package nucleus.test.content

import nucleus.common.Nucleus
import nucleus.common.builtin.division.content.ItemGroupRegistrar

open class TItemGroupRegistrar(root: Nucleus) : ItemGroupRegistrar<Nucleus>(root) {
    val nucleus by memberOf(root.identify("nucleus")) { groupOf(it) }.apply {
        lang(::readableEnglish)
    }
}