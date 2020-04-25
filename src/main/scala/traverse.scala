package zero.ext

import scala.annotation.tailrec

import option._, either._

package object traverse {
  implicit class OptionEitherTraverseExt[A,B](x: Option[Either[A,B]]) {
    def sequence(): Either[A, Option[B]] = {
      x match {
        case Some(Right(y)) => y.some.right
        case Some(Left(y)) => y.left
        case None => none.right
      }
    }
  }

  implicit class SeqEitherTraverseExt[A,B](xs: Seq[Either[A, B]]) {
    @tailrec private def _sequence(ys: Seq[Either[A, B]], acc: Vector[B]): Either[A, Vector[B]] = {
      ys.headOption match {
        case None => Right(acc)
        case Some(l@Left(_)) => l.coerceRight
        case Some(Right(z)) => _sequence(ys.tail, acc :+ z)
      }
    }
    def sequence(): Either[A, Vector[B]] = _sequence(xs, Vector.empty)

    @tailrec private def _sequence_(ys: Seq[Either[A, B]]): Either[A, Unit] = {
      ys.headOption match {
        case None => Right(())
        case Some(l@Left(_)) => l.coerceRight
        case Some(Right(z)) => _sequence_(ys.tail)
      }
    }
    def sequence_(): Either[A, Unit] = _sequence_(xs)
  }

  implicit class ListOptionTraverseExt[A](xs: List[Option[A]]) {
    @tailrec private def _sequence(ys: List[Option[A]], acc: Vector[A]): Option[List[A]] = {
      ys match {
        case Nil => Some(acc.toList)
        case None :: zs => None 
        case Some(z) :: zs => _sequence(zs, acc :+ z)
      }
    }
    def sequence: Option[List[A]] = _sequence(xs, Vector.empty)
  }
}