package zero.ext
package cast

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

class CastSpec extends AnyFreeSpec with Matchers {
  type Res = Either[String, Int]

  "cast" in {
    val x = Option(1)
    val y: Res = x.fold(Left("err").as[Res])(Right(_))
    // Without as() compiler will produce error:
    // [error]  found   : scala.util.Right[Nothing,Int]
    // [error]  required: scala.util.Left[String,Nothing]
    // [error]     val y: Either[String, Int] = x.fold(Left("err"))(i => Right(1))
    y shouldBe Right(1)

    // In this case it is easier to use cata():
    import option._
    val z: Res = x.cata(Right(_), Left("err"))
    z shouldBe Right(1)
  }
}
