package com.example.lessons

fun main1() {
    val userName = "Ismayil"
    val password = "test123"

    println("pls enter your credentials")

    println("enter username : ")
    val inputUs = readLine().toString()

    println("enter password : ")
    val inputPass = readLine().toString()

    val isPermitted = if(inputUs==userName && inputPass == password){
        println("${userName} , u are welcome")
        true
    }else if(userName == inputUs){
        println("password is not correct")
        false
    }else{
        println("Invalid credentials!")
        false
    }

    println("is permitted ${isPermitted}")
}

fun main() {
    println("Enter day of week")
    val weekDay = readlnOrNull()?.toIntOrNull()?:0

    if(weekDay==1){

    }else if(weekDay==2){

    }else if(weekDay==3){

    }else{

    }

    when(weekDay){
        1-> println("Monday")
        2 -> println("Thusday")
        3 -> println("Wendesday")
        4 -> println("///")
        else -> println("Others")
    }
}