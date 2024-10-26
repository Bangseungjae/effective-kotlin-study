package com.sample.toy.app.ch01

interface Element {
    val active: Boolean
}

class ActualElement : Element {
    override var active: Boolean = false
}
