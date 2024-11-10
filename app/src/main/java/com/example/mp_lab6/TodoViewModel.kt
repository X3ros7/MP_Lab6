package com.example.mp_lab6

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(): ViewModel() {
    var todoList by mutableStateOf<List<Todo>>(emptyList())
    var errorMessage by mutableStateOf("")

    init {
        fetchTodoList()
    }

    private fun fetchTodoList() {
        viewModelScope.launch {
            try {
                todoList = fetchTodos()
            } catch (e: Exception) {
                errorMessage = "Failed to load data: ${e.message}"
            }
        }
    }
}