package nucleus.common.registrar.base.datagen

import net.devtech.arrp.json.tags.JTag
import net.minecraft.tag.Tag
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.registrar.base.member.MemberRegistrar

open class TagRegistrar<T>(val vanillaRegistry: Registry<T>, override val pack: RegistrarPack, namespace: String) : MemberRegistrar<Tag<T>>(namespace), PackRegistrar {
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