package nucleus.common.test.content

import nucleus.common.builtin.division.content.ContentCategory
import nucleus.common.test.NucleusTest

open class TContentCategory(root: NucleusTest) : ContentCategory<NucleusTest>(root) {
    override val block = TBlockRegistrar(root)

    override val item = TItemRegistrar(root)
    override val itemGroup = TItemGroupRegistrar(root)

    override val tag = TTagRegistrar(root)
}