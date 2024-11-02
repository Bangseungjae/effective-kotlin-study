package ch02_가독성._15_리시버를_명시적으로_참조하라

/**
 * 확장 리시버(왁장 메서드의 this)를 명시적으로 ㅊ마조할 수 잇게 할 수 있습니다.
 *
 * 비교를 위해 일단 리시버를 명시적으로 표시하지 않은 퀵소트 구현을 살펴봅시다.
 */
fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
    if (size < 2) return this
    val pivot = first()
    val (smaller, bigger) = drop(1)
        .partition { it < pivot }
    return smaller.quickSort() + pivot + bigger.quickSort()
}

/**
 * 명시적으로 표시
 */
fun <T : Comparable<T>> List<T>.quickSortV2(): List<T> {
    if (this.size < 2) return this
    val pivot = this.first()
    val (smaller, bigger) = drop(1)
        .partition { it < pivot }
    return smaller.quickSortV2() + pivot + bigger.quickSortV2()
}

// 두 함수의 사용에 차이는 없다.
fun main() {
    val quickSort1 = listOf(3, 2, 5, 1, 6).quickSort()
    println(quickSort1)
    val quickSortV2 = listOf("C", "D", "A", "B").quickSortV2()
    println(quickSortV2)
}
