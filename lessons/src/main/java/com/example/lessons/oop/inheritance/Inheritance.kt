package com.example.lessons.oop.inheritance

fun main() {
    val student = Student(
        name = "Ilkin",
        surname = "Maajad",
        fin = "123173",
        username = "IlkinMM",
        password = "uwdqu",
        points = arrayListOf(
            TopicWithAvarage(
                Topics("Android"),
                97.1f
            )
        )
    )

    student.getFullName()
}

fun main1() {
    while (true) {
        val op = readlnOrNull()?.toIntOrNull() ?: 0

        when (op) {
            1 -> {

            }

            2 -> {

            }

            else -> {
                println("invalid operation")
                return
            }
        }

    }
}

fun printOperations() {
    println(
        """
            1. print students
            2. add student
        """.trimIndent()
    )
}

fun loginTeacher(): Boolean {
    println("Enter username :")
    val username = readlnOrNull() ?: ""

    println("Enter password :")
    val password = readlnOrNull() ?: ""

    val teacher = Teacher.teachers
    for (t in teacher) {
        if (t.username.equals(username) && t.password.equals(password)) {
            return true
        }
    }
    return false
}

abstract class SystemPerson(
    val name: String,
    val surname: String,
    val fin: String
) {
    abstract fun getFullName() : String
}

abstract class SystemUser(
    name: String,
    surname: String,
    fin: String,
    val username: String,
    val password: String
) : SystemPerson(
    name, surname, fin
) {

}


class TopicWithAvarage(
    val topic: Topics,
    val point: Float
)

class Topics(
    val topics: String
)

class Student(
    name: String,
    surname: String,
    fin: String,
    username: String,
    password: String,
    val points: ArrayList<TopicWithAvarage>
) : SystemUser(
    name, surname, fin, username, password
) {

    override fun getFullName(): String {
        return "${name} ${surname} ${fin} ${points}"
    }
    companion object {

    }
}

class Teacher(
    name: String,
    surname: String,
    fin: String,
    username: String,
    password: String,
    val salary: Float,
    val topics: ArrayList<Topics>
) : SystemUser(
    name, surname, fin, username, password
) {

    override fun getFullName(): String{
        return "${name} ${surname} ${fin} ${salary}"
    }
    companion object {
        private fun getTeachers1(): ArrayList<Teacher> {
            return arrayListOf(
                Teacher(
                    "Ismayil",
                    "Islamzada",
                    "86126712",
                    "ismayilisi",
                    "123141",
                    11.2f,
                    arrayListOf(
                        Topics(
                            "Android"
                        ),
                        Topics(
                            "Android"
                        )
                    )
                )
            )
        }

        val teachers: ArrayList<Teacher>
            public get() = getTeachers1()
    }
}