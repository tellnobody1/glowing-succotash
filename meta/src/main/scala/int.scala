package zd.gs

package object meta {
  object Macros {
    import scala.reflect.macros.blackbox.Context
    def int(c: Context)(): c.Expr[Int] = {
      import c.universe.{Try=>_,_}
      import scala.util._
      val Apply(_, List(Apply(_, List(Literal(Constant(s:String)))))) = c.prefix.tree
      Try(s.replaceAllLiterally("'", "").toInt) match {
        case Success(i) => c.Expr[Int](Literal(Constant(i)))
        case Failure(_) => throw new NumberFormatException("illegal integer constant")
      }
    }
  }

  implicit class Literals(s: StringContext) {
    def i(): Int = macro Macros.int
  }
}
