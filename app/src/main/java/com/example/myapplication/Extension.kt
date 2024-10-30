package com.example.myapplication

fun List<Any?>.findFirstInt(): Int? {
    return this.firstOrNull { it is Int } as? Int
}