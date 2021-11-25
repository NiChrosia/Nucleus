package nucleus.common.registrar.builtin.content

import net.minecraft.recipe.RecipeType
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.VanillaRegistrar

open class RecipeRegistrar(override val group: ContentGroup) : VanillaRegistrar<RecipeType<*>>(group, Registry.RECIPE_TYPE)