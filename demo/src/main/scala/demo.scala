class Demo {
  def f(a: A, b1: B, b2: B, c: C, i: Int, l: Long): Unit = {
    a == a   // ok
    b1 == b2 // ok
    b1 == c  // ko
    b1 == a  // ko
    a == b1  // ko
    b1 == c  // ko
    a != a   // ok
    b1 != b2 // ok
    b1 != c  // ko
    b1 != a  // ko
    a != b1  // ko
    b1 != c  // ko

    i + 1 == l + 1 // ko
    i.toLong + 1 == l + 1 // ok
    i + 1 != l + 1 // ko
    i.toLong + 1 != l + 1 // ok

    1.toInt + 1.toLong == 2.toLong // ok
  }

  trait A
  class B extends A
  class C extends A
}
