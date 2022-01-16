package design_patterns.composite.html

abstract class HtmlElement {
    private val _children = mutableListOf<HtmlElement>()

    val children
        get() = this._children.toList()

    var innerText = ""

    abstract val tagName: String

    val openingTag: String
        get() = "<${this.tagName}>"

    val closingTag: String
        get() = "</${this.tagName}>"

    fun add(child: HtmlElement) {
        this._children.add(child)
    }
}
