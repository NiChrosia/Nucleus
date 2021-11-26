package nucleus.common.builtin.division.content

import nucleus.common.builtin.division.ModRoot
import nucleus.common.division.RegistrarCategory

open class ContentCategory<R : ModRoot<R>>(root: R) : RegistrarCategory<R>(root) {
    open val block = BlockRegistrar(root).collected()
    open val blockEntity = BlockEntityTypeRegistrar(root).collected()
    open val material = MaterialRegistrar(root).collected()

    open val recipeType = RecipeTypeRegistrar(root).collected()
    open val recipeSerializer = RecipeSerializerRegistrar(root).collected()

    open val item = ItemRegistrar(root).collected()
    open val itemGroup = ItemGroupRegistrar(root).collected()
    open val toolMaterial = ToolMaterialRegistrar(root).collected()

    open val tag = TagRegistrar(root).collected()
    open val statusEffect = StatusEffectRegistrar(root).collected()
    open val sound = SoundRegistrar(root).collected()
    open val screenHandler = ScreenHandlerRegistrar(root).collected()
}