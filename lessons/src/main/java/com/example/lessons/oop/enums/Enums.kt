package com.example.lessons.oop.enums

private class User(
    val username: String,
    val password: String,
    val role: UserRole
)

fun main() {
    val admin = User(
        "Wolt company",
        "1231214",
        UserRole.ADMIN
    )

    val restaurant = User(
        "Pizza Mizza",
        "1231214",
        UserRole.RESTAURANT
    )

    val restaurant2 = User(
        "Pizza Mizza",
        "1231214",
        UserRole.RESTAURANT
    )

    val customer = User(
        "Ismayil",
        "123131",
        UserRole.CUSTOMER
    )

    val courier = User(
        "Anar",
        "123131",
        UserRole.COURIER
    )

//    checkRole(restaurant)
//    checkRole(courier)
//    checkRole(customer)

    val role = "admin"
    val user = User(
        "admin111",
        "adada",
        UserRole.fromString(role)
    )

    user.role.printNameWithOrder()
}

private fun checkRole(user: User) {
    user.role.printNameWithOrder()
    when (user.role) {
        UserRole.ADMIN -> println("Admin is working..")
        UserRole.CUSTOMER -> println("order status : ...")
        UserRole.COURIER -> println("courier status : ..")
        UserRole.RESTAURANT -> println("Located in ....")
        UserRole.MARKET -> println("Is not available")
    }
}

private enum class UserRole(
    var order: Int = -1
) {
    ADMIN(1),
    CUSTOMER(2),
    COURIER(3),
    RESTAURANT(4),
    MARKET;

    fun printNameWithOrder() {
        println("Role : ${this.name} and its order : ${this.order}")
    }

    companion object {
        fun fromString(roleName: String): UserRole {
            return when (roleName) {
                "admin" -> UserRole.ADMIN
                "courier" -> UserRole.COURIER
                "restaurant" -> UserRole.RESTAURANT
                "customer" -> UserRole.CUSTOMER
                else -> UserRole.MARKET
            }
        }
    }
}