package ch02_가독성._15_리시버를_명시적으로_참조하라

/**
 * 문제는 apply 함수 내부에서 this 타입이 Node?라서, 이를 직접 사용할 수 없다는 것입니다. 이를 사용하려면 언팩(unpack)하고 호출해야 합니다.
 * 이렇게 하면 일반적으로 생각하는 답이 나옵니다.
 */
//class NodeV2(val name: String) {
//    fun makeChild(childName: String) = create("$name.childName")
//        .apply { print("Created ${this.name}") } // 컴파일 오류
//
//    fun create(name: String): Node? = Node(name)
//}

class NodeV3(val name: String) {
    fun makeChild(childName: String) = create("$name.$childName") // 컴파일 오류
        .apply { print("Created ${this?.name}") }

    fun create(name: String): Node? = Node(name)
}

/**
 * 사실 위는 apply의 잘못된 사용 예입니다. 만약 also 함수와 파라미터 name을 사용했다면, 이런 문제 자체가 일어나지 않습니다.
 * 일반적으로 also 또는 let을 사용하는 것이 nullable 값을 처리할 때 훨씬 좋은 선택지입니다.
 */
class NodeV4(val name: String) {
    fun makeChild(childName: String) = create("$name.$childName")
        .also { print("Created ${it?.name}") }

    fun create(name: String): Node? = Node(name)
}

/**
 * 리시버가 명확하지 않다면, 명시적으로 리시버를 적어서 이를 명확하게 해주세요.
 * 레이블 없이 리시버를 사용하면, 가장 가까운 리시버를 의미합니다. 외부에 있는 리시버를 사용하려면, 레이블을 사용해야 합니다.
 * 둘 모두를 사용하는 예를 살펴봅시다.
 */
class NodeV5(val name: String) {

    fun makeChild(childName: String) = create("$name.$childName").apply {
        print("Created ${this?.name} in " + " ${this@NodeV5.name}")
    }

    fun create(name: String): Node? = Node(name)
}

fun main() {
    val node = NodeV3("parent")
    node.makeChild("child") // 출력 -> Created parent.child
    println()
    val node2 = NodeV4("parent")
    node2.makeChild("child") // 출력 -> Created parent.child

    println()
    val nodeV5 = NodeV5("parent")
    nodeV5.makeChild("child") // Created parent.child in  parent
}
