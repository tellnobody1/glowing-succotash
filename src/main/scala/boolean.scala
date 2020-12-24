package zero.ext

package object boolean {
  extension [A](x: Boolean)
    inline def fold(t: => A, f: => A): A = if x then t else f
}