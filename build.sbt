ThisBuild / scalaVersion := "2.13.1"
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
ThisBuild / useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = project.in(file(".")).settings(
  skip in publish := true,
  name := s"gs-${name.value}",
).aggregate(meta, plug, git, z)

lazy val meta = project.in(file("meta")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % Compile,
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test,
  name := s"gs-${name.value}",
)
lazy val plug = project.in(file("plug")).settings(
  libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided,
  name := s"gs-${name.value}",
)
lazy val git = project.in(file("git")).settings(
  scalaVersion := "2.12.9",
  libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "latest.integration",
  name := s"gs-${name.value}",
)
lazy val z = project.in(file("z")).settings(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test,
  name := s"gs-${name.value}",
)

// scalac -Xshow-phases
lazy val demo = project.in(file("demo")).settings(
  skip in publish := true,
  scalaVersion := "2.13.0",
  scalacOptions ++= Vector(
    "-feature",
    "-deprecation",
    // "-Ybrowse:typer",
  ),
  run / fork := true,
  Compile / run / mainClass := Some("Demo"),
  resolvers += Resolver.bintrayRepo("zero-deps", "maven"),
  libraryDependencies += "io.github.zero-deps" %% "gs-meta" % "1.5.0",
  libraryDependencies += "io.github.zero-deps" %% "gs-git" % "1.5.0",
  libraryDependencies += "io.github.zero-deps" %% "gs-z" % "1.5.0",
  libraryDependencies += "org.slf4j" % "slf4j-nop" % "latest.integration",
  libraryDependencies += compilerPlugin("io.github.zero-deps" %% "gs-plug" % "1.5.0"),
)
