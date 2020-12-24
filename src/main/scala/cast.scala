package zero.ext

package object cast:
  extension [B, A <: B](a: A)
    inline def as: B = a
