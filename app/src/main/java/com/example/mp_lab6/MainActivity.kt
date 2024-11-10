package com.example.mp_lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mp_lab6.ui.theme.MP_Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MP_Lab6Theme {
                TodoListScreen()
            }
        }
    }
}

@Composable
fun TodoListScreen(todoViewModel: TodoViewModel = hiltViewModel()) {
    val users = todoViewModel.todoList
    val error = todoViewModel.errorMessage

    LazyColumn {
        if (error.isNotEmpty()) {
            item { Text(text = error) }
        } else {
            items(users) { todo ->
                TodoItem(todo)
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    Text(text = todo.title)
    Text(text = todo.completed.toString())
}
