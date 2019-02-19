package zd.gs

package object ops {
  implicit class Cast[A](a: A) {
    def as[B >: A]: B = a
  }
}

