프로퍼티 대신 함수를 사용하는 것이 좋은 경우를 정리해 보면 다음과 같습니다.

- 연산 비용이 높거나, 복잡도가 O(1)보다 큰 경우
- 비즈니스 로직(애플리케이션의 동작)을 포함하는 경우
- 결정적이지 않은 경우: 같은 동작을 연속적으로 두 번 했는데 다른 값이 나올 수 있다면, 함수를 사용하는 것이 좋습니다.
- 변환의 경우: 변환은 관습적으로 Int.toDouble()과 같은 변환 함수로 이루어집니다.
- 게터에서 프로퍼티의 상태 변경이 일어나야 하는 경우
