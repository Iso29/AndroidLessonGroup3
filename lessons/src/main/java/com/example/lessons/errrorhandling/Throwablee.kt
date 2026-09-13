package com.example.lessons.errrorhandling

class User(
    val username: String,
    val password: String
)

fun main() {
    val users : List<User> = emptyList()
        listOf(
        User("iso", "1234"),
        User("iso1", "1234"),
        User("iso2", "1234")
    )

    println("Enter username :")
    val userName = readlnOrNull()?:""

    println("Enter password :")
    val password = readlnOrNull()?:""


    try {
        userValidator(users,User(userName,password))
    }catch (e : InvalidCredentials) {
        println("${e.message}")
    }catch (e: MatchException){

    }catch (e: Throwable) {
        e.printStackTrace()
    }finally {
        
    }
}

class InvalidCredentials(
    message: String
) : Throwable(message) {

}

fun userValidator(
    userList : List<User>,
    user: User?
) {
    user?: throw InvalidCredentials("Invalid credentials")

    if(user.username.isBlank()) {
        throw InvalidCredentials("Username is blank")
    }

    if(user.password.isBlank()) {
        throw InvalidCredentials("Password is blank")
    }

    userList.first()

    for (us in userList) {
        if(us.password.equals(user.password) && us.username.equals(user.username)) {
            return
        }
    }
    throw InvalidCredentials("Passord or username is invalid")
}