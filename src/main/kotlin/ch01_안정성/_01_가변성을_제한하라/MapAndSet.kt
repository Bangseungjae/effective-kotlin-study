package ch01_안정성._01_가변성을_제한하라

import java.util.SortedSet
import java.util.TreeSet

fun main() {
    val names: SortedSet<FullName> = TreeSet()
    val person = FullName("AAA", "BBB")
    names.add(person)
    names.add(FullName("Jordan", "Hansen"))
    names.add(FullName("David", "Blanc"))

    println(names) // [[AAA, BBB], [David, Blanc], [Jordan, Hansen]]
    println(person in names) // true

    person.firstname = "ZZZ" // 여기서의 변경이 영향을 끼친다.
    println(names) // [[ZZZ, BBB], [David, Blanc], [Jordan, Hansen]]
    // Set내부에서 해싱한 값이 변하지는 않기 때문에 false가 나온다.
    println(person in names) // false
}

class FullName(var firstname: String, val secondName: String) : Comparable<FullName>{
    override fun compareTo(other: FullName): Int {
        if (this.firstname == other.firstname) {
            return this.secondName.compareTo(other.secondName)
        }
        return this.firstname.compareTo(other.secondName)
    }

    override fun toString(): String {
        return "[$firstname, $secondName]"
    }
}
