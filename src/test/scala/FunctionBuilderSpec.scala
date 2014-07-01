import org.scalatest.{FlatSpec, Matchers}
import functionbuilder.MapKeySelector._

class FunctionBuilderSpec extends FlatSpec with Matchers {

  "A selector" should "not accept an empty parameter list" in {
    intercept[IllegalArgumentException] {
      selector()
    }
  }

  "KeyMapSelector firstName" should "return some value" in {
    val firstName = selector('name, 'first)
    val person = Map('name -> Map('first -> "shokunin"))
    firstName(person).get should equal("shokunin")
  }

  "KeyMapSelector firstName" should "return none" in {
    val firstName = selector('name, 'first)
    val person = Map('name -> Map('nick -> "shokunin"))
    firstName(person) should equal(None)
  }

  "KeyMapSelector firstName" should "return none too" in {
    val firstName = selector('name, 'first)
    val person = Map('nick -> "shokunin")
    firstName(person) should equal(None)
  }

}
