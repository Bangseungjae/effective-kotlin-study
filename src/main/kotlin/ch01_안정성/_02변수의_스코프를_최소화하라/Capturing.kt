package ch01_안정성._02변수의_스코프를_최소화하라

/*
에라토스 테네스의 체(소수를 구하는 알고리즘)
 */
fun main() {
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while (numbers.isNotEmpty()) {
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0 }
    }
    println(primes)
}

