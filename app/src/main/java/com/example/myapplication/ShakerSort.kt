package com.example.myapplication

fun shakerSort(input: List<Int?>?): List<Int?> {
    if (input == null) return emptyList()

    val list = input.toMutableList()
    val n = list.size
    var swapped: Boolean
    var start = 0
    var end = n - 1

    do {
        swapped = false

        for (i in start until end) {
            if (compareAndSwap(list, i, i + 1)) {
                swapped = true
            }
        }
        end--

        if (!swapped) break

        swapped = false

        for (i in end downTo start + 1) {
            if (compareAndSwap(list, i - 1, i)) {
                swapped = true
            }
        }
        start++
    } while (swapped)

    return list.filterNotNull() + list.filter { it == null }
}

private fun compareAndSwap(list: MutableList<Int?>, index1: Int, index2: Int): Boolean {
    val first = list[index1]
    val second = list[index2]

    return when {
        first != null && second != null && first > second -> {
            list[index1] = second.also { list[index2] = first }
            true
        }
        first == null && second != null -> {
            list[index1] = second.also { list[index2] = null }
            true
        }
        else -> false
    }
}