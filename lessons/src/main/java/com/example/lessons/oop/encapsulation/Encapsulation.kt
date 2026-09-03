package com.example.lessons.oop.encapsulation

class Machine {
    var mark: String = ""
       private set(value) {
            if (value.isBlank()) {
                throw Exception("Crash")
            }
            field = value
        }
        get()  {
           return field
        }

    var model: String = ""

    constructor()

//    constructor(
//        mark : String,
//        model : String
//    ){
//        this.mark = mark
//        this.model = model
//    }

    fun getMarka(): String {
        return this.mark
    }

    fun getModele(): String {
        return this.model
    }

    fun setModele(model: String) {
        if (model.isBlank()) {
            throw Exception("Can not be blank")
        }
        this.model = model
    }

    fun setMarka(mark: String) {
        if (mark.isBlank()) {
            throw Exception("Can not be blank")
        }
        this.mark = mark
    }
}

class User(
    private val username: String,
    private val password: String
) {

    fun getUsernamee(): String {
        return this.username
    }

}


fun main() {
//    val machine = Machine()
//    machine.mark
//    machine.model = "$"
////    machine.setMark("Ford")
////    machine.setModel(" ")
//    println("mark : ${machine.getMark()} , model ${machine.getModel()}")

    login()
}


fun login() {
    println("Enter username :")
    val username = readlnOrNull()

    println("Password : ")
    val password = readlnOrNull()

    val user = User(username ?: "", password ?: "")

    println("${user.getUsernamee()} is logged in ")
}