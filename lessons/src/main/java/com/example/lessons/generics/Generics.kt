package com.example.lessons.generics

import com.example.lessons.patterns.CardMethod

fun main1() {
    val intBox = BoxInt(10)
    intBox.testIt()
    val boxStr = BoxStr("Test")
    val boxDouble = BoxDouble(10.0)

    val intBox2 = BoxGeneric(10)
    val boxStr2 = BoxGeneric("Test")
    val boxDouble2 = BoxGeneric(10.0)

    val payment = BoxGeneric(CardMethod())

    printHelloWithValue(10)
    printHelloWithValue(CardMethod())
}

class BoxGeneric<T>
    (val myValue: T) {
    fun testIt() {
        println("testing ... ${myValue}")
    }
}

fun <T> printHelloWithValue(myValue: T) {
    println("my value is ${myValue} , and hello!")
}

class BoxInt(
    val intValue: Int
) {
    fun testIt() {
        println("testing ... ${intValue}")
    }
}

class BoxStr(
    val strValue: String
)

class BoxDouble(
    val doubleValue: Double
)

inline fun <reified T> isOfType(value: Any): Boolean {
    return value is T      // compile error: "Cannot check for instance of erased type: T"
}

fun main() {
    val test = isOfType<Number>(10)//
    /*
    10 is String
     */

    println("is ${test}")
}