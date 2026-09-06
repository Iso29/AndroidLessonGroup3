package com.example.lessons.solid

import com.example.lessons.oop.abstraction.CreditCardPayment

interface ReadableStorage {
    fun readProperty(key: String): String
}

interface WriteableStorage {
    fun writeProperty(key: String, value: String)
}

open class Storage : ReadableStorage, WriteableStorage {
    private val localStorage: HashMap<String, String> = hashMapOf<String, String>()

    override fun writeProperty(key: String, value: String) {
        localStorage.put(key, value)
    }

    override fun readProperty(key: String): String {
        return localStorage.getValue(key)
    }
}

class ReadOnlyStorage : ReadableStorage {
    val localStorage = mapOf<String, String>()

    override fun readProperty(key: String): String {
        return localStorage.getValue(key)
    }
}

fun main() {
//    val storage = Storage()
//    storage.writeProperty("username", "Ismayil")
//
//    val readOnlyStorage = ReadOnlyStorage()
//    readOnlyStorage.readProperty("username")

    /*
    1. card
    2. cash
    3. gift
     */

    val gift = GiftCardOnDelivery()
    val card = CardOnDelivery()

    makePayment(
        gift,
        2000.0
    )
    card.refund(2000.0)

}


fun makePayment(
    paymentMethod: PaymentMethod,
    amount: Double
) {
    paymentMethod.pay(amount)
}

open class PaymentMethod {
    open fun pay(amount: Double) { /* charge */
    }
}

interface Refundable {
    fun refund(amount: Double)
}

class CashOnDelivery : PaymentMethod(), Refundable {
    override fun refund(amount: Double) {
        println("Amount is refunded by cash ${amount}")
    }
}

class CardOnDelivery : PaymentMethod(), Refundable {
    override fun refund(amount: Double) {
        println("Amount is refunded by card ${amount}")
    }
}

class GiftCardOnDelivery : PaymentMethod() {
}