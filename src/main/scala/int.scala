package zero.ext

package object int {
  implicit class Literals(s: StringContext) {
    def i(): Int = macro Macros.int
  }

  object Macros {
    import scala.reflect.macros.blackbox.Context
    def int(c: Context)(): c.Expr[Int] = {
      import c.universe._
      val Apply(_, List(Apply(_, List(Literal(Constant(s:String)))))) = c.prefix.tree
      s.replace("'", "").toIntOption match {
        case Some(i) => c.Expr[Int](Literal(Constant(i)))
        case None => throw new NumberFormatException("illegal integer constant")
      }
    }
  }
}
