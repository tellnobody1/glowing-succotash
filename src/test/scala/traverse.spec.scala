package zero.ext
package traverse

import either._, option._

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

class TraverseSpec extends AnyFreeSpec with Matchers {
  "traverse" in {
    Map.empty.traverse(identity) shouldBe Map.empty.right
    Map("1" -> "2".right, "2" -> "3".right).traverse(identity) shouldBe Map("1" -> "2", "2" -> "3").right
    Map("1" -> "2".right, "2" ->  3 .left ).traverse(identity) shouldBe 3.left
  }

  "sequence" in {
    LazyList(1.right,"2".left ,3.right).sequence  shouldBe "2".left
    LazyList(1.right, 2 .right,3.right).sequence  shouldBe Seq(1, 2, 3).right
    LazyList(1.right,"2".left ,3.right).sequence_ shouldBe "2".left
    LazyList(1.right, 2 .right,3.right).sequence_ shouldBe ().right
    List(1.some,None,3.some).sequence shouldBe None
    List(1.some,2.some,3.some).sequence shouldBe Some(Seq(1, 2, 3))
  }
}

