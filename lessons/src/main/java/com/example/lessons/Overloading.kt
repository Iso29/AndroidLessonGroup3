package com.example.lessons

fun main() {
    val result = calculate(1,2,'+')
    println("result ${result}")
}

fun calculate(num1 : Int, num2 : Int,op : Char) : Int? {
    return when(op){
        '+' -> num1+num2
        '-' -> num1-num2
        '/' -> num1/num2
        '*' -> num1*num2
        else -> null
    }
}

fun calculate(num1 : Double, num2 : Double,op : Char) : Double? {
    return when(op){
        '+' -> num1+num2
        '-' -> num1-num2
        '/' -> num1/num2
        '*' -> num1*num2
        else -> null
    }
}

