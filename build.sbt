ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "io.github.zero-deps"
ThisBuild / licenses += "Unlicense" -> url("http://unlicense.org")
ThisBuild / version := zd.gs.git.GitOps.version
ThisBuild / scalacOptions ++= Vector(
  "-feature",
  "-deprecation",
  "-Ywarn-unused:imports",
  "-language:experimental.macros",
)
ThisBuild / isSnapshot := true // override local artifacts
ThisBuild / resolvers += Resolver.bintrayRepo("zero-deps", "maven")

ThisBuild / turbo := true
ThisBuild / useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val ext = project.in(file(".")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % Compile,
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test,
).aggregate(plug, bld, demo)

lazy val plug = project.in(file("plug")).settings(
  libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided,
  name := s"ext-${name.value}",
)
lazy val bld = project.in(file("bld")).settings(
  scalaVersion := "2.12.11",
  libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "latest.integration",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test,
  name := s"ext-${name.value}",
)

// scalac -Xshow-phases
lazy val demo = project.in(file("demo")).settings(
  skip in publish := true,
  scalaVersion := "2.13.2",
  scalacOptions ++= Vector(
    "-feature",
    "-deprecation",
    // "-Ybrowse:typer",
  ),
  run / fork := true,
  libraryDependencies += "io.github.zero-deps" % "ext-git_2.12" % "2.1",
  libraryDependencies += "io.github.zero-deps" %% "ext" % "2.1",
  libraryDependencies += "org.slf4j" % "slf4j-nop" % "latest.integration",
  libraryDependencies += compilerPlugin("io.github.zero-deps" %% "ext-plug" % "2.1"),
)

val git = inputKey[Unit]("Git support")
git := {
  // https://download.eclipse.org/jgit/site/5.7.0.202003110725-r/apidocs/index.html
  import sbt.complete.DefaultParsers._
  import org.eclipse.jgit.api._
  import scala.collection.JavaConverters._
  val git = Git.open(file("."))
  spaceDelimited("<arg>").parsed.toList match {
    case cmd :: Nil if cmd startsWith "s" =>
      def formatLine(c: String): String = " ".repeat(4)+c+" ".repeat(80-4-c.length)
      val emptyLine = " ".repeat(80)
      val st = git.status.call
      print(List(st.getChanged, st.getAdded).flatMap(_.asScala).toList.sorted match {
        case Nil => ""
        case xs => s"""
        |Changes to be committed:
        |\u001B[32m${xs.map(formatLine).mkString("\n")}\u001B[0m
        |$emptyLine""".stripMargin
      })
      print(st.getModified.asScala.toList.sorted match {
        case Nil => ""
        case xs => s"""
        |Changes not staged for commit:
        |\u001B[31m${xs.map(formatLine).mkString("\n")}\u001B[0m
        |$emptyLine""".stripMargin
      })
      print(List(st.getUntracked).flatMap(_.asScala).toList.sorted match {
        case Nil => ""
        case xs => s"""
        |Untracked files:
        |\u001B[31m${xs.map(formatLine).mkString("\n")}\u001B[0m
        |$emptyLine""".stripMargin
      })
      println(emptyLine)
    case "add" :: xs if xs.nonEmpty =>
      val add = git.add
      xs.foreach(add.addFilepattern)
      add.call
      val add2 = git.add.setUpdate(true)
      xs.foreach(add2.addFilepattern)
      add2.call
    case "commit" :: "-m" :: msg :: Nil if msg.nonEmpty =>
      git.commit.setMessage(msg).call
    case _ =>
      println("Available commands:")
      println("  git status")
      println("  git add [<pathspec>…]")
      println("  git commit -m <msg>")
  }
}