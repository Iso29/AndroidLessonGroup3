package com.example.lessons.oop.abstraction

private class Person(
    override var age: Int
) : Live , Runner{
    override fun eat() {
        println("Person is eating..")
    }

    override fun run() {
        super.run()
        println("Person is running...")
    }
}

private interface Live {
    var age : Int
    fun eat()
}

private interface Runner {
    fun run() {
        println("Runner is running...")
    }
}

data class Message(
    val from : String,
    val to : String,
    val content : String
)

interface MessageManager{
    fun getMyChat() : List<Message>
}

class BubbleManager() : MessageManager {
    override fun getMyChat(): List<Message> {
        TODO("Not yet implemented")
    }
}

class LocalMessageManager() : MessageManager{
    override fun getMyChat(): List<Message> {
        println("Get messages from local")
        return emptyList()
    }
}

class RemoteMessageManager() : MessageManager{
    override fun getMyChat(): List<Message> {
        println("Get messages from remote")
        return emptyList()
    }
}

fun getMessageManager(isConnected : Boolean) : MessageManager {
    return if(isConnected){
        RemoteMessageManager()
    }else{
        LocalMessageManager()
    }
}

fun main() {
    val isConnected = false
    val manager = getMessageManager(isConnected)

    val messages = manager.getMyChat()
}

