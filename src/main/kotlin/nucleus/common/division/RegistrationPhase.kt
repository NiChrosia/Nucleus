package nucleus.common.division

open class RegistrationPhase<R : RegistrarRoot<R>>(val order: Int) {
    val listeners = mutableListOf<R.() -> Unit>()

    open operator fun invoke(root: R) {
        listeners.forEach {
            it(root)
        }
    }
}