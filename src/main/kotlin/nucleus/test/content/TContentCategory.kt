package nucleus.test.content

import nucleus.common.Nucleus
import nucleus.common.builtin.division.content.ContentCategory

open class TContentCategory(root: Nucleus) : ContentCategory<Nucleus>(root) {
    override val block = TBlockRegistrar(root).collected()
    override val item = TItemRegistrar(root).collected()

    override val tag = TTagRegistrar(root).collected()
}