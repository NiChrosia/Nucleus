package nucleus.client.registrar.builtin

import nucleus.client.registrar.builtin.content.ClientContentCategory
import nucleus.common.registrar.category.RegistrarCategory

/** The root category for all client-only registrars, e.g. screens, block entity renderers, etc. */
object MinecraftClientCategory : RegistrarCategory("minecraft") {
    val content by subcategory(::ClientContentCategory)
}