package zero.ext
package validation

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

import either._

class ValidateSpec extends AnyFreeSpec with Matchers {
  "of7" in {
    val a: Either[String, Int] = 2.right
    validate.of7 (a, a, a, a, a, a, a) {
      (a1,a2,a3,a4,a5,a6,a7) => (a1+a2+a3+a4+a5+a6+a7).toString
    } shouldBe (Right("14"))
    validate.of7 (Right("a"), Left("a"), Left("a"), Left("a"), Left("a"), Left("a"), Left("a")) {
      (a1,a2,a3,a4,a5,a6,a7) => ???
    } shouldBe (Left(Vector("a", "a", "a", "a", "a", "a")))
  }
}

