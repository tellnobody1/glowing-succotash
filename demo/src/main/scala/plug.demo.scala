import zero.ext._, cast._

case class Name(name: String) // ok
// case class XS(array: Array[Byte]) // not ok

object PlugDemo extends App {
  // compiles:
  "" == null
  null == ""

  // given:
  sealed trait A
  final case class B() extends A
  final case class C() extends A
  // doesn't compile:
  // final case class D(xs: Array[Int]) extends A

  // and:
  val a: A = B()
  val b1: B = B()
  val b2: B = B()
  val c: C = C()
  val i: Int = 1
  val l: Long = 1
  val xs: Array[Byte] = Array[Byte](1,2,3)
  val ys: Array[Byte] = Array[Byte](1,2,3)

  // correct way to compare arrays
  java.util.Arrays.equals(xs, ys)

  // compiles:
  Option(1) match {
    case Some(_) =>
    case None =>
  }

  // compiles:
  a == a
  b1 == b2
  a == b1.as[A]
  a != a
  b1 != b2
  a != b1.as[A]
  i.toLong + 1 == l + 1
  i.toLong + 1 != l + 1
  1.toInt + 1.toLong == 2.toLong

  // doesn't compile:
  // b1 == c
  // b1 == a
  // a == b1
  // b1 == c
  // b1 != c
  // b1 != a
  // a != b1
  // b1 != c
  // i + 1 == l + 1
  // i + 1 != l + 1
  // Array[Byte]() == xs
  // xs == ys
  // xs != ys
  // 1.toByte == 1.toLong

  // compiles:
  "".as[Any]
  // doesn't compile:
  // 1.as[Long]

  // side effect:
  1 == "".as[Any]
  // comparison with Any is allowed
  // subject to change in the future

}
