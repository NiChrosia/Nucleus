package nucleus.test.category

import nucleus.common.registrar.category.RegistrarCategory
import nucleus.test.category.content.TContentCategory

object TestCategory : RegistrarCategory("nucleus") {
    val content by subcategory(::TContentCategory)
}