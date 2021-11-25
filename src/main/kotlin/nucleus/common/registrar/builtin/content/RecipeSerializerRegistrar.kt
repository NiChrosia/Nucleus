package nucleus.common.registrar.builtin.content

import net.minecraft.recipe.RecipeSerializer
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.VanillaRegistrar

open class RecipeSerializerRegistrar(override val group: ContentGroup) : VanillaRegistrar<RecipeSerializer<*>>(group, Registry.RECIPE_SERIALIZER)