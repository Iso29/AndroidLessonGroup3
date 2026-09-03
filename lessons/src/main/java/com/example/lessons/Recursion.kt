package com.example.lessons

fun main() {
    countIt(endPoint = 10)
}

fun countIt(startPoint: Int = 0, endPoint: Int, step: Int = 1) {
    println(startPoint)
    if(startPoint>=endPoint) return

    val newValue = startPoint+step
    countIt(newValue,endPoint,step)
}