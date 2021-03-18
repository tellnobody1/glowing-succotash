package zero.ext

import zio.test.*, Assertion.*

object EitherSpec extends DefaultRunnableSpec:
  def spec = suite("EitherSpec")(
    test("either") {
      val checkType1: Left[String,Int] = "left".left
      val checkType2: Right[String,Int] = 0.right
      val checkType3: Either[String,String] = "left".left
      val checkType4: Either[Int,Int] = 0.right
      assert(Right("").ensure("is empty")(_.nonEmpty))(equalTo(Left("is empty"): Either[String,String]))
      && assert(Left[String,String]("").ensure("is empty")(_.nonEmpty))(equalTo(Left("")))
      && assert(Left(0).leftMap(_ + 1))(equalTo(Left(1)))
      && assert(Right[Int,Int](0).leftMap(_ + 1))(equalTo(Right(0)))
      && assert(Left(0).orElse(Right(1)))(equalTo(Right(1)))
    }
  )

