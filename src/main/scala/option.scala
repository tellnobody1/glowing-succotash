package zero.ext

package object option {
  val none = None

  inline def fromNullable[A](x: A): Option[A] = Option(x)

  extension [A](x: A)
    inline def some: Some[A] = Some(x)

  extension [A,B,U](x: Option[A])
    inline def map_(f: A => U): Unit = x.foreach(f)
    inline def cata(f: A => B, b: => B): B = x.fold(b)(f)
    inline def void: Option[Unit] = x.map(_ => ())
    inline def tap(f: A => U): Option[A] = x.map{r =>
      f(r)
      r
    }
}