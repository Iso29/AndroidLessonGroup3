package com.example.lessons

fun main() {
    normalFunc("tets")
    inlineFunc("message", doInt = {
        println("skksnkcascasc")
    })


    normalFunc("tets")

    normalFunc("tets")
    normalFunc("tets")

}

fun normalFunc(msg : String) {
    if(msg.isNotBlank()){
        println(msg)
    }else{
        println("Msg is empty")
    }
}


inline fun inlineFunc(msg : String,  doInt :  () -> Unit) {
    if(msg.isNotBlank()){
        println(msg)
    }else{
        println("Msg is empty")
    }
}