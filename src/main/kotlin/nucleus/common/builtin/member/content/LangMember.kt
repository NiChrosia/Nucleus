package nucleus.common.builtin.member.content

import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.extension.capitalize
import nucleus.common.extension.split

interface LangMember<R : ModRoot<R>> {
    val root: R
    val key: Identifier

    val langCategory: String // 'item' in 'item.minecraft.stone_pickaxe'

    fun readableEnglish(): String {
        return key.path.split("_").joinToString(" ", transform = String::capitalize)
    }

    fun lang(provider: () -> String) {
        root.dispatcher.datagen.listeners.add {
            val key = "$langCategory.${key.split(".")}" // item.minecraft.stone_pickaxe

            it.pack.english.entry(key, provider())
        }
    }
}