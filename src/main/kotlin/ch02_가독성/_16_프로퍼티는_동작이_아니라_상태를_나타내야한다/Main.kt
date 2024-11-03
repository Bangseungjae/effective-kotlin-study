package ch02_가독성._16_프로퍼티는_동작이_아니라_상태를_나타내야한다

/**
 * 코틀린의 프로퍼티는 자바의 필드와 비슷해 보이지만 사실 서로 완전히 다른 개념이다.
 * 둘 다 데이터를 저장한다는 점은 같습니다. 하지만 프로퍼티에는 더 많은 기능이 있습니다.
 * 일단 기본적으로 프로퍼티는 사용자 정의 세터와 게터를 가질 수 있습니다.
 */
var name: String? = null // val을 사용하면 field가 만들어지지 않는다.
    get() = field?.toUpperCase()
    set(value) {
        if (!value.isNullOrBlank()) {
            field = value
        }
    }
/**
 * var을 사용해서 만든 읽고 쓸 수 있는 프로퍼티는 게터와 세터를 통해 정의할 수 있습니다.
 * 이러한 프로퍼티를 파생 프로퍼티(derived property)라고 부르며, 자주 사용됩니다.
 */

fun main() {
    name = "sdf"
    println(name) // SDF
    name = ""
    println(name) // SDF
}
