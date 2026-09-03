package com.example.lessons

fun main() {
//    var userName1 = "Ismayil"
//
    val array = arrayOf("Ismayil","Leyla","Ilkin","Kenan")
//    array[0] = ""

//    val students = Array<String?>(5){null}
//    for(i in 0 .. students.size-1){
//        println("Enter ${i+1} . student name")
//        val stName = readlnOrNull()
//        students[i] = stName
//    }
//    println("List is full already")
//
//    println("Enter index which user you want to remove")
//    val index = readlnOrNull()?.toIntOrNull()?:-1
//
//    if(index in 0..students.size-1){
//        students[index] = null
//    }
    //0 .. 3 //4

//    for(i in 10 downTo 0 step 2){
//        println(i)
//    }
//    println(array[0])
//    println(array[1])
//    println(array[2])
//    println(array[3])

    for(i in 0 .. array.size-1){
        if(array[i] == "Ilkin"){
            break
        }
        println(array[i])
    }

//    var i = 0
//    while (i < array.size){
//        println(array[i])
//        i++
//    }

//    do {
//        println(array[0])
//    } while (i<0)
}