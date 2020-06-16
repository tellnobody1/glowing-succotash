package zero.ext.nat

final class Nat private (val i: Int) extends AnyVal {
  def +(n: Nat): Nat = Nat.of(i+n.i)
  def -(n: Nat): Nat = Nat.of(i-n.i)
  def increment(): Nat = Nat.of(i+1)
  def decrement(): Nat = Nat.of(i-1)
  def *(n: Nat): Nat = Nat.of(i*n.i)
}

object Nat {
  val Z = new Nat(0)
  val S = new Nat(1)
  def of(i: Int): Nat = if (i <= 0) Z else new Nat(i)
}
