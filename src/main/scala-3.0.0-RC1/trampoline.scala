package zero.ext

object Trampoline:
  @annotation.tailrec
  def run[A](x: Trampoline[A]): A = x match
    case Done(v) => v
    case Suspend(f) => run(f())

sealed trait Trampoline[A]
final case class Done[A](v: A) extends Trampoline[A]
final case class Suspend[A](f: () => Trampoline[A]) extends Trampoline[A]
