package nucleus.common.division

import net.minecraft.util.Identifier

abstract class RegistrarRoot<R : RegistrarRoot<R>>(val id: String) {
    abstract val instance: R

    val register = RegistrationPhase<R>(100)
    val publish = RegistrationPhase<R>(200)
    val datagen = RegistrationPhase<R>(300)

    val phases = mutableListOf(register, publish, datagen)

    val categories = mutableListOf<RegistrarCategory<R>>()

    open fun <T : RegistrarCategory<R>> T.collected(): T {
        return also(this@RegistrarRoot.categories::add)
    }

    open fun identify(path: String) = Identifier(id, path)

    open fun launch() {
        phases.sortedBy(RegistrationPhase<R>::order).forEach {
            it(instance)
        }
    }
}