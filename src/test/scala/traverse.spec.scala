package zero.ext

import zio.test._, Assertion._
import option._

object TraverseSpec extends DefaultRunnableSpec:
  def spec = suite("TraverseSpec")(
    test("map") {
         assert(Map.empty[Unit, Either[Unit, Unit]].sequence)(equalTo(Map.empty.right))
      && assert(Map("1" -> "2".right, "2" -> "3".right).sequence)(equalTo(Map("1" -> "2", "2" -> "3").right))
      && assert(Map("1" -> "2".right, "2" ->  3 .left ).sequence)(equalTo(3.left))
    }
  , test("seq") {
         assert(LazyList(1.right,"2".left ,3.right).sequence )(equalTo("2".left))
      && assert(LazyList(1.right, 2 .right,3.right).sequence )(equalTo(Seq(1, 2, 3).right))
      && assert(LazyList(1.right,"2".left ,3.right).sequence_)(equalTo("2".left))
      && assert(LazyList(1.right, 2 .right,3.right).sequence_)(equalTo(().right))
      && assert(List(1.some,None,3.some).sequence)(equalTo(None))
      && assert(List(1.some,2.some,3.some).sequence)(equalTo(Some(Seq(1, 2, 3))))
    }
  )
