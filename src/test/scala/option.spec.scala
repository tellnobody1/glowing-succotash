package zero.ext
package option

import zio.test._, Assertion._

object OptionSpec extends DefaultRunnableSpec:
  def spec = suite("OptionSpec")(
    test("some") {
      val checkType: Some[Int] = 0.some
      assert(0.some)(equalTo(Some(0)))
    }
  , test("none") {
      val checkType: None.type = none
      assert(none)(equalTo(None))
    }
  , test("cata") {
      val z = Option(1).cata(Right(_), Left(()))
      assert(z)(equalTo(Right(1)))
    }
  )
