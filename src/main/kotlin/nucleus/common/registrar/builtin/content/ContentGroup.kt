package nucleus.common.registrar.builtin.content

import nucleus.common.registrar.RegistrarGroup
import nucleus.common.registrar.builtin.ModGroup

@Suppress("unused")
open class ContentGroup(open val parent: ModGroup) : RegistrarGroup(parent) {
    open val item = ItemRegistrar(this).collected()
    open val toolMaterial = ToolMaterialRegistrar(this).collected()
    open val itemGroup = ItemGroupRegistrar(this).collected()

    open val block = BlockRegistrar(this).collected()
    open val blockEntity = BlockEntityRegistrar(this).collected()
    open val material = MaterialRegistrar(this).collected()

    open val recipe = RecipeRegistrar(this).collected()
    open val recipeSerializer = RecipeSerializerRegistrar(this).collected()

    open val screen = ScreenTypeRegistrar(this).collected()

    open val statusEffect = StatusEffectRegistrar(this).collected()

    open val sound = SoundRegistrar(this).collected()
}