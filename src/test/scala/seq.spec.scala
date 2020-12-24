package zero.ext

import zio.test._, Assertion._
import option._

object SeqSpec extends DefaultRunnableSpec:
  def spec = suite("SeqSpec")(
    test("list: constructor") {
      import list._
      val xs: LList[Int] = ::(1, ::(2, LNil))
      val ys: LList[Int] = 1 :: 2 :: LNil
      assert(xs)(equalTo(ys))
    }
  , test("list: head/tail") {
      import list._
      val xs: LList[Int] = 1 :: 2 :: LNil
      assert(xs.head)(equalTo(1.some))
      && assert(xs.tail)(equalTo((2 :: LNil).some))
      && assert(xs.tail.flatMap(_.tail).flatMap(_.head))(equalTo(none))
    }
  , test("list: matching") {
      import list._
      assert((1 :: 2 :: LNil) match {
        case _ :: xs => xs.head
        case _ => none
      })(equalTo(2.some))
    }
  , test("arrayview: byte: matching") {
      import arrayview._, ByteArrayView.unsafeWrap
      unsafeWrap("hello".getBytes) match {
        case 'h' +# xs => assert(xs)(equalTo(unsafeWrap("ello".getBytes)))
        case _ => ???
      }
    }
  )
