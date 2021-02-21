package com.example.measurelayoutdrawrepeat

interface TallyCounter {

    fun reset()

    fun increment()

    fun getCount(): Int

    fun setCount(count: Int)

}