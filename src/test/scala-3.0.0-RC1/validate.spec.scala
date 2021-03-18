package zero.ext

import zio.test.*, Assertion.*

object ValidateSpec extends DefaultRunnableSpec:
  def spec = suite("ValidateSpec")(
    test("of7") {
      val a: Either[String, Int] = 2.right
      assert(validate.of7 (a, a, a, a, a, a, a) {
        (a1,a2,a3,a4,a5,a6,a7) => (a1+a2+a3+a4+a5+a6+a7).toString
      })(equalTo((Right("14"))))
      && assert(validate.of7 (Right("a"), Left("a"), Left("a"), Left("a"), Left("a"), Left("a"), Left("a")) {
        (a1,a2,a3,a4,a5,a6,a7) => ???
      })(equalTo((Left(Vector("a", "a", "a", "a", "a", "a")))))
    }
  )

