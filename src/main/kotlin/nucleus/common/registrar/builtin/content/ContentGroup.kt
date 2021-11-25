package nucleus.common.registrar.builtin.content

import nucleus.common.registrar.RegistrarGroup
import nucleus.common.registrar.builtin.ModGroup

open class ContentGroup(open val parent: ModGroup) : RegistrarGroup(parent) {
    open val item = ItemRegistrar(this).collected()
    open val block = BlockRegistrar(this).collected()
}