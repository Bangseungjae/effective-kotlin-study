package ch01_안정성._01_가변성을_제한하라

import kotlin.properties.Delegates

fun main() {
    var names by Delegates.observable(listOf<String>()) {_ , old, new -> println("Names changed from $old to $new")}

    names += "Fabio"

    names += "Bill"
}
