package zero.ext.int

import org.scalatest.freespec.AnyFreeSpec

class IntSpec extends AnyFreeSpec {
  "million" in {
    assert(i"1'000'000" == 1000000)
  }
}
