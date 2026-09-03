package com.example.lessons

fun main() {
//    doIt(
//        action = {
//            println("Call my friends")
//        }
//    )

//    var result = 0L
//    calculate(
//        num1 = 20L,
//        num2 = 10L,
//        op = '-',
//        error = null,
//        success = { netice -> // callback
//            result = netice
//            println("Sizin emeliyatiniz ugurlu oldu")
//        }
//    )
//    println("result = ${result}")



    //test main
    getNumberAndSum(
        success = { res ->
            println("Ugurlu netice : $res")
            return@getNumberAndSum// global return
        },
        error = {
            "Xeta!!"
        }
    )

    println("Main func finished")
}

fun doIt(action: () -> Unit) {
    println("test")
    println("test")
    println("test")
    println("test")
    println("test")

    action()

    println("test")
    println("test")
}

fun calculate(
    num1: Long,
    num2: Long,
    op: Char,
    success: () -> Unit,
    error: () -> Unit
): Long? {
    val result = when (op) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '/' -> num1 / num2
        '*' -> num1 * num2
        else -> null
    }
    if (result == null) {
        error()
    } else {
        success()
    }
    return result
}

fun calculate(
    num1: Long,
    num2: Long,
    op: Char,
    success: (num1: Long) -> Unit = {},
    error: ((errorMessage: String) -> Unit)? = {}
) {
    val result = when (op) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '/' -> num1 / num2
        '*' -> num1 * num2
        else -> null
    }
    if (result == null) {
        error?.invoke("Xeta!!")
    } else {
        success.invoke(result)
    }
}


inline fun getNumberAndSum(
    crossinline success: (result : Int) -> Unit,
    noinline error: () -> String = { "" }
) {
    println("Enter num 1 ")
    val num1 = readlnOrNull()?.toIntOrNull() ?: 0

    println("Enter num 2 ")
    val num2 = readlnOrNull()?.toIntOrNull() ?: 0

    println("Enter op : \" +,-,*,/ \"")
    val op = readlnOrNull()?.firstOrNull()

    if (op == null) {
        val message = error()
        println("error : ${message}")
    }

    val result = when (op) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '/' -> num1 / num2
        '*' -> num1 * num2
        else -> null
    }

    if (result == null) {
        val message = error()
        println("error : ${message}")
    }else{
        success(result)
    }

    println("Function is finished")
}

fun act() {} //lambda