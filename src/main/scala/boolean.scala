package zero.ext

package object boolean {
  implicit class BooleanExt(x: Boolean) {
    def fold[A](t: => A, f: => A): A = if (x) t else f
  }
}