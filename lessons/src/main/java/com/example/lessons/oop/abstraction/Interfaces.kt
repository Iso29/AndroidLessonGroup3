package com.example.lessons.oop.abstraction

//no constructor
//no property
//many implementation

//constructor
//property inheritance
//one extent

fun main() {
    val toyuq = Toyuq("ysaq")
    val qartal = Qartal("Qartal")

    println(toyuq is Bird)
    println(toyuq is Toyuq)
    println(toyuq is Qartal)

}

interface Ucabilen{
    abstract fun fly()
}

interface EtYeyen{
    abstract fun huntAnimal()
}

interface OtYeyen{
    abstract fun findFeed()
}

abstract class Bird(
    val cinsi: String,
    val vehsi: Boolean
) {

}

class Toyuq(
    cins: String,
) : Bird(cins, false) , OtYeyen {
    override fun findFeed() {
        println("Find feeds")
    }
}
open class Test{}
class Qartal(
    cinsi: String,
) : Bird(cinsi, true) , Ucabilen , EtYeyen{
    override fun huntAnimal() {
        println("Searching for animals...")
    }
    override fun fly() {
        println("Qartal ucur...")
    }
}