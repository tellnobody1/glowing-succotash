package zero.ext
package nat

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

class NatSpec extends AnyFreeSpec with Matchers {
  "arithmetic operations" in {
    import Nat.{Z, S}
    Z.increment shouldBe (Z + S)
    (Z - S) shouldBe Z
    (S.increment.increment * S.increment) shouldBe Nat.of(6)
  }
}
