package zero.ext

package zero.ext
package cast

import sys.process._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

class GitSpec extends AnyFreeSpec with Matchers {
  type Res = Either[String, Int]

  "version" in {
    val expected = "git describe --dirty".!!.trim.replaceAll(raw"-(\d+)-g", ".$1.g")
    git.version shouldBe expected
  }
}
