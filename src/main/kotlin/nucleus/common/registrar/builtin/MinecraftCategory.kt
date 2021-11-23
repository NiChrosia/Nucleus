package nucleus.common.registrar.builtin

import nucleus.common.registrar.builtin.content.ContentCategory
import nucleus.common.registrar.category.RegistrarCategory

/** The root category for builtin minecraft registrars. */
object MinecraftCategory : RegistrarCategory("minecraft") {
    val content by subcategory(::ContentCategory)
}