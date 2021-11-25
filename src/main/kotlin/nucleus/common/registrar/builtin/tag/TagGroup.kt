package nucleus.common.registrar.builtin.tag

import nucleus.common.registrar.RegistrarGroup
import nucleus.common.registrar.builtin.ModGroup

open class TagGroup(open val parent: ModGroup) : RegistrarGroup(parent) {
    open val block = BlockTagRegistrar(this).collected()
}