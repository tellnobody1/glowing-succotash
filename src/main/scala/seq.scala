package zero.ext

import option._

package seq {
  trait HeadAccess[+A] {
    val head: Option[A]
    val tail: Option[HeadAccess[A]]
  }
  trait RandomAccess[A] {
    def get(i: Int): Option[A]
  }
}

package object list {
  sealed trait LList[+A] extends seq.HeadAccess[A] {
    def ::[B >: A](x: B): LList[B] = new ::[B](x, this)
  }
  final case object LNil extends LList[Nothing] {
    val head = none
    val tail = none
  }
  final case class ::[A](h: A, t: LList[A]) extends LList[A] {
    val head = h.some
    val tail = t.some
  }
}

package object arrayview {
  sealed trait ByteArrayView extends seq.RandomAccess[Byte] {
    val isEmpty: Boolean = !nonEmpty
    val nonEmpty: Boolean = !isEmpty
  }

  final class NonEmptyByteArrayView private (
      private val bs: Array[Byte]
    , private val offset: Int
    , val length: Int
  ) extends ByteArrayView {
    override val nonEmpty = true
    lazy val mkString = new String(bs, offset, length, "utf8")
    def get(i: Int): Option[Byte] = fromNullable(bs(i))
    lazy val head: Byte = bs(0)
    lazy val tail: ByteArrayView =
      if (length == 1) EmptyByteArrayView
      else new NonEmptyByteArrayView(bs, offset+1, length-1)
    import java.util.Arrays
    override def equals(other: Any): Boolean = {
      other match {
        case xs: NonEmptyByteArrayView =>
          Arrays.equals(bs, offset, offset+length, xs.bs, xs.offset, xs.offset+xs.length)
        case _ => false
      }
    }
    lazy val copy: Array[Byte] = Arrays.copyOfRange(bs, offset, offset+length)
    override def hashCode(): Int = Arrays.hashCode(copy)
  }

  final object EmptyByteArrayView extends ByteArrayView {
    override val isEmpty = true
    def get(i: Int): Option[Byte] = none
  }

  object NonEmptyByteArrayView {
    def unsafeWrap(bs: Array[Byte]): ByteArrayView = {
      val len = bs.length
      if (len == 0) EmptyByteArrayView else new NonEmptyByteArrayView(bs, offset=0, len)
    }
  }

  object ByteArrayView {
    def unsafeWrap(bs: Array[Byte]): ByteArrayView = NonEmptyByteArrayView.unsafeWrap(bs)
  }

  object +# {
    def unapply(xs: ByteArrayView): Option[(Byte, ByteArrayView)] = {
      xs match {
        case EmptyByteArrayView => none
        case ys: NonEmptyByteArrayView => (ys.head, ys.tail).some
      }
    }
  }
}