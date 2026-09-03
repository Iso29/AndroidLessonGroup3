package com.example.lessons


class Person{
    var name : String = ""
    var surname : String = ""
    public var age : Int = 0
    public var heigh : Float = 0.0f

    private fun run(){
        println("${name} is running...")
    }

    fun walk(){
        println("${name} is walking...")
    }

    init {
        incrSay()
//        println("Obyekt yarandi:")
    }

    constructor(
        name : String,surname : String , age : Int
    ){
//        println("Parametrli constructor isledi...")
        this.name = name
        this.surname = surname
        this.age = age
    }

    private constructor(){
//        println("Parametrsiz constructor isledi...")
    }

    fun printPersonDetails(){
        println("name : ${this.name}")
        println("surname : ${this.surname}")
        println("age : ${this.age}")
    }

     companion object {
         private var say = 0

        init {
//            println("Class yuklendi.")
        }

        fun incrSay(){
            say++
        }

        fun printSay(){
            println("Say : $say")
        }
    }
}

fun main() {
    val student1 = Person("Ilkin", "Mehdixanov", 20)//constructor

    val student2 = Person("Leyla", "Hemidova", 28)

    val student3 = Person("Ismayil", "Islamzada", 23)

    val student4 = Person("Zaur","Elsadov",34)

    val studentList = arrayOf(student1,student2,student3,student4)

    for(telebe in studentList){
        telebe.printPersonDetails()
        println()
    }


//    student3.printPersonDetails()

//    printPersonDetails(student1)
//

//    student1.run()
//    student2.walk()

//    student1.name = "Kenan"
//    printPersonDetails(student1)
//    printPersonDetails(student2)

//    Person.printSay()
}





