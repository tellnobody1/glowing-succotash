package zero.ext

import java.io.File

object git {
  def version: String = version()

  def version(dir: String = ".", tags: Boolean = false, stripPrefix: String = "v", dotted: Boolean = true): String = {
    val git = org.eclipse.jgit.api.Git.open(new File(dir))
    val base = {
      val repo = git.getRepository
      val desc = Option(git.describe.setTags(tags).call).map(_.stripPrefix(stripPrefix))
      val x = desc.getOrElse(repo.newObjectReader.abbreviate(repo.resolve("HEAD")).name)
      if (dotted) x.replace('-','.') else x
    }
    val dirty = if (git.status.call.isClean) "" else "-dirty"
    base + dirty
  }
}
