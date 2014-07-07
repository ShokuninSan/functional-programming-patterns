import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.Matchers._
import dsl._
import dsl.Implicits._

class DslSpec extends FlatSpec with Matchers {

  "A simple command" should "return a result" in {
    val result = "ls -l".run
    result shouldBe a [CommandResult]
    result.status shouldEqual(0)
  }
}
