import org.scalatest.{FlatSpec, Matchers}
import functionbuilder.MapKeySelector._

class FunctionBuilderSpec extends FlatSpec with Matchers {

  "firstName selector" should "return a value" in {
    val firstName = selector('name, 'first)
    val person = Map('name -> Map('first -> "shokunin"))
    firstName(person) should equal("shokunin")
  }

}
