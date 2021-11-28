package nucleus.common.division

import net.minecraft.util.Identifier

/** The root of the registrar categorization hierarchy. Contains an [id] for easy [Identifier] construction. */
abstract class RegistrarRoot<R : RegistrarRoot<R>>(val id: String) {
    /** The instance of this root. Required to allow extension via generics. */
    abstract val instance: R

    /** The dispatcher of this root. Adding more phases should be done by overriding this value. */
    open val dispatcher = RegistrarPhaseDispatcher<R>()

    /** Convert the given [path] to an [Identifier] using [id] as a namespace. */
    open fun identify(path: String) = Identifier(id, path)

    /** Launch all content within this root, using the [dispatcher]. */
    open fun launch() {
        dispatcher.execute(instance)
    }
}