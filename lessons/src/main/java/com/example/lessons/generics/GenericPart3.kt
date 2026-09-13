package com.example.lessons.generics

// Producer: only returns T
interface Repository<out T> {
    suspend fun getAll(): List<T>
}

// Consumer: only accepts T
fun interface ClickListener<in T> {
    fun onClick(item: T)
}
