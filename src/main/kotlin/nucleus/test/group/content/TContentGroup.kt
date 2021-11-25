package nucleus.test.group.content

import nucleus.common.registrar.builtin.content.ContentGroup
import nucleus.test.group.TestGroup

open class TContentGroup(override val parent: TestGroup) : ContentGroup(parent) {
    override val item = TItemRegistrar(this).collected()
    override val block = TBlockRegistrar(this).collected()
}