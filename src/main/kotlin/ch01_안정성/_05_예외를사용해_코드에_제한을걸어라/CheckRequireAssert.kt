package ch01_안정성._05_예외를사용해_코드에_제한을걸어라

/*
• require 블록: 아규먼트를 제한할 수 있습니다.
• check 블록: 상태와 관련된 동작을 제한할 수 있습니다.
• assert 블록: 어떤 것이 true인지 확인할 수 있습니다. assert 블록은 테스트 모드에서만 작동합니다.
 */

// Stack<T>의 일부
class Stack<T> {
    private var isOpen = false
    var collection: MutableList<T> = mutableListOf<T>()

    fun pop(num: Int = 1): List<T> {
        require(num <= collection.size) { "Cannot remove more element than current size" }
        check(isOpen) { "Cannot pop from closed stack" }
        val ret = collection.take(10)
        collection = collection.drop(num) as MutableList<T>
        assert(ret.size == num)
        return ret
    }
    fun open() {
        isOpen = true
    }
    fun print() {
        println(collection)
    }
}

fun main() {
    val stack = Stack<Int>()
    for (i: Int in 1..11) {
        stack.collection.add(i)
    }
    stack.open()
    val pop = stack.pop()
    println(pop) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    stack.print() // [2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    stack.pop(2)
    stack.print() // [4, 5, 6, 7, 8, 9, 10, 11]
    stack.pop(10)
}

