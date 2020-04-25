package zero.ext

import java.io.File

object git {
  def version: String = version()

  def version(dir: String = ".", tags: Boolean = false, stripPrefix: String = "v"): String = {
    val git = org.eclipse.jgit.api.Git.open(new File(dir))
    val desc = Option(git.describe.setTags(tags).call).map(_.stripPrefix(stripPrefix))
    val repo = git.getRepository
    val base = desc.getOrElse("0-"+repo.newObjectReader.abbreviate(repo.resolve("HEAD")).name)
    val dirty = if (git.status.call.isClean) "" else "-dirty"
    s"${base}${dirty}"
  }
}
