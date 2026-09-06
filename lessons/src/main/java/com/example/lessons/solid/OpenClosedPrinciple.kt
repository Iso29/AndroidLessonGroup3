package com.example.lessons.solid


interface DiscountRule {
    fun applies(order: Order): Boolean
    fun amount(order: Order): Double
}

class NewUserDiscount : DiscountRule {
    override fun applies(order: Order) = order.user.isNew
    override fun amount(order: Order) = order.total * 0.10
}

class BulkDiscount : DiscountRule {
    override fun applies(order: Order) = order.items.size >= 10
    override fun amount(order: Order) = order.total * 0.20
}

class DiscountCalculator(
    private val rules: List<DiscountRule> = emptyList()
) {
    fun discount(order: Order, type: String): Double = when (type) {
        "NEW_USER" -> order.total * 0.10
        "BLACK_FRIDAY" -> order.total * 0.30
        "LOYAL_USER" -> order.total * 0.2
        else -> 0.0
    }

    fun totalDiscount(order: Order): Double {
        var total = 0.0

        for (rule in rules) {
            if (rule.applies(order)) {
                val discount = rule.amount(order)
                total += discount
            }
        }
        return total

    }

}

class LoyalUserDiscount : DiscountRule {
    override fun applies(order: Order): Boolean {
        return !order.user.isNew && order.user.isLoyal
    }

    override fun amount(order: Order): Double {
        return order.total * 0.2
    }
}

fun main() {
//    val user = User(
//        username = "Ismayil",
//        password = "qwqweqe",
//        isNew = false,
//        isLoyal = true,
//        email = "ismayil@gmail.com"
//    )
//    val order = Order(
//        user = user,
//        total = 2500.0,
//        items = listOf("Macbook air", "USB cable"),
//    )
//    val promocodes = listOf("LOYAL_USER")

//    var total = order.total
//    for (codes in promocodes) {
//        total -= discount(order, type = codes)
//    }

//    val calculator = DiscountCalculator(
//        listOf(
//            LoyalUserDiscount(),
//            BulkDiscount()
//        )
//    )
//    total -= calculator.totalDiscount(order)
//
//    println("Before discount : ${order.total}")
//    println("After discount : ${total}")

    val circle = Circle(15.0)
    val square = Square(20.0)
    println(areaCalculator(circle))
    println(areaCalculator(square))

//    println(area(circle))
//    println(area(square))
}

// Bad: every new type means editing this function

fun areaCalculator(
    shape : Shape
) : Double {
    return shape.calculateArea()
}

fun area(shape: Shape): Double = when (shape) {
    is Circle -> PI * shape.r * shape.r
    is Square -> shape.side * shape.side
    is Triangle -> 0.0
    else -> 0.0
}

private const val PI = 3.14

// Better
interface Shape {
    fun calculateArea(): Double
}

class Triangle(
    val a: Double, val b: Double, val c: Double
) : Shape {
    override fun calculateArea(): Double {
        return a * b * c / 2
    }
}

class Circle(val r: Double) : Shape {
    override fun calculateArea() = PI * r * r
}

class Square(val side: Double) : Shape {
    override fun calculateArea() = side * side
}