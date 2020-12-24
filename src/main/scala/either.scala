package zero.ext

package object either {
  implicit class AnyEitherExt[A](x: A):
    inline def left[R]: Left[A,R] = Left(x)
    inline def right[L]: Right[L,A] = Right(x)

  implicit class LeftExt[L,R](x: Left[L,R]):
    inline def coerceRight[R2]: Either[L,R2] = x.asInstanceOf[Either[L,R2]]

  implicit class RightExt[L,R](x: Right[L,R]):
    inline def coerceLeft[L2]: Either[L2,R] = x.asInstanceOf[Either[L2,R]]

  implicit class EitherExt[L,R](x: Either[L,R]):
    inline def map_[U](f: R => U): Unit = x.foreach(f)
    inline def ensure(l: => L)(f: R => Boolean): Either[L,R] = x match
      case Right(r) => if f(r) then x else Left(l)
      case Left(_) => x
    inline def bimap[L2,R2](l: L => L2, r: R => R2): Either[L2,R2] = x match
      case Right(x) => r(x).right
      case Left(x) => l(x).left
    inline def leftMap[L2](f: L => L2): Either[L2,R] = x match
      case y@Right(_) => y.coerceLeft
      case Left(l) => Left(f(l))
    inline def orElse[L2](x: => Either[L2,R]): Either[L2,R] = x match
      case Left(_) => x
      case y@Right(_) => y.coerceLeft
    inline def void: Either[L,Unit] = x.map(_ => ())
    inline def recover(pf: PartialFunction[L,R]): Either[L,R] = x match
      case Left(l) if pf isDefinedAt l => Right(pf(l))
      case _ => x
    inline def tap[U](f: R => U): Either[L, R] = x.map{r =>
      f(r)
      r
    }
}