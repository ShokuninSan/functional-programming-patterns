import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.{GeneratorDrivenPropertyChecks, Checkers}
import recursion.Trampoline._
import recursion.PhasesOfMatter._

import org.scalacheck.Gen

class MutualRecursionSpec extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {

  "isEven" should "return true for small values" in {
    isEven(10) should be === true
    isEven(100) should be === true
  }

  "isEvenTrampoline" should "return true for all even numbers within 0..10000" in {
    val evenNumbers = Gen.choose(0L, 10000L)
    forAll(evenNumbers) { (l: Long) =>
      whenever (l % 2 == 0) {
        isEvenTrampoline(l).result should be === true
      }
    }
  }

  "Trampolined phases of matter state machine" should "return true for valid transitions" in {
    val transitions = List(Deionization, Condensation, Freezing, Sublimation, Ionization)
    plasma(transitions).result should be === true
  }

  "Trampolined phases of matter state machine" should "return false for invalid transitions" in {
    val transitions = List(Deionization, Ionization)
    vapor(transitions).result should be === false
  }

}
