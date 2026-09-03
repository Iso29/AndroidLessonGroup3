package com.example.lessons

fun main() {
    val student1 = Person("Ilkin", "Mehdixanov", 20)//constructor

//    student1.printFullName()

    println(10.sub1(20))

//    printFullName(student1)
}

infix fun Int.add(other : Int) : Int {
    return this + other
}

infix  fun Int.sub(other : Int) : Int {
    return this - other
}

fun Int.sub1(other : Int) : Int {
    return this - other
}

//infix fun ArrayList<Int>.subract(other : ArrayList<Int>) : ArrayList<Int>{
//    val finalArray = arrayListOf<Int>()
//    for(i in this){
//        for(e in other){
//            if(i == e){
//                break
//            }
//        }
//    }
//}

fun Int?.printValue(){
    println("My value is : ${this}")
}
fun Person.printFullName(){
    println("${this.name} ${this.surname}")
}