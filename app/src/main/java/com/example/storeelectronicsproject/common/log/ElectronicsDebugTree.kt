package com.example.storeelectronicsproject.common.log

import timber.log.Timber

object ElectronicsDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String =
        super.createStackElementTag(element) + ":" + element.lineNumber
}