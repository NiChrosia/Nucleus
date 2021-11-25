package nucleus.common.registrar.builtin

import nucleus.common.registrar.RegistrarGroup
import nucleus.common.registrar.builtin.content.ContentGroup
import nucleus.common.registrar.builtin.tag.TagGroup

open class ModGroup(modId: String) : RegistrarGroup(true, modId) {
    open val content = ContentGroup(this).collected()
    open val tag = TagGroup(this).collected()
}