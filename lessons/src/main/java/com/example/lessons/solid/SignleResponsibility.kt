package com.example.lessons.solid

data class User(
    val username: String = "",
    val password: String = "",
    val isNew : Boolean = true,
    val isLoyal : Boolean = false,
    val email: String = "",
)

class UserManager {
    fun fetchUser(id: String): User {
        println("Api call")
        return User()
    }

    fun saveToDb(user: User) {
        println("${user} saved into phone storage")
    }

    fun formatDisplayName(user: User): String {
        return user.username
    }
}

// Better
class UserApi {
    fun fetch(id: String): User {
        println("Api call")
        return User()
    }
}

class UserDao {
    private var userData: User? = null
    fun insert(user: User) {
        println("${user} saved into phone storage")
    }

    fun getUserInfo(): User? {
        return userData
    }
}

class UserRepository(
    private val api: UserApi,
    private val dao: UserDao
) {
    fun formatDisplayName(): String {
        val localData = dao.getUserInfo()
        if (localData != null) {
            return localData.username
        } else {
            return api.fetch("10").username
        }
    }
}

data class Order(
    val id: Long = 0L,
    val items: List<String> = emptyList(),
    val total : Double = 0.0,
    val user : User = User()
)

class OrderDataBase() {
    public fun insertOrder(order: Order) {
        println("${order} is added into local storage")
    }
}

class EmailClient() {
    fun send(
        email: String,
        message: String
    ) {
        println("email sent to ${email}")
        println("content : ${message}")
    }
}


class OrderVerifier() {
    fun orderVerify(order: Order) {
        if (order.items.isEmpty()) throw IllegalArgumentException()   // validation
    }
}

class OrderService(
    private val orderDb: OrderDataBase = OrderDataBase(),
    private val emailClient: EmailClient = EmailClient(),
    private val orderVerifier: OrderVerifier = OrderVerifier(),
) {

    fun placeOrder(order: Order) {
        orderVerifier.orderVerify(order)
        orderDb.insertOrder(order)                                        // persistence
        emailClient.send(order.user.email, "Order confirmed")          // notification
    }

    fun placeOrder2(order: Order) {
        if (order.items.isEmpty()) throw IllegalArgumentException()   // validation
        println("${order} is added into local storage")
        println("email sent to ${order.user.email}")
        println("content : Order confirmed")
    }
}

fun main() {
    val order = Order(
        items = listOf("Macbook air", "USB cable"),
    )
    OrderService().placeOrder(
        order
    )
}

