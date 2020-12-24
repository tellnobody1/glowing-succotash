package zero.ext

package object option {
  val none = None

  inline def fromNullable[A](x: A): Option[A] = Option(x)

  implicit class AnyOptionExt[A](x: A):
    inline def some: Some[A] = Some(x)

  implicit class OptionExt[A](x: Option[A]):
    inline def map_[U](f: A => U): Unit = x.foreach(f)
    inline def cata[B](f: A => B, b: => B): B = x.fold(b)(f)
    inline def void: Option[Unit] = x.map(_ => ())
    inline def tap[U](f: A => U): Option[A] = x.map{r =>
      f(r)
      r
    }
}