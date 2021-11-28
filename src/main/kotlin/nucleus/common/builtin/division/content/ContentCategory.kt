package nucleus.common.builtin.division.content

import nucleus.common.builtin.division.ModRoot
import nucleus.common.division.RegistrarCategory

open class ContentCategory<R : ModRoot<R>>(root: R) : RegistrarCategory<R>(root) {
    open val block = BlockRegistrar(root)
    open val blockEntity = BlockEntityTypeRegistrar(root)
    open val material = MaterialRegistrar(root)

    open val recipeType = RecipeTypeRegistrar(root)
    open val recipeSerializer = RecipeSerializerRegistrar(root)

    open val item = ItemRegistrar(root)
    open val itemGroup = ItemGroupRegistrar(root)
    open val toolMaterial = ToolMaterialRegistrar(root)

    open val tag = TagRegistrar(root)
    open val statusEffect = StatusEffectRegistrar(root)
    open val sound = SoundRegistrar(root)
    open val screenHandler = ScreenHandlerRegistrar(root)
}