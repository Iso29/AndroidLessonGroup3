package com.example.lessons.patterns

abstract class Notification(
    val id : Int,
    val title : String,
    val subtitle : String
) {
    fun show() {
        println(
            """
                ${id}
                ${title}
                ${subtitle}
            """.trimIndent()
        )
    }
}

class MessageNotification(
     id : Int,
    title: String,
    subtitle: String,
    val fromId : Int,
) : Notification(id,title,subtitle)

class NewsNotification(
    id : Int,
    title: String,
    subtitle: String,
    val newsMessage : String
) : Notification(id,title,subtitle)


class NotificationFactory {
    companion object {
        fun buildNotification(
            notificationType : String
        ) : Notification {
            return when (notificationType.uppercase()) {
                "NEWS" -> {
                    NewsNotification(1,"news in stories","ahowhcwhcuqec","test message")
                }
                "MESSAGE" -> {
                    MessageNotification(
                        2,"from Ilkin","salam muellim",200
                    )
                }
                else ->  throw RuntimeException("Notification could not shown!")
            }
        }
    }
}


abstract class PaymentMethod {
    abstract fun pay(amount : Double)
}

class CardMethod() : PaymentMethod() {
    override fun pay(amount: Double) {
        println("Pay by card , amount :${amount}")
    }
}

class CashMethod() : PaymentMethod() {
    override fun pay(amount: Double) {
        println("Pay by cash , amount :${amount}")
    }
}

fun main() {
//    println("Enter payment way : \n 1.Cash \n 2.CARD")
//    val method = readlnOrNull()?:""
//
//    println("Enter amount you want to pay :")
//    val amount = readlnOrNull()?.toDoubleOrNull()?:0.0
//
//    val paymentMethod = PaymentFactory.createPaymentMethod(method)
//    paymentMethod.pay(amount)

    val receivedNotification = readlnOrNull()?:""
   val notification =  NotificationFactory.buildNotification(receivedNotification)
    notification.show()
}

class PaymentFactory {
    companion object {
        fun createPaymentMethod(
            paymentMethod : String
        ) : PaymentMethod {
            return when (paymentMethod.uppercase()) {
                "CARD" -> {
                    CardMethod()
                }
                "CASH" -> {
                    CashMethod()
                }
                else -> {
                    throw RuntimeException("There is no type payment method!")
                }
            }
        }
    }
}