package zero.ext

package object option {
  val none = None

  def fromNullable[A](x: A): Option[A] = Option(x)

  implicit class AnyOptionExt[A](x: A) {
    def some: Some[A] = Some(x)
  }

  implicit class OptionExt[A](x: Option[A]) {
    def map_[U](f: A => U): Unit = x.foreach(f)
    def cata[B](f: A => B, b: => B): B = x match {
      case Some(a) => f(a)
      case None => b
    }
    def void: Option[Unit] = x.map(_ => ())
  }
}