package recursion

import scala.util.control.TailCalls._
import scala.util.control.TailCalls.TailRec

object Trampoline {

  // These mutual recursive calls lead to StackOverFlowError for large Numbers
  def isEven(n: Long): Boolean = if (n == 0) true else isOdd(n - 1)
  def isOdd(n: Long): Boolean = if (n == 0) false else isEven(n - 1)

  // Using Scala's support for Trampolining works just fine
  def isEvenTrampoline(n: Long): TailRec[Boolean] = if (n == 0) done(true) else tailcall(isOddTrampoline(n - 1))
  def isOddTrampoline(n: Long): TailRec[Boolean] = if (n == 0) done(false) else tailcall(isEvenTrampoline(n - 1))

}
