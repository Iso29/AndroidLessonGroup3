package com.example.lessons

import kotlin.random.Random

fun main() {
    giveNumber()
    val array = arrayOf(11,22,33,44,55,66)
    val array2 = arrayOf("I","o","a","c")

//    for(i in 0 .. array.size-1){
//        println(array[i])
//    }
//
//    for(i in 0 .. array2.size-1){
//        println(array2[i])
//    }

//    sayHi()

//    val randomNumber = giveNumber(array.size)
//    println(array[randomNumber])

    val a = readlnOrNull()?.toIntOrNull()?:0
    val b = readlnOrNull()?.toIntOrNull()?:0
    val result = sum(a,b)
    if(result>0){
        println("result is positive ${result}")
    }else{
        println("result is negative ${result}")
    }

//    val myValue = sayHi2()
//    println(myValue)

}

fun sayHi() : Unit{
    println("Hii!")
    return
}


fun ageChecker(age : Int) : Unit {
    if(age>18){
        println("Say hi")
        return
    }

    if(age<18){
        println("say no")
        return
    }

    if(age==18){
        println("asaadas")
        return
    }
}

fun sayHi2() : String {
    return "Hii!"
}

fun giveNumber(limit : Int = 100) : Int {
    return Random.nextInt(limit)
}

fun sum(num1 : Int ,num2: Int) : Int {
    return num1+num2
}

fun arrayPrinter(){

}