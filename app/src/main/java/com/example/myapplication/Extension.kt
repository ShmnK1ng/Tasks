package com.example.myapplication

fun List<Any?>.findFirstInt(): Int? {
    for (element in this) {
        if (element is Int) {
            return element
        }
    }
    return null
}