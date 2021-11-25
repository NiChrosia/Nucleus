package nucleus.common.extension

import net.minecraft.util.Identifier

fun Identifier.within(folder: String): Identifier {
    return Identifier(namespace, "$folder/$path")
}

fun Identifier.split(separator: String = ":"): String {
    return "$namespace$separator$path"
}

infix fun String.with(path: String): Identifier {
    return Identifier(this, path)
}