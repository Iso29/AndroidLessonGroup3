package com.example.lessons.oop.data

fun main() {
    val comp1 = Computer(
        "Leneovo",
        "Legion",
        2800.0
    )
    comp1.serialNumber = "121221"

    val comp2 = comp1.copy()


    val (mark2, model2 , price2) = comp2
    println("serial number : ${comp2.serialNumber}")

//    println(comp1==comp2)
//    println(comp1===comp2)
//
//    println(comp1)
}

data class Computer(
    val mark : String,
    val model : String,
    val price : Double
){
    var serialNumber : String = ""

}