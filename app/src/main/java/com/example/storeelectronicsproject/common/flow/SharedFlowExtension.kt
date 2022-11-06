package com.example.storeelectronicsproject.common.flow

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import com.example.storeelectronicsproject.common.navigation.NavCommand

fun createSharedFlow() =
    MutableSharedFlow<NavCommand>(0, 1, BufferOverflow.DROP_LATEST)