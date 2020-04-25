package zero.ext

package object cast {
  implicit class AnyCastExt[A](a: A) {
    def as[B >: A]: B = a
  }
}
