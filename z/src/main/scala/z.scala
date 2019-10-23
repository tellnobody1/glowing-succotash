package zd.gs

package object z {
  import scala.annotation.tailrec
  type Maybe[A] = Option[A]
  val Maybe = Option
  type Just[A] = Some[A]
  val Just = Some
  type Nothing = None.type
  val Nothing = None
  def fromNullable[A](x: A): Maybe[A] = Option(x)
  implicit class OptionExt[A](x: Option[A]) {
    final def cata[B](f: A => B, b: => B): B = x match {
      case Some(a) => f(a)
      case Nothing => b
    }
  }
  implicit class AnyExt[A](x: A) {
    def left[R]: Left[A,R] = Left(x)
    def right[L]: Right[L,A] = Right(x)
    def just: Just[A] = Just(x)
  }
  implicit class BooleanExt(x: Boolean) {
    def fold[A](t: => A, f: => A): A = {
      if (x) t else f
    }
  }
  implicit class SeqEitherExt[A,B](xs: Seq[Either[A, B]]) {
    @tailrec
    private def _sequenceU(ys: Seq[Either[A, B]], acc: Vector[B]): Either[A, Vector[B]] = {
      ys.headOption match {
        case None => Right(acc)
        case Some(l@Left(_)) => l.coerceRight
        case Some(Right(z)) => _sequenceU(ys.tail, acc :+ z)
      }
    }
    def sequenceU: Either[A, Vector[B]] = _sequenceU(xs, Vector.empty)
    @tailrec
    private def _sequence_(ys: Seq[Either[A, B]]): Either[A, Unit] = {
      ys.headOption match {
        case None => Right(())
        case Some(l@Left(_)) => l.coerceRight
        case Some(Right(z)) => _sequence_(ys.tail)
      }
    }
    def sequence_ : Either[A, Unit] = _sequence_(xs)
  }
  implicit class ListOptionExt[A](xs: List[Option[A]]) {
    @tailrec
    private def _sequenceU(ys: List[Option[A]], acc: Vector[A]): Option[List[A]] = {
      ys match {
        case Nil => Some(acc.toList)
        case None :: zs => None 
        case Some(z) :: zs => _sequenceU(zs, acc :+ z)
      }
    }
    def sequenceU: Option[List[A]] = _sequenceU(xs, Vector.empty)
  }
  implicit class LeftExt[L,R](x: Left[L,R]) {
    def coerceRight[R2]: Either[L,R2] = x.asInstanceOf[Either[L,R2]]
  }
  implicit class RightExt[L,R](x: Right[L,R]) {
    def coerceLeft[L2]: Either[L2,R] = x.asInstanceOf[Either[L2,R]]
  }
  implicit class EitherExt[L,R](x: Either[L,R]) {
    def ensure(l: => L)(f: R => Boolean): Either[L,R] = x match {
      case Right(r) => if (f(r)) x else Left(l)
      case Left(_) => x
    }
    def bimap[L2,R2](l: L => L2)(r: R => R2): Either[L2,R2] = x match {
      case Right(x) => r(x).right
      case Left(x) => l(x).left
    }
    def leftMap[L2](f: L => L2): Either[L2,R] = x match {
      case y@Right(_) => y.coerceLeft
      case Left(l) => Left(f(l))
    }
    def orElse[L2](x: => Either[L2,R]): Either[L2,R] = x match {
      case Left(_) => x
      case y@Right(_) => y.coerceLeft
    }
    def void: Either[L,Unit] = x.map(_ => ())
    def recover(pf: PartialFunction[L,R]): Either[L,R] = x match {
      case Left(l) if pf isDefinedAt l => Right(pf(l))
      case _ => x
    }
  }
  implicit class Functor_Maybe[A,B](fn: Function1[A,B]) {
    def `<$>`(x: Maybe[A]): Maybe[B] = x match {
      case Just(y) => Just(fn(y))
      case Nothing => Nothing
    }
  }
  implicit class Apply_Maybe[A,B](fn: Maybe[Function1[A,B]]) {
    def <*>(x: => Maybe[A]): Maybe[B] = fn match {
      case Just(fn) => fn `<$>` x
      case Nothing => Nothing
    }
  }
}
