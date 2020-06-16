package zero.ext

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.Matchers

class OtherSpec extends AnyFreeSpec with Matchers {
  "option" in {
    import option._
    val _1: Some[Int] = 0.some
    val _2: None.type = none
  }
  "boolean" in {
    import boolean._
    assert(true.fold("true", "ignored") === "true")
    assert(false.fold("ignored", "false") === "false")
  }
  "either" in {
    import either._
    val _8: Left[String,Int] = "left".left[Int]
    val _9: Right[String,Int] = 0.right[String]
    val _d: Either[String,String] = "left".left[Int].coerceRight[String]
    val _e: Either[Int,Int] = 0.right[String].coerceLeft[Int]
    assert(Right("").ensure("is empty")(_.nonEmpty) === Left("is empty"))
    assert(Left[String,String]("").ensure("is empty")(_.nonEmpty) === Left(""))
    assert(Left(0).leftMap(_ + 1) === Left(1))
    assert(Right[Int,Int](0).leftMap(_ + 1) === Right(0))
    Left(0).orElse(Right(1)) shouldBe (Right(1))
  }
  "cat" - {
    import cat._, option._
    "apply" in {
      def f: Int => Int => Int = x => y => x + y
      assert(f `<$>` 2.some <*> 3.some === Some(5))
      assert(f `<$>` 2.some <*> None === None)
    }
    "apply is lazy" in {
      var i = 0
      def f: Int => Int => Int = x => y => x + y
      def y: Option[Int] = { i = i + 1; 3.some }
      assert(f `<$>` None <*> y === None)
      assert(i === 0)
    }
  }
}

