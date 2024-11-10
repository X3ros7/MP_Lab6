package com.example.mp_lab6

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchTodos() : List<Todo> {
    return withContext(Dispatchers.IO) {
        client.get("https://jsonplaceholder.typicode.com/todos").body()
    }
}