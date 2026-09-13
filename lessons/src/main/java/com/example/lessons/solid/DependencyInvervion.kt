package com.example.lessons.solid

fun main() {
    val userList = UserListManager(
        userRepository = ApiUserRepositoryImpl()
    )

    val chatList = ChatManager(
        userRepository = LocalUserRepositoryImpl()
    )
}

// Bad: ViewModel is welded to Retrofit
class UserListManager(
    private val userRepository : UserRepo
) {
    fun getMyContact(): List<User> {
        return userRepository.getMyContact()
    }
}

class ChatManager(
    private val userRepository : UserRepo
) {
    fun getMyContact(): List<User> {
        return userRepository.getMyContact()
    }
}


interface UserRepo {
    fun getMyContact(): List<User>
}

class ApiUserRepositoryImpl() : UserRepo {
    override fun getMyContact(): List<User> {
        println("Api call")
        return emptyList()
    }
}

class LocalUserRepositoryImpl() : UserRepo {
    override fun getMyContact(): List<User> {
        println("Local call")
        return emptyList()
    }
}