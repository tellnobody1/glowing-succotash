import zd.gs.meta.Literals
import zd.gs.ops.Cast

object Demo extends App {
  trait A
  class B extends A
  class C extends A

  val a: A = new B
  val b1: B = new B
  val b2: B = new B
  val c: C = new C
  val i: Int = 1
  val l: Long = 1

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
  // b1 == c  // ko
  // b1 == a  // ko
  // a == b1  // ko
  // b1 == c  // ko
  // b1 != c  // ko
  // b1 != a  // ko
  // a != b1  // ko
  // b1 != c  // ko
  // i + 1 == l + 1 // ko
  // i + 1 != l + 1 // ko

  assert(i"1'000'000" == 1000000)

  // compiles:
  "".as[Any]
  // doesn't compile:
  // 1.as[Long] // ko
}
