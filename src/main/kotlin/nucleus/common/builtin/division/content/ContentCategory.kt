package nucleus.common.builtin.division.content

import nucleus.common.builtin.division.ModRoot
import nucleus.common.division.RegistrarCategory

open class ContentCategory<R : ModRoot<R>>(root: R) : RegistrarCategory<R>(root) {
    open val block = BlockRegistrar(root).collected()
    open val item = ItemRegistrar(root).collected()

    open val tag = TagRegistrar(root).collected()
}