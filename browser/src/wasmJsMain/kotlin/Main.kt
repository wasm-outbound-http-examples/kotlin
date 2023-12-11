import kotlinx.browser.window

fun main() {
    window.fetch("https://httpbin.org/anything").then {
        if (it.ok) {
            it.text().then {
                println(it)
                null
            }
        }
        null
    }
}
