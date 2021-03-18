package zero.ext.trampoline

sealed trait Trampoline[A] {
  def run: A = this match {
    case Done(v) => v
    case Suspend(f) => f().run
  }
}
final case class Done[A](v: A) extends Trampoline[A]
final case class Suspend[A](f: () => Trampoline[A]) extends Trampoline[A]
