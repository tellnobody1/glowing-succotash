ThisBuild / scalaVersion := "2.13.2"
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
).aggregate(plug, git, demo)

lazy val plug = project.in(file("plug")).settings(
  libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided,
  name := s"ext-${name.value}",
)
lazy val git = project.in(file("git")).settings(
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
