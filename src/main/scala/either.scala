package zero.ext

package object either {
  extension [A,L,R](x: A)
    inline def left : Left [A,R] = Left(x)
    inline def right: Right[L,A] = Right(x)

  extension [L,R,L2,R2](x: Left[L,R])
    inline def coerceRight: Either[L,R2] = x.asInstanceOf[Either[L,R2]]
    inline def ensure(l: => L)(f: R => Boolean): Either[L,R] = x
    inline def leftMap(f: L => L2): Either[L2,R] = Left(f(x.value))

  extension [L,L2,R](x: Right[L,R])
    inline def coerceLeft: Either[L2,R] = x.asInstanceOf[Either[L2,R]]
    inline def ensure(l: => L)(f: R => Boolean): Either[L,R] = if f(x.value) then x else Left(l)
    inline def leftMap(f: L => L2): Either[L2,R] = x.coerceLeft

  extension [L,R,U,L2,R2](x: Either[L,R])
    inline def map_(f: R => U): Unit = x.foreach(f)
    inline def ensure(l: => L)(f: R => Boolean): Either[L,R] = x match
      case y@Right(_) => y.ensure(l)(f)
      case y@Left(_)  => y.ensure(l)(f)
    inline def bimap(l: L => L2, r: R => R2): Either[L2,R2] = x match
      case Right(x) => r(x).right
      case Left(x) => l(x).left
    inline def leftMap(f: L => L2): Either[L2,R] = x match
      case y@Right(_) => y.leftMap(f)
      case y@Left (l) => y.leftMap(f)
    inline def orElse(y: => Either[L2,R]): Either[L2,R] = x match
      case Left(_) => y
      case x1@Right(_) => x1.coerceLeft
    inline def void: Either[L,Unit] = x.map(_ => ())
    inline def recover(pf: PartialFunction[L,R]): Either[L,R] = x match
      case Left(l) if pf isDefinedAt l => Right(pf(l))
      case _ => x
    inline def tap(f: R => U): Either[L, R] = x.map{r =>
      f(r)
      r
    }
}