package com.example.lessons.task

import kotlin.math.PI
import kotlin.math.sin

/*

| Name | Age | Scores | Repeat |
|---|---|---|---|
| Aysel | 19 | 88, 92.5, 79 | false |
| Rauf | 21 | 45, 58, 61.5 | true |
| Nigar | 20 | 100, 95, 98 | false |
| Elvin | 22 | 30, 42, 55 | true |
| Leyla | 19 | 71, 68.5, 74 | false |

**B. Functions to write**
1. `average(scores)` — returns the average of an array of numbers. Must use a loop, not a built-in.
2. `letterGrade(avg)` — returns `"A"` (90+), `"B"` (80–89), `"C"` (70–79), `"D"` (60–69), `"F"` (below 60). Use a conditional chain or `switch`/`when`.
3. `bonus(student)` — repeat students get +5 points added to their average, but the result must never exceed 100. Use an operator-based clamp, not an `if` for the ceiling.
4. `passed(student)` — returns `true` if the final average (after bonus) is 60 or above.
 */

fun test(
    yes : () -> Unit,
    no : () -> Unit
){
    val yOrNo = readlnOrNull()?.firstOrNull()?:'N'
    when(yOrNo){
        'N' -> {
            no()
        }

        'Y' -> {
            yes()
        }

        else -> {
            print("")
        }
    }
}

fun main() {
    test(
        no = {
            println("User select NO!")
        },
        yes = {
            println("User select YES!")
        }
    )
}

fun main1() {
    val studentsName = getStudentsName()
    val studentsAge = getStudentsAge()
    val studentsScores = getStudentsScores()
    val studentsRepeats = getStudentIsRepeat()

    val avarages = Array(studentsName.size){0f}
    for(i in 0 until  studentsScores.size){
        val avg = calculateStudentsAvarage(studentsScores[i])
        avarages[i] = avg
    }

    val grades = avarages.map { avg ->
        defineWhichGrade(avg)
    }

    val isFailorNot = grades.filter { grade ->
        grade != 'F'
    }

    printStudentsInfo(
        studentsName,
        studentsAge,
        studentsScores,
        studentsRepeats
    )

//    for(i in avarages){
//        print(" $i ,")
//    }
//    println()
//    for(i in grades){
//        print(" $i ,")
//    }
//
//    println()
//    for(i in isFailorNot){
//        print(" $i ,")
//    }

    println()
    val filteredStudents = findStudents(studentsName){ index ->
        studentsName[index].startsWith("R") ||
                studentsName[index].startsWith("E")
    }

    for (i in filteredStudents) {
        print(" $i ,")
    }

//    while(true){
//        println("Enter which operation you want to do :")
//        println("0. Print students table \n 1.average \n 2.letterGrade \n 3.Bonus \n 4. Is Passed")
//        val operator = readlnOrNull()?.toIntOrNull()?:-1
//
//        defineWhichOperation(
//            op = operator,
//            printUsers = {
//                printStudentsInfo(
//                    studentsName,
//                    studentsAge,
//                    studentsScores,
//                    studentsRepeats
//                )
//            },
//            printAvarage = { studentIndex ->
//                val name = studentsName[studentIndex]
//                val studentsScore = studentsScores[studentIndex]
//                val avarage = calculateStudentsAvarage(studentsScore)
//                println("Student : $name, avarage score : ${avarage}")
//            },
//            printGrade = { stIndex ->
//                val name = studentsName[stIndex]
//                val studentsScore = studentsScores[stIndex]
//                val avarage = calculateStudentsAvarage(studentsScore)
//                val grade = defineWhichGrade(avarage)
//                println("Student : $name,  Grade : ${grade}")
//            },
//            noOperationDefinedError = { op ->
//                println("There is no operation name ${op}")
//            }
//        )
//    }
}

fun defineWhichGrade(avarage : Float) : Char {
    return when(avarage){
        in 90f..100f -> {
            'A'
        }
        in 80f .. 89f ->{
            'B'
        }
        in 70f .. 79f -> {
            'C'
        }
        in 60f .. 69f ->{
            'D'
        }
        else -> {
            'F'
        }
    }
}

fun findStudents(
    studentsName : Array<String>,
    predication : (index : Int) -> Boolean
) : Array<String>{
    val filteredStudents = Array(studentsName.size){""}
    var filteredIndex = 0
    for(i in 0 until studentsName.size){
        val isTrue = predication(i)
        if(isTrue){
            filteredStudents[filteredIndex] = studentsName[i]
            filteredIndex++
        }else{
            continue
        }
    }
    return filteredStudents
}

fun defineWhichOperation(
    op : Int,
    printUsers : () -> Unit,
    printAvarage : (index : Int) -> Unit,
    printGrade : (index : Int) -> Unit,
    noOperationDefinedError : (op : Int) -> Unit
){
    when(op){
        0 -> {printUsers()}
        1 -> {
            val index = getStudentsOrder()
            printAvarage(index)
        }
        2 -> {
            val index = getStudentsOrder()
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

fun getStudentsOrder() : Int{
    println("Which student (index) ?")
    val studentIndex = readlnOrNull()?.toIntOrNull()?:0
    return studentIndex
}

fun calculateStudentsAvarage(scores: Array<Float>) : Float{
    var sum = 0f
    for (i in scores){
        sum+=i
    }
    return sum/scores.size
}

fun printUserScores(scores: Array<Float>) {
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

fun printStudentsInfo(
    names: Array<String>, ages: Array<Int>, scores: Array<Array<Float>>, repeats: Array<Boolean>
) {
    print("| Name |")
    print("| Age |")
    print("|      Scores            |")
    print("| Repeat |")
    println()
    if (names.size == ages.size && ages.size == scores.size && scores.size == repeats.size) {
        for (i in 0 until names.size) {
            print("| ${names[i]} |")
            print("| ${ages[i]} |")
            printUserScores(scores[i])
            print("| ${repeats[i]} |")
            println()
        }
    } else {
        return
    }
}

fun getStudentIsRepeat(): Array<Boolean> {
    return arrayOf(false, true, false, true, false)
}

fun getStudentsName(): Array<String> {
    return arrayOf(
        "Aysel", "Rauf", "Nigar", "Elvin", "Leyla"
    )
}

fun getStudentsAge(): Array<Int> {
    return arrayOf(
        19, 21, 20, 22, 19
    )
}

fun getStudentsScores(): Array<Array<Float>> {
    return arrayOf(
        arrayOf(88f, 92.5f, 79f),
        arrayOf(45f, 58f, 61.5f),
        arrayOf(100f, 95f, 98f),
        arrayOf(30f, 42f, 55f),
        arrayOf(71f, 68.5f, 74f)
    )
}