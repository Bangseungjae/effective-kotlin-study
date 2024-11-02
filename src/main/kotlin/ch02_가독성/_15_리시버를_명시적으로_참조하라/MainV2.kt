package ch02_가독성._15_리시버를_명시적으로_참조하라

/**
 * 여러 개의 리시버
 * 스코프 내부에 둘 이상의 리시버가 있는경우, 리시버를 명시적으로 나타내면 좋습니다.
 * apply, with, run 함수를 사용할 때가 대표적인 예입니다.
 */
class Node(val name: String) {
    fun makeChild(childName: String) = create("$name.$childName")
        .apply { print("Created ${name}") }

    fun create(name: String): Node? = Node(name)
}

fun main() {
    val node = Node("parent")
    node.makeChild("child")
    // 예상 -> Created parent.child, 실제 -> Created parent
}
