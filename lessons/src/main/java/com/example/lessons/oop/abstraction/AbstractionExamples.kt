package com.example.lessons.oop.abstraction

abstract class Payment {

    abstract fun pay(amount: Double)

    fun printReceipt() {
        println("Payment completed")
    }
}

class CreditCardPayment : Payment() {

    override fun pay(amount: Double) {
        println("Paid $amount using Credit Card")
    }
}

class CashPayment : Payment() {

    override fun pay(amount: Double) {
        println("Paid $amount using Cash")
    }
}

class PayPalPayment : Payment() {

    override fun pay(amount: Double) {
        println("Paid $amount using PayPal")
    }
}

fun main() {
    val paypal = PayPalPayment()
    val credit = CreditCardPayment()
    val cashPayment = CashPayment()

    makePayment(paypal,11.1)
    makePayment(credit,11.1)
    makePayment(cashPayment,11.1)

}

fun makePayment(payment : Payment,amount: Double){
    payment.pay(amount)
    payment.printReceipt()
}