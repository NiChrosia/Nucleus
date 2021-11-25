package nucleus.test.group.tag

import nucleus.common.registrar.builtin.tag.TagGroup
import nucleus.test.group.TestGroup

open class TTagGroup(parent: TestGroup) : TagGroup(parent) {
    override val block = TBlockTagRegistrar(this).collected()
}