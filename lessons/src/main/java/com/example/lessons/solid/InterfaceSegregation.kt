package com.example.lessons.solid


class MyButton : Item(), OnItemClick {
    override fun onClick(item: Item) {
        TODO("Not yet implemented")
    }

    override fun onLongClick(item: Item) {
        TODO("Not yet implemented")
    }
}

class ListView : Item() , OnItemClick , OnItemSwipe {
    override fun onClick(item: Item) {
        TODO("Not yet implemented")
    }

    override fun onLongClick(item: Item) {
        TODO("Not yet implemented")
    }

    override fun onSwipe(item: Item) {
        TODO("Not yet implemented")
    }
}

class Slider : Item() , OnItemSwipe {
    override fun onSwipe(item: Item) {
        TODO("Not yet implemented")
    }
}

abstract class Item {
    var weight: Double = 0.0
    var height: Double = 0.0
    var isActive: Boolean = false
}

interface ItemListener {
    fun onClick(item: Item)
    fun onLongClick(item: Item)
    fun onSwipe(item: Item)
    fun onDragStart(item: Item)
}

//// Better: small, focused interfaces
interface OnItemClick {
    fun onClick(item: Item)
    fun onLongClick(item: Item)
}

interface OnItemSwipe {
    fun onSwipe(item: Item)
}
//
//class MyAdapter(
//    private val onClick: OnItemClick,
//    private val onSwipe: OnItemSwipe? = null
//)

fun main() {
    val button = MyButton()

}