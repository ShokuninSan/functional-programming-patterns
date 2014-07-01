import org.scalatest.{FlatSpec, Matchers}
import functionbuilder.MapKeySelector._

class FunctionBuilderSpec extends FlatSpec with Matchers {

  "A selector" should "not accept an empty parameter list" in {
    intercept[IllegalArgumentException] {
      selector()
    }
  }

  "MapKeySelector" should "return when value is no Map" in {
    val firstName = selector('name, 'first)
    val person = Map('name -> 4711)
    firstName(person) should equal(None)
  }

  "MapKeySelector firstName" should "return some value" in {
    val firstName = selector('name, 'first)
    val person = Map('name -> Map('first -> "shokunin"))
    firstName(person).get should equal("shokunin")
  }

  "MapKeySelector firstName" should "return none" in {
    val firstName = selector('name, 'first)
    val person = Map('name -> Map('nick -> "shokunin"))
    firstName(person) should equal(None)
  }

  "MapKeySelector firstName" should "return none too" in {
    val firstName = selector('name, 'first)
    val person = Map('nick -> "shokunin")
    firstName(person) should equal(None)
  }

}
