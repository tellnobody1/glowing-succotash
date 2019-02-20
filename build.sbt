ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "io.github.zero-deps"
ThisBuild / licenses += "Unlicense" -> url("http://unlicense.org")
ThisBuild / version := org.eclipse.jgit.api.Git.open(file(".")).describe().call()
ThisBuild / scalacOptions ++= Vector(
  "-feature",
  "-deprecation",
  "-Ywarn-unused:imports",
  "-language:experimental.macros",
)
ThisBuild / isSnapshot := true // override local artifacts

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

// scalac -Xshow-phases
lazy val demo = project.in(file("demo")).settings(
  scalaVersion := "2.12.8",
  scalacOptions ++= Vector(
    "-feature",
    "-deprecation",
    // "-Ybrowse:typer",
  ),
  run / fork := true,
  Compile / run / mainClass := Some("Demo"),
  resolvers += Resolver.bintrayRepo("zero-deps", "maven"),
  libraryDependencies += "io.github.zero-deps" %% "gs-meta" % "latest.integration",
  libraryDependencies += "io.github.zero-deps" %% "gs-ops" % "latest.integration",
  libraryDependencies += compilerPlugin("io.github.zero-deps" %% "gs-plug" % "latest.integration"),
)
