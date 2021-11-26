package nucleus.test.content

import nucleus.common.builtin.division.content.ContentCategory
import nucleus.test.NucleusTest

open class TContentCategory(root: NucleusTest) : ContentCategory<NucleusTest>(root) {
    override val block = TBlockRegistrar(root).collected()
    override val item = TItemRegistrar(root).collected()

    override val tag = TTagRegistrar(root).collected()
}