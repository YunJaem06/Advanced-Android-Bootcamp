package com.anushka.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers() : List<User>{
        delay(8000)
        val users : List<User> = listOf(
            User(1,"아메리카노"),
            User(2,"라떼"),
            User(3,"카라멜마끼야또"),
            User(4,"민트초코")

        )
        return users

    }
}