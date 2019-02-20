package zd.gs.plug

import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}

class EqPlugin(override val global: Global) extends Plugin {
  override val name = "eq"
  override val description = "equals only for same type"
  override val components = List[PluginComponent](new Component(global))

  class Component(val global: Global) extends PluginComponent {
    import global._
    val phaseName = "eq"
    val runsAfter = List[String]("typer")
    override val runsBefore = List[String]("patmat")
    def newPhase(prev: Phase): Phase = new StdPhase(prev) {
      override def apply(unit: CompilationUnit): Unit = {
        global.reporter.echo("Checking == and !=")
        for (
          tree @ Apply(Select(l, op), List(r)) <- unit.body
          if !(l.tpe.dealiasWiden =:= r.tpe.dealiasWiden) && (op == nme.EQ || op == nme.NE)
        ) {
          (l, r) match {
            case (Literal(Constant(null)), _) =>
            case (_, Literal(Constant(null))) =>
            case _ =>
              global.reporter.error(tree.pos, s"comparing ${l.tpe} with ${r.tpe}")
          }
        }
      }
    }
  }
}
