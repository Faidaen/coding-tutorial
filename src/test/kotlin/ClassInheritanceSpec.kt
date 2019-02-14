import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.numerics.shouldBeLessThan
import io.kotlintest.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.util.*

class ClassInheritanceSpec : FeatureSpec({
    feature("QA testing") {
        val tester = QA("Askhat")
        val features = arrayListOf("registration", "redesign", "addButton",
                "feature toggling", "payment", "addingProductInBasket", "search", "musicPlayer", "videoPlayer")
        scenario("testing features") {
            tester.releaseTesting(4, features) shouldBe false
            tester.releaseTesting(5, features) shouldBe true
        }
    }
})