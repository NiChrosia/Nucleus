package nucleus.common.member.base

import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack
import java.util.*

interface LangMember {
    val pack: RegistrarPack
    /** The given lang category, for prepending before namespace and path, e.g. `item.minecraft.stone`. */
    val category: String
    val ID: Identifier

    fun String.capitalize(): String {
        return replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }

    /** Convert the given [Identifier.path] to readable English. */
    fun toReadable(ID: Identifier): String {
        return ID.path.split("_").joinToString(" ") { it.capitalize() }
    }

    /** Adds simple readable English lang, e.g. `item.minecraft.stone` -> `Stone`. */
    fun readableEnglishLang() {
        lang(toReadable(ID))
    }

    /** Add a lang entry of given `name` at `category.namespace.path`. */
    fun lang(name: String) {
        pack.english.entry("$category.${ID.namespace}.${ID.path}", name)
    }
}