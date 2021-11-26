package nucleus.common.extension

import net.minecraft.util.Identifier

fun Identifier.split(separator: String = ":"): String {
    return "$namespace$separator$path"
}

fun Identifier.within(folder: String): Identifier {
    return Identifier(namespace, "$folder/$path")
}