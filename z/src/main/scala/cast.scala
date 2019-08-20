package zd.gs.z

object cast {
  implicit class Cast[A](a: A) {
    def as[B >: A]: B = a
  }
}
