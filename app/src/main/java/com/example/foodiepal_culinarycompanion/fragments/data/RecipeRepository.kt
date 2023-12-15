package com.example.foodiepal_culinarycompanion.fragments.data

import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.fragments.model.Recipe

class RecipeRepository {

    companion object{
        val recipes = ArrayList<Recipe>()

        fun intializeData(){
            recipes.add(Recipe("Spaghetti Bolognese", "Chef John", "Classic Italian pasta dish with a rich meat sauce.", R.drawable.spaghetti))
            recipes.add(Recipe("Chicken Alfredo", "Chef Emily", "Creamy Alfredo sauce paired with grilled chicken and fettuccine.", R.drawable.chicken))
            recipes.add(Recipe("Vegetarian Stir-Fry", "Chef Alex", "Colorful stir-fried vegetables with tofu in a savory sauce.", R.drawable.vegetarian))
            recipes.add(Recipe("BBQ Pulled Pork Sandwich", "Chef Mike", "Slow-cooked pulled pork in barbecue sauce, served on a bun.", R.drawable.bbq))
            recipes.add(Recipe("Caprese Salad", "Chef Sophia", "Fresh tomatoes, mozzarella, and basil drizzled with balsamic glaze.", R.drawable.caprese))
            recipes.add(Recipe("Chocolate Chip Cookies", "Chef Olivia", "Soft and chewy cookies loaded with chocolate chips.", R.drawable.chicken))
            recipes.add(Recipe("Vegetable Curry", "Chef Aiden", "Aromatic curry with assorted vegetables and coconut milk.", R.drawable.chicken))
            recipes.add(Recipe("Grilled Salmon", "Chef Ethan", "Healthy and flavorful grilled salmon fillets with lemon.", R.drawable.chicken))
            recipes.add(Recipe("Mango Salsa", "Chef Ava", "Sweet and tangy salsa with fresh mango, tomatoes, and cilantro.", R.drawable.chicken))
            recipes.add(Recipe("Homemade Pizza", "Chef Noah", "Create your own pizza with your favorite toppings and cheese.", R.drawable.chicken))

        }
    }
}