package zero.ext

extension [B, A <: B](a: A)
  inline def as: B = a
