package zero.ext

package object cast:
  implicit class AnyCastExt[A](a: A):
    inline def as[B >: A]: B = a
