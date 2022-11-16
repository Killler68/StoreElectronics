package com.example.storeelectronicsproject.common.state

sealed class State {
    object Loading : State()
    object Loaded : State()
    object Error : State()
}