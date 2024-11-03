package ch02_가독성._15_리시버를_명시적으로_참조하라.dsl_marker

@DslMarker
annotation class HtmlDsl

@HtmlDsl
class TableDsl {
    private val rows = mutableListOf<Row>()

    fun tr(f: Row.() -> Unit) {
        val row = Row().apply(f)
        rows.add(row)
    }

    override fun toString(): String {
        return buildString {
            append("<table>\n")
            rows.forEach { append(it) }
            append("</table>")
        }
    }

    class Row {
        private val cells = mutableListOf<String>()

        fun td(f: () -> String) {
            cells.add(f())
        }

        override fun toString(): String {
            return "<tr>${cells.joinToString("") { "<td>$it</td> " }}</tr>\n"
        }
    }
}


fun table(f: TableDsl.() -> Unit) {
    val tableDsl = TableDsl().apply(f)
    println(tableDsl)
}

fun main() {
    table {
        tr {
            td { "Column 1" }
            td { "Column 2" }
            tr {
                td { "Value 1" }
                td { "Value 2" }
            }
        }
    }
}
