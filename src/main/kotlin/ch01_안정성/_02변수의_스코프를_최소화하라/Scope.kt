package ch01_안정성

const val a = 1
fun fizz() {
    val b = 2
    print(a + b)
}

val buzz = {
    val c = 3
    print(a + c)
}

fun main() {
    fizz()
    println()
    buzz.invoke()
}
