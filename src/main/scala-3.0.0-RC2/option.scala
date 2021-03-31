package zero.ext
package option

val none = None

extension [A](x: A | Null)
  inline def toOption: Option[A] =
    given canEqual[A]: CanEqual[A | Null, Null] = CanEqual.derived
    if x != null then x.some else none

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
