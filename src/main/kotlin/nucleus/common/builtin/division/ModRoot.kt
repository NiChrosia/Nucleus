package nucleus.common.builtin.division

import nucleus.common.builtin.division.content.ContentCategory
import nucleus.common.division.RegistrarRoot
import nucleus.common.division.RegistrationPhase

abstract class ModRoot<R : ModRoot<R>>(id: String) : RegistrarRoot<R>(id) {
    open val packAddition = RegistrationPhase<R>(400).also(phases::add)

    open val pack by lazy { RegistrarPack(instance) }

    open val content by lazy { ContentCategory(instance).collected() }
}