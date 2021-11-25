package nucleus.common.registrar

import nucleus.common.Nucleus

/** An enum containing all registration stages, as well as descriptions of each. */
enum class RegistrarStage {
    /** Initialization of all registrar/group classes. */
    Init,
    /** Registration of content from members into registries. */
    Register,
    /** Publishing of registry content to external destinations, e.g. Minecraft's various registries. */
    Publish,
    /** Generate data using ARRP, e.g. lang, models, blockstates, etc. */
    Datagen;

    open class User(val incorrectStageFatal: Boolean = true) {
        protected var stage = Init

        /** Check whether the current stage is correct, and if not, throw an error/log a warning. */
        protected open fun checkForIncorrectStage(function: String, correct: RegistrarStage) {
            if (stage != correct) {
                if (incorrectStageFatal) {
                    throw IllegalStateException("Attempted to call $function in incorrect stage '$stage'.")
                } else {
                    Nucleus.log.warn("$function called in incorrect stage '$stage'.")
                }
            }
        }

        open fun register() {
            checkForIncorrectStage("register", Init)

            stage = Register
        }

        open fun publish() {
            checkForIncorrectStage("publish", Register)

            stage = Publish
        }

        open fun datagen() {
            checkForIncorrectStage("datagen", Publish)

            stage = Datagen
        }
    }
}