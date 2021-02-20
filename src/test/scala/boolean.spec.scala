package zero.ext

import zio.test._, Assertion._

object BooleanSpec extends DefaultRunnableSpec:
  def spec = suite("BooleanSpec")(
    test("boolean") {
      assert(true.fold("true", "ignored"))(equalTo("true"))
      && assert(false.fold("ignored", "false"))(equalTo("false"))
    }
  )

