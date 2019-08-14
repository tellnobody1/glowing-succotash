ThisBuild / scalaVersion := "2.12.8"
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
ThisBuild / resolvers += Resolver.jcenterRepo
ThisBuild / turbo := true

lazy val root = project.in(file(".")).settings(
  skip in publish := true,
  name := "gs-" + name.value,
).aggregate(meta, ops, plug, git, z)

lazy val meta = project.in(file("meta")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % Compile,
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test,
  name := "gs-" + name.value,
)
lazy val ops = project.in(file("ops")).settings(
  name := "gs-" + name.value,
)
lazy val plug = project.in(file("plug")).settings(
  libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided,
  name := "gs-" + name.value,
)
lazy val git = project.in(file("git")).settings(
  libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "latest.integration",
  name := "gs-" + name.value,
)
lazy val z = project.in(file("z")).settings(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test,
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
  libraryDependencies += "io.github.zero-deps" %% "gs-git" % "latest.integration",
  libraryDependencies += "org.slf4j" % "slf4j-nop" % "latest.integration",
  libraryDependencies += compilerPlugin("io.github.zero-deps" %% "gs-plug" % "1.0.0-dirty"),
)
