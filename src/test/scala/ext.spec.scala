package zero.ext

import zio.test._, Assertion._

object OtherSpec extends DefaultRunnableSpec:
  def spec = suite("OtherSpec")(
    test("boolean") {
      import boolean._
      assert(true.fold("true", "ignored"))(equalTo("true"))
      && assert(false.fold("ignored", "false"))(equalTo("false"))
    }
  , test("either") {
      import either._
      val checkType1: Left[String,Int] = "left".left[Int]
      val checkType2: Right[String,Int] = 0.right[String]
      val checkType3: Either[String,String] = "left".left[Int].coerceRight[String]
      val checkType4: Either[Int,Int] = 0.right[String].coerceLeft[Int]
      assert(Right("").ensure("is empty")(_.nonEmpty))(equalTo(Left("is empty")))
      && assert(Left[String,String]("").ensure("is empty")(_.nonEmpty))(equalTo(Left("")))
      && assert(Left(0).leftMap(_ + 1))(equalTo(Left(1)))
      && assert(Right[Int,Int](0).leftMap(_ + 1))(equalTo(Right(0)))
      && assert(Left(0).orElse(Right(1)))(equalTo(Right(1)))
    }
  , test("cat: apply") {
      import option.cat._, option._
      def f: Int => Int => Int = x => y => x + y
      assert(f `<$>` 2.some <*> 3.some)(equalTo(5.some))
      && assert(lift2 (f) (2.some) (3.some))(equalTo(5.some))
      && assert(f `<$>` 2.some <*> none)(equalTo(none))
      && assert(lift2 (f) (2.some) (none))(equalTo(none))
    }
  , test("cat: apply is lazy") {
      import option.cat._, option._
      var i = 0
      def f: Int => Int => Int = x => y => x + y
      def y: Option[Int] = { i = i + 1; 3.some }
      assert(f `<$>` none <*> y)(equalTo(none))
      && assert(i)(equalTo(0))
    }
  )

