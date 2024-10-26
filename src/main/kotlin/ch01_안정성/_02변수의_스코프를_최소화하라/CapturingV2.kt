package ch01_안정성._02변수의_스코프를_최소화하라

/*
에라토스 테네스의 체(소수를 구하는 알고리즘)
 */
val primes: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    while (true) {
        val prime = numbers.first()
        yield(prime)
        numbers = numbers.drop(1)
            .filter { it % prime != 0 }
    }
}

fun main() {
    print(primes.take(10).toList())
}

