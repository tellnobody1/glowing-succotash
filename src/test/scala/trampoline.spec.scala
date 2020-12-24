package zero.ext.trampoline

import zio.test._, Assertion._

object TrampolineSpec extends DefaultRunnableSpec:
  def spec = suite("TrampolineSpec")(
    test("mutual recursion") {
      def even: List[_] => Trampoline[Boolean] = {
        case Nil => Done(true)
        case _ :: xs => Suspend(() => odd(xs))
      }
      def odd: List[_] => Trampoline[Boolean] = {
        case Nil => Done(false)
        case _ :: xs => Suspend(() => even(xs))
      }
      assert(Trampoline.run(even((1 to 300000).toList)))(equalTo(true))
    }
  )

