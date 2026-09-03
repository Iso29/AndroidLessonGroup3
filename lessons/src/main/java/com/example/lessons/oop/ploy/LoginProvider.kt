package com.example.lessons.oop.ploy

fun main() {

    println("""
        Which method you want to login ?
        
        // 1. google //
        
        // 2. Apple //
    """.trimIndent())
    while (true){
        val selectedButton = readlnOrNull()?.toIntOrNull()?:-1
        val provider = createProvider(selectedButton)
        provider.login()
    }
}

fun createProvider(providerType : Int) : LoginProvider{
    return when(providerType){
        1 -> GoogleLogin()
        2 -> AppleLogin()
        else -> throw RuntimeException("There is no login type..")
    }
}

interface  LoginProvider{
    abstract fun login()
}

class GoogleLogin() : LoginProvider{
    override fun login() {
        println("Request to Google services")
    }
}

class AppleLogin() : LoginProvider{
    override fun login() {
        println("Request to Apple services")
    }
}