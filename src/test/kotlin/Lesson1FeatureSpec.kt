import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.numerics.shouldBeLessThan
import io.kotlintest.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.util.*

class BasicsFeatureSpec : FeatureSpec({
    feature("functions") {
        val a = 1
        val b = 2
        scenario("sum1 and sum2 works the same") {
            sum1(a, b) shouldBe 3
            sum1(a, b) shouldBeLessThan 4
            sum1(0, 3) shouldBe 3
            sum1(-1, 1) shouldBe 0
            // Add greater less checks
            sum2(a, b) shouldBe 3
            sum2(a, b) shouldBeLessThan 4
            sum2(0, 3) shouldBe 3
            sum2(-1, 1) shouldBe 0
        }
    }

    feature("variables") {

        val readOnly = 11
        var reassignable = 3
//            scenario("val can not be reassigned") {
//                readOnly = 12
//            }

        scenario("can be reassigned") {
            reassignable = 6
            reassignable shouldBe 6
        }
    }

    feature("strings") {
        val toge = "toge"
        val ther = "ther"
        val together = "together"

        scenario("concatenation works") {
            toge + ther shouldBe together
        }

        scenario("string interpolation works") {
            "$toge$ther" shouldBe together
        }

        scenario("is not empty") {
            together.isNotBlank() shouldBe true
        }
    }

    feature("conditional expressions") {
        val max = 100
        val min = 0
        val numbers = arrayListOf<Int>(4, 5, 6, 7, -400)
        scenario("returns max") {
            maxOf(min, max) shouldBe max
        }

        scenario("min of") {
            minOf(1, 2)
            minOf(numbers) shouldBe -400
            minOf(4,5,6,7,-5,-27,56,245,-569,-4687) shouldBe -4687
            minOf(5,5,5,5,5,5) shouldBe 5
            minOf(1) shouldBe 1
            minOf() shouldBe 0
        }
    }

    // Write minOff function

    feature("when expression") {
        describe(1) shouldBe "One"
        describe("hello") shouldBe "Unknown"
        describe("Hello") shouldBe "Greeting"
        describe(10L) shouldBe "Long"
        describe(2) shouldBe "Not a string"
        // Add other checks
    }

    feature("collections") {
        val fruits = arrayListOf("Apple", "Orange", "Grapes", "Cherry", "Apple", "Orange", "Orange")

        scenario("") {
            fruits.count() shouldBe 7
            fruits shouldContain "Apple"

            count(fruits) shouldBe 7
            countInstances(fruits).get("Apple") shouldBe 2
            countInstances(fruits).get("Orange") shouldBe 3
        }
    }
})

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun minOf(a: Int, b: Int): Int {
    if (a < b) return a
    else return b
}

fun minOf(list: ArrayList<Int>): Int? {
    val min = list.min()
    return min
}

fun countInstances(list: List<String>): Map<String, Int> {
    val map = mutableMapOf<String, Int>()
    for (fruit in list) {
        val oldValue = map[fruit]
        if (oldValue != null) {
            map[fruit] = oldValue + 1
        }
        else {
            map[fruit] = 1
        }
    }
    return map
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun count(list: ArrayList<String>): Int {
    var counter = 0
    for (i in list) {
        counter += 1
    }
    return counter
}

fun minOf(vararg list: Int): Int {
    try {
        var min = list[0]
        for (number in list){
            if (number < min) {
                min = number
            }
        }
        return min
    } catch (e : ArrayIndexOutOfBoundsException) {
        println("You haven't entered any value")
        print("Let's guess your minimum is 0" + ", then")
        return 0
    }
}