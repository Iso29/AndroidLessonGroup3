package com.example.lessons.patterns

class MarketManagerUtil private constructor(){
    companion object {
        private var instance : MarketManagerUtil? = null
        fun getInstance() : MarketManagerUtil {
            if(instance == null){
                instance = MarketManagerUtil()
            }
            return instance!!
        }
    }
}


object MarketManagerUtilV2{
    var test : String = ""
}

fun main() {
    val managerUtil1 = MarketManagerUtilV2

    val managerUtil2 = MarketManagerUtilV2

    managerUtil1.test = "Iso"

    println(managerUtil1.test)
    println(managerUtil2.test)
}