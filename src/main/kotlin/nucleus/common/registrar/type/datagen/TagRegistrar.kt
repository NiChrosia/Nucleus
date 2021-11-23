package nucleus.common.registrar.type.datagen

import net.devtech.arrp.api.RuntimeResourcePack
import net.devtech.arrp.json.tags.JTag
import net.minecraft.tag.Tag
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

open class TagRegistrar<T>(val vanillaRegistry: Registry<T>, namespace: String, pack: RuntimeResourcePack) : PackRegistrar<Tag<T>>(pack, namespace) {
    override fun publish(key: Identifier, value: Tag<T>): Tag<T> {
        return super.publish(key, value).also {
            pack.addTag(key, JTag.tag().apply {
                val entries = value.values()
                val ids = entries.map(vanillaRegistry::getId)

                ids.forEach(this::add)
            })
        }
    }
}