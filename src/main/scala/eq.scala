package cplugin

import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}

class EqPlugin(override val global: Global) extends Plugin {
  override val name = "eq"
  override val description = "equals only for same type"
  override val components = List[PluginComponent](new Component(global))

  class Component(val global: Global) extends PluginComponent {
    import global._
    val phaseName = "eq"
    val runsAfter = List[String]("refchecks")
    def newPhase(prev: Phase): Phase = new StdPhase(prev) {
      override def apply(unit: CompilationUnit): Unit = {
        global.reporter.echo("Checking ==")
        for (
          tree @ Apply(Select(l, nme.EQ), List(r)) <- unit.body
            if !(l.tpe.dealiasWiden =:= r.tpe.dealiasWiden)
        ) {
          global.reporter.error(tree.pos, s"comparing ${l.tpe} with ${r.tpe}")
        }
      }
    }
  }
}
