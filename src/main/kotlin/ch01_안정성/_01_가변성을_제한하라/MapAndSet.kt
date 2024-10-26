package ch01_안정성

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

    person.firstname = "ZZZ"
    println(names) // [[ZZZ, BBB], [David, Blanc], [Jordan, Hansen]]
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
