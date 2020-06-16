package zero.ext.trampoline

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

class TrampolineSpec extends AnyFreeSpec with Matchers {
  "mutual recursion" in {
    def even: List[_] => Trampoline[Boolean] = {
      case Nil => Done(true)
      case _ :: xs => Suspend(() => odd(xs))
    }
    def odd: List[_] => Trampoline[Boolean] = {
      case Nil => Done(false)
      case _ :: xs => Suspend(() => even(xs))
    }
    even((1 to 300000).toList).run shouldBe true 
  }
}

