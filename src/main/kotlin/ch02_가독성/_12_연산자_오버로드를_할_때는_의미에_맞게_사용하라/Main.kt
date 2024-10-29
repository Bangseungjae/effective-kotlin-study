package ch02_가독성._12_연산자_오버로드를_할_때는_의미에_맞게_사용하라

//operator fun Int.times(operation: () -> Unit) {
//    repeat(this) { operation() }
//}

// 의미가 명확하지 않다면, infix를 활용한 확장 함수를 사용하는 것이 좋습니다. 일반적인 이항 연산자 형태처럼 사용할 수 있습니다.
infix fun Int.timesRepeated(operation: () -> Unit): () -> Unit = {
    repeat(this) { operation() }
}

val tripleHello = 3 timesRepeated { print("Hello") } // HelloHelloHello

fun main() {
//    3 * { print("Hello") } // HelloHelloHello
    tripleHello()
}
