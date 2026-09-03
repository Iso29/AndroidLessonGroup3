package com.example.lessons.oop.ploy

fun main() {
    val dog  = Dog("Pitpull",6)

    val wolf = Wolf("Yalniz kurt",11)
    val animal = Animal("unknown animal",0,true)

    val animals = arrayOf<Animal>(
        dog,animal,wolf
    )

    for(a in animals){
        a.makeNoise()
//        when(a){
//            is Dog -> {
//                a.walk()
//            }
//            is Wolf -> {
//                a.hunting()
//            }
//            else -> {
//                a.makeNoise()
//            }
//        }
    }
}

fun giveFullNameAnimal(animal  : Animal) : String {
    return "${animal.cinsi} ${animal.age} ${animal.isWild}"
}

fun makePayment(amount : Float){
    println("...")
}

fun makePayment(amount : Float,withCrypto : String){
    println("...")
}

open class Animal(
    val cinsi: String,
    val age: Int,
    val isWild: Boolean
) {
    open fun makeNoise() {
        println("Unknown animal..")
    }
}

class Dog(
    cinsi: String,
    age: Int
) : Animal(cinsi, age, false) {

    fun walk(){
        println("Walking with owner..")
    }

    override fun makeNoise() {
        println("Hav hav...")
    }
}

class Wolf(
    cinsi: String,
    age: Int
) : Animal(cinsi, age, true) {
    fun hunting(){
        println("Searching for victim..")
    }

    override fun makeNoise() {
        println("UUUUUU....")
    }
}