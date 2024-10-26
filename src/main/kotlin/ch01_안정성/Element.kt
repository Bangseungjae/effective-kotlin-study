package ch01_안정성

import java.util.UUID

/*
var는 게터와 세터를 모두 제공하지만, val는 변경이 불가능하므로 게터만 제공합니다. 그래서 val var로 오버라이드할 수 있습니다.
 */

interface Element {
    val active: Boolean
}

class ActualElement : Element {
    override var active: Boolean = false
}


class Blog(
    val blogId: UUID,
    blogInformation: String,
) {
    var blogInformation: String = blogInformation
        private set
}
