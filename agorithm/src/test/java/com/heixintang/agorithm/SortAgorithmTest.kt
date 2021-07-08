package com.heixintang.agorithm

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SortAgorithmTest {
    @Test
    fun sort() {
        val list = mutableListOf(1, 3, 8, 9, 11, 6, 1234, 435, 222, 43, 2, 1)
            .apply {
                shuffle()
            }
        println(quickSort(list))
    }

    private fun quickSort(list: List<Int>): List<Int> {
        return if (list.size <= 1) list
        else {
            list.takeLast(list.lastIndex)
                .partition {
                    it < list[0]
                }
                .run {
                    quickSort(first) + list[0] + quickSort(second)
                }
        }
    }
}