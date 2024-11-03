package ch02_가독성._16_프로퍼티는_동작이_아니라_상태를_나타내야한다

import java.util.Date

/**
 * 자바 표준 라이브러리 Date를 활용해 객체에 날짜를 저장해서 많이 활용하는 상황을 가정해 보겠습니다.
 * 그런데 프로젝트를 진행하는 중에 직렬화 문제 등으로 객체를 더 이상 이러한 타입으로 저장할 수 없게 되었는데, 이미 프로젝트 전체에서
 * 이 프로퍼티를 많이 참조하고 있다면 어떻게 해야 할까요?
 * 코틀린은 데이터를 milllis라는 별도의 프로퍼티로 옮기고, 이를 활용해서 date프로퍼티에 데이터를 저장하지 않고,
 * 랩(wrap)/언랩(unwrap)하도록 코드를 변경하기만 하면 됩니다.
 */

var millis: Long = 12312445L

var date: Date
    get() = Date(millis)
    set(value) {
        millis = value.time
    }

/**
 * 프로퍼티는 필드가 필요 없습니다. 오히려 프로퍼티라는 개념은 접근자(val의 경우 게터, var의 경우 게터와 세터)를 나타냅니다.
 * 따라서 코틀린은 인터페이스에도 프로퍼티를 정의할 수 있습니다.
 */
interface Person {
    val name: String
}
/**
 * 이렇게 작성하면, 게터를 가질 거라는 것을 나타냅니다. 따라서 다음과 같이 오버라이드할 수 있습니다.
 */
open class Supercomputer {
    open val theAnswer: Long = 42
}

class AppleComputer: Supercomputer() {
    override val theAnswer: Long = 1_800_275_2273
}

/**
 * 마찬가지 이유로 프로퍼티를 위임할 수도 있습니다.
 * val db: Datebase by lazy { connectToDb() }
 */


