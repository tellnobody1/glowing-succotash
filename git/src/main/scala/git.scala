package zd.gs.git

import java.io.File

object GitOps {
  def version: String = version()

  def version(dir: String = ".", tags: Boolean = false, stripPrefix: String = "v"): String = {
    val repo = org.eclipse.jgit.api.Git.open(new File(dir))
    val desc = repo.describe.setTags(tags).call.stripPrefix(stripPrefix)
    val dirty = if (repo.status.call.isClean) "" else "-dirty"
    s"${desc}${dirty}"
  }
}
