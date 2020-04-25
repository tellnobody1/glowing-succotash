package zero.ext

package object cat {
  implicit class Functor_Maybe[A,B](fn: Function1[A,B]) {
    def `<$>`(x: Option[A]): Option[B] = x match {
      case Some(y) => Some(fn(y))
      case None => None
    }
  }

  implicit class Apply_Maybe[A,B](fn: Option[Function1[A,B]]) {
    def <*>(x: => Option[A]): Option[B] = fn match {
      case Some(fn) => fn `<$>` x
      case None => None
    }
  }
}
