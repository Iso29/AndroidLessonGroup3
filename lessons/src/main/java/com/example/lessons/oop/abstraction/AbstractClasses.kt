package com.example.lessons.oop.abstraction

fun main() {
    val machine = Car(
        "Ford",
        "Raptor",
        "Ford company",
        2023,
        100.0
    )

    machine.run()
}

abstract class Machine(
    val mark: String,
    val model: String,
    val manufacturer: String,
    val productionYear: Int
) {
    abstract fun run()
}

class Car(
    mark: String,
    model: String,
    manufacturer: String,
    productionYear: Int,
    var oil : Double
) : Machine(
    mark, model, manufacturer, productionYear
) {
    override fun run() {
        oil-=20
        println("current oil ${oil} , and it run ..")
    }

    public fun fillFuel(value : Double) {
        oil += value
    }
}

class WashingMachine(
    mark: String,
    model: String,
    manufacturer: String,
    productionYear: Int,
    var isOnCharging : Boolean
) : Machine(
    mark, model, manufacturer, productionYear
) {
    override fun run() {
        if(isOnCharging){
            println("It runs")
        }else{
            println("No electricity")
        }
    }
}