package com.example.lessons.coffieShopTask

fun main() {
    val coffeeManager = CoffeeMenuManager()
    coffeeManager.printMenu()
}

enum class CoffeeType {
    HOT, COLD
}

data class Coffee(
    val title: String,
    val description: String,
    val type: CoffeeType,
    val cost: Double
) {
    fun printCoffeeDetails() {
        println(" title : ${title} \n description : ${description} \n cost : ${cost}")
    }
}

class CoffeeMenuManager {
    private var coffeeMenu: ArrayList<Coffee> = ArrayList()

    init {
        coffeeMenu.addAll(getExistsMenu())
    }

    fun getCoffee(
        title: String, type: CoffeeType
    ): Coffee? {
        for (coffee in coffeeMenu) {
            if (coffee.title.equals(title, true) && coffee.type == type) {
                return coffee
            }
        }
        return null
    }

    fun printMenu() {
        val hotDrinks = splitHotDrinks()
        val coldDrinks = splitColdDrinks()

        println()
        println("${CoffeeType.HOT} : ")
        hotDrinks.forEachIndexed { index, coffee ->
            println()
            print("${index + 1}.")
            coffee.printCoffeeDetails()
            println()
        }

        println()
        println("${CoffeeType.COLD} : ")
        coldDrinks.forEachIndexed { index, coffee ->
            println()
            print("${index + 1}.")
            coffee.printCoffeeDetails()
            println()
        }
    }

    private fun splitHotDrinks(): List<Coffee> {
        val hotDrinks = ArrayList<Coffee>()
        for (coffee in coffeeMenu) {
            if (coffee.type == CoffeeType.HOT) {
                hotDrinks.add(coffee)
            }
        }
        return hotDrinks
    }

    private fun splitColdDrinks(): List<Coffee> {
        val coldDrinks = ArrayList<Coffee>()
        for (coffee in coffeeMenu) {
            if (coffee.type == CoffeeType.COLD) {
                coldDrinks.add(coffee)
            }
        }
        return coldDrinks
    }

    fun addCoffee() {
        println("Enter new coffee title : ")
        val title = readlnOrNull() ?: ""

        println("Enter new coffee description : ")
        val description = readlnOrNull() ?: ""

        println("Enter new coffee type : \n 1. Hot \n 2. Cold")
        val type = readlnOrNull()?.toIntOrNull() ?: return

        println("Enter new coffee cost : ")
        val cost = readlnOrNull()?.toDoubleOrNull() ?: return

        val typeEnum = if (type == 1) {
            CoffeeType.HOT
        } else if (type == 2) {
            CoffeeType.COLD
        } else {
            println("Invalid coffee type!")
            return
        }

        val newCoffee = Coffee(
            title = title,
            description = description,
            type = typeEnum,
            cost = cost
        )
        val isExists = checkIfCoffeeExists(newCoffee)
        if (isExists != null) {
            println(
                "Coffee already exists! "
            )
            isExists.printCoffeeDetails()
        } else {
            coffeeMenu.add(newCoffee)
        }
    }

    fun deleteCoffee() {
        println("Choose coffee you want to delete :")
        val coffeeIndex = readlnOrNull()?.toIntOrNull()
        if (coffeeIndex == null || coffeeIndex - 1 < 0 || coffeeIndex - 1 > coffeeMenu.size - 1) {
            println("There is no coffee with index")
            return
        }

        val deletedElement = coffeeMenu.removeAt(coffeeIndex - 1)
        println("Coffee removed from menu : ")
        deletedElement.printCoffeeDetails()
    }

    private fun checkIfCoffeeExists(
        coffee: Coffee
    ): Coffee? {
        for (cf in coffeeMenu) {
            if (cf.title.equals(coffee.title, true)) {
                return cf
            }
        }
        return null
    }
}

class OrderManager(
    val menuManager: CoffeeMenuManager
) {
    private var orderMenu: ArrayList<Coffee> = ArrayList()

    fun addOrder() {
        println("Enter coffee title : ")
        val title = readlnOrNull() ?: ""

        println("Enter coffee type : \n 1. Hot \n 2. Cold")
        val type = readlnOrNull()?.toIntOrNull() ?: return

        val typeEnum = if (type == 1) {
            CoffeeType.HOT
        } else if (type == 2) {
            CoffeeType.COLD
        } else {
            println("Invalid coffee type!")
            return
        }

        val fondCoffee = menuManager.getCoffee(title, typeEnum)
        if (fondCoffee != null) {
            orderMenu.add(fondCoffee)
        } else {
            println("There is no coffee you mentioned in menu")
            return
        }
    }

    //write delete order function

    fun deleteOrderFunction() {

    }

    //write print order function
}

fun getExistsMenu(): List<Coffee> {
    return listOf(
        Coffee(
            title = "Americano",
            description = "sert, sudsuz ve sekersiz coffe",
            type = CoffeeType.HOT,
            cost = 6.8
        ),
        Coffee(
            title = "Latte",
            description = "Yumusaq, sudlu ve sekerli coffe",
            type = CoffeeType.HOT,
            cost = 7.8
        ),
        Coffee(
            title = "Spanish Latte",
            description = "Yumusaq, ag skoladli ,sudlu ve sekerli coffe",
            type = CoffeeType.HOT,
            cost = 8.8
        ),
        Coffee(
            title = "Mocha",
            description = "Skoladli ,sudlu ve sekerli coffe",
            type = CoffeeType.HOT,
            cost = 8.8
        ),
        Coffee(
            title = "White Mocha",
            description = "Ag Skoladli ,sudlu ve sekerli coffe",
            type = CoffeeType.HOT,
            cost = 8.8
        ),
        Coffee(
            title = "Americano",
            description = "sert, sudsuz ve sekersiz coffe",
            type = CoffeeType.COLD,
            cost = 8.8
        ),
        Coffee(
            title = "Latte",
            description = "Yumusaq, sudlu ve sekerli coffe",
            type = CoffeeType.COLD,
            cost = 9.8
        ),
        Coffee(
            title = "Spanish Latte",
            description = "Yumusaq, ag skoladli ,sudlu ve sekerli coffe",
            type = CoffeeType.COLD,
            cost = 10.8
        ),
        Coffee(
            title = "Mocha",
            description = "Skoladli ,sudlu ve sekerli coffe",
            type = CoffeeType.COLD,
            cost = 10.8
        ),
        Coffee(
            title = "White Mocha",
            description = "Ag Skoladli ,sudlu ve sekerli coffe",
            type = CoffeeType.COLD,
            cost = 10.8
        )
    )
}