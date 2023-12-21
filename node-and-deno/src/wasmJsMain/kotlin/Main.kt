import kotlin.js.*
import org.w3c.fetch.*

external fun fetch(input: String, init: JsAny = definedExternally): Promise<Response>

fun main() {
    fetch("https://httpbin.org/anything").then {
        if (it.ok) {
            it.text().then {
                println(it)
                null
            }
        }
        null
    }
}
