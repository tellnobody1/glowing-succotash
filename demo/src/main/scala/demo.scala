import zd.gs.meta.Literals
import zd.gs.ops.Cast

object Demo extends App {
  println(zd.gs.git.GitOps.version(dir = ".."))

  "" == null
  null == ""

  sealed trait A
  final case class B() extends A
  final case class C() extends A

  val a: A = B()
  val b1: B = B()
  val b2: B = B()
  val c: C = C()
  val i: Int = 1
  val l: Long = 1
  val xs: Array[Byte] = Array[Byte](1,2,3)
  val ys: Array[Byte] = Array[Byte](1,2,3)

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
  /*
  b1 == c  // ko
  b1 == a  // ko
  a == b1  // ko
  b1 == c  // ko
  b1 != c  // ko
  b1 != a  // ko
  a != b1  // ko
  b1 != c  // ko
  i + 1 == l + 1 // ko
  i + 1 != l + 1 // ko
  Array[Byte]() == xs // ko
  xs == ys // ko
  xs != ys // ko
  */

  // compiles:
  "".as[Any]
  // doesn't compile:
  // 1.as[Long] // ko
}
