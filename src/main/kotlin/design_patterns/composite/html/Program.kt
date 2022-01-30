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

class Body : HtmlElement() {
    override val tagName: String = "body"
}

class Div : HtmlElement() {
    override val tagName: String = "div"
}

class P : HtmlElement() {
    override val tagName: String = "p"
}

fun main() {
    val body = Body()

    val div = Div()
    val p = P()
    p.innerText = "Hello, World!"

    val p2 = P()
    p2.innerText = "Hello, new World!"

    body.add(div)
    div.add(p)
    div.add(p2)

    printHtml(body)
}

fun printHtml(html: HtmlElement, indent: Int = 0) {
    addIndent(indent)
    println(html.openingTag)

    if (html.innerText.isNotBlank()) {
        addIndent(indent + 2)
        println(html.innerText)
    }

    html.children.forEach { child -> printHtml(child, indent + 2) }

    addIndent(indent)
    println(html.closingTag)
}

private fun addIndent(indent: Int) {
    print("".padStart(indent))
}
