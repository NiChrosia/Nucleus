package nucleus.api.category

interface Category {
    val categories: List<Category>

    fun launch() {
        for (category in categories) category.launch()
    }
}