package ch01_안정성._08적절하게null을_처리하라

/*
null은 명확하게 의미를 갖는것이 좋다. ex) Interable<T>.firstOrNull(() -> Boolean)

이는 nullable 값을 처리해야 하기 때문인데, 이를 처리하는 사람은 API사용자(API 요소를 사용하는 개발자)입니다.
val printer: Printer? = getPrinter()
printer.print() // 컴파일 오류

printer?.print() // 안전 호출
if (printer != null) printer.print() // 스마트 캐스팅
printer!!.print() // not-null assertion

기본적으로 nullable 타입은 세 가지 방법으로 처리합니다.
- ?., 스마트 캐스팅, Elvis 연산자 등을 활용해서 안전하게 처리한다.
- 오류를 throw한다.
- 함수 또는 프로퍼티를 리팩터링해서 nullable 타입이 나오지 않게 바꾼다.
 */

/*
- 어떤 값이 클래스 생성 이후에 확실하게 설정된다는 보장이 있다면, lateinit 프로퍼티와 notNull 델리게이트를 사용하세요.
 */
