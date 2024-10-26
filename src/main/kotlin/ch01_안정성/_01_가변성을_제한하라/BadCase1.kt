package ch01_안정성._01_가변성을_제한하라

fun main() {
    val list = listOf(1, 2, 3)

    // 이렇게 하지 마세요!
//    if (list is MutableList) {
//        list.add(4) // Exception in thread "main" java.lang.UnsupportedOperationException
//    }

    // use this
    val mutableList = list.toMutableList()
    mutableList.add(4)
}
