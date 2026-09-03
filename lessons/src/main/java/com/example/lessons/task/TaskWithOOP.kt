package com.example.lessons.task

class Student {
    var name: String = ""
    var age: Int = 0
    var scores: Array<Float> = arrayOf()
    var avarage: Float = 0.0f
    var repeate: Boolean = false

    constructor(
        name: String = "",
        age: Int = 0,
        scores: Array<Float> = arrayOf(),
        repeate: Boolean = false
    ) {
        this.name = name
        this.age = age
        this.scores = scores
        this.repeate = repeate
    }
}


fun main() {
    val studentsList = getStudentsList()

    printStudentsInfo1(
        students = studentsList
    )


    while (true) {
        println("Enter which operation you want to do :")
        println("0. Print students table \n 1.average \n 2.letterGrade \n 3.Bonus \n 4. Is Passed")
        val operator = readlnOrNull()?.toIntOrNull() ?: -1

        defineWhichOperation1(
            op = operator,
            printUsers = {
                printStudentsInfo1(
                    students = studentsList
                )
            },
            printAvarage = { studentIndex ->
                val student = studentsList[studentIndex]
                val avarage = calculateStudentsAvarage1(student.scores)
                println("Student : ${student.name}, avarage score : ${avarage}")
            },
            printGrade = { studentIndex ->
                val student = studentsList[studentIndex]
                val avarage = calculateStudentsAvarage1(student.scores)
                val grade = defineWhichGrade1(avarage)
                println("Student : ${student.name},  Grade : ${grade}")
            },
            noOperationDefinedError = { op ->
                println("There is no operation name ${op}")
            }
        )
    }
}

fun defineWhichGrade1(avarage: Float): Char {
    return when (avarage) {
        in 90f..100f -> {
            'A'
        }

        in 80f..89f -> {
            'B'
        }

        in 70f..79f -> {
            'C'
        }

        in 60f..69f -> {
            'D'
        }

        else -> {
            'F'
        }
    }
}

fun defineWhichOperation1(
    op: Int,
    printUsers: () -> Unit,
    printAvarage: (index: Int) -> Unit,
    printGrade: (index: Int) -> Unit,
    noOperationDefinedError: (op: Int) -> Unit
) {
    when (op) {
        0 -> {
            printUsers()
        }

        1 -> {
            val index = getStudentsOrder()
            printAvarage(index)
        }

        2 -> {
            val index = getStudentsOrder1()
            printGrade(index)
        }

        3 -> {

        }

        4 -> {}
        else -> {
            noOperationDefinedError(op)
        }
    }
}

fun getStudentsOrder1(): Int {
    println("Which student (index) ?")
    val studentIndex = readlnOrNull()?.toIntOrNull() ?: 0
    return studentIndex
}

fun calculateStudentsAvarage1(scores: Array<Float>): Float {
    var sum = 0f
    for (i in scores) {
        sum += i
    }
    return sum / scores.size
}

fun printUserScores1(scores: Array<Float>) {
    print("[")
    for (i in 0 until scores.size) {
        print(" ${scores[i]} ")
        if (i == scores.size - 1) {
            continue
        } else {
            print(",")
        }
    }
    print("]")
}

fun printStudentsInfo1(
    students: Array<Student>
) {
    print("| Name |")
    print("| Age |")
    print("|      Scores            |")
    print("| Repeat |")
    println()
    for (st in students) {
        print("| ${st.name} |")
        print("| ${st.age} |")
        printUserScores1(st.scores)
        print("| ${st.repeate} |")
        println()
    }
}

fun getStudentsList(): Array<Student> {
    val st1 = Student(
        "Aysel", 19, arrayOf(88f, 92.5f, 79f), false
    )
    val st2 = Student(
        "Rauf", 21, arrayOf(45f, 58f, 61.5f), true
    )
    val st3 = Student(
        "Nigar", 20, arrayOf(100f, 95f, 98f), false
    )
    return arrayOf(st1, st2, st3)
}
