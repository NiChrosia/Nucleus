package nucleus.test.group

import nucleus.common.registrar.builtin.ModGroup
import nucleus.test.group.content.TContentGroup
import nucleus.test.group.tag.TTagGroup

object TestGroup : ModGroup("test") {
    override val content = TContentGroup(this).collected()
    override val tag = TTagGroup(this).collected()
}