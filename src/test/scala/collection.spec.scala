package zero.ext

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

import option._

class CollectionSpec extends AnyFreeSpec with Matchers {
  "list" - {
    import list._
    "constructor" in {
      val xs: LList[Int] = ::(1, ::(2, LNil))
      val ys: LList[Int] = 1 :: 2 :: LNil
      xs shouldBe ys
    }
    "head/tail" in {
      val xs: LList[Int] = 1 :: 2 :: LNil
      xs.head shouldBe 1.some
      xs.tail shouldBe (2 :: LNil).some
      xs.tail.flatMap(_.tail).flatMap(_.head) shouldBe none
    }
    "matching" in {
      ((1 :: 2 :: LNil) match {
        case _ :: xs => xs.head
        case _ => none
      }) shouldBe 2.some
    }
  }
  "arrayview" - {
    import arrayview._, ByteArrayView.unsafeWrap
    "byte" - {
      "matching" in {
        unsafeWrap("hello".getBytes) match {
          case 'h' +# xs => xs shouldBe unsafeWrap("ello".getBytes)
        }
      }
    }
  }
}

