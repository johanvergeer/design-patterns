package design_patterns.composite.html

fun main() {
    val body = Body()

    val div = Div()
    val p = P()
    p.innerText = "Hello, World!"

    body.add(div)
    div.add(p)

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
