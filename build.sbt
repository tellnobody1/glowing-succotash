ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "com.github.zero-deps"
ThisBuild / version := org.eclipse.jgit.api.Git.open(file(".")).describe().call()
ThisBuild / isSnapshot := true
ThisBuild / scalacOptions ++= Vector(
  "-feature",
  "-deprecation",
  "-Ywarn-unused:imports",
  "-language:experimental.macros",
)

lazy val root = project.in(file(".")).settings(
  skip in publish := true,
  name := "gs-" + name.value,
).aggregate(meta, ops, plug)

lazy val meta = project.in(file("meta")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % Compile,
  name := "gs-" + name.value,
)
lazy val ops = project.in(file("ops")).settings(
  name := "gs-" + name.value,
)
lazy val plug = project.in(file("plug")).settings(
  libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided,
  name := "gs-" + name.value,
)
