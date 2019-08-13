package zd.gs.z

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

class validateSpec extends AnyFreeSpec with Matchers {
  "validate7" in {
    import zd.gs.z.validate.validate7
    val a: Either[String, Int] = 2.right
    validate7 (a) (a) (a) (a) (a) (a) (a) {
      (a1,a2,a3,a4,a5,a6,a7) => (a1+a2+a3+a4+a5+a6+a7).toString
    } shouldBe (Right("14"))
    validate7 (Right("a")) (Left("a")) (Left("a")) (Left("a")) (Left("a")) (Left("a")) (Left("a")) {
      (a1,a2,a3,a4,a5,a6,a7) => ???
    } shouldBe (Left(Vector("a", "a", "a", "a", "a", "a")))
  }
}

