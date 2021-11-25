package nucleus.common.extension

fun throwMissingEntryException(): Nothing {
    throw IllegalStateException("ID of registered content entry is not present, something is terribly wrong.")
}