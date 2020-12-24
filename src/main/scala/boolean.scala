package zero.ext

package object boolean {
  implicit class BooleanExt(x: Boolean):
    inline def fold[A](t: => A, f: => A): A = if x then t else f
}