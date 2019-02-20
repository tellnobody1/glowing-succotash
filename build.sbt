ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "io.github.zero-deps"
ThisBuild / homepage := Some(url("https://github.com/zero-deps/glowing-succotash"))
ThisBuild / scmInfo := Some(ScmInfo(url("https://github.com/zero-deps/glowing-succotash"), "scm:git@github.com:zero-deps/glowing-succotash.git"))
ThisBuild / developers := Developer("tellnobody1", "Andrii Nemchenko", "a.nemchenko@icloud.com", url("https://github.com/tellnobody1")) :: Nil
ThisBuild / licenses += "Unlicense" -> url("http://unlicense.org")
ThisBuild / version := org.eclipse.jgit.api.Git.open(file(".")).describe().call()
ThisBuild / scalacOptions ++= Vector(
  "-feature",
  "-deprecation",
  "-Ywarn-unused:imports",
  "-language:experimental.macros",
)
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishMavenStyle := true
ThisBuild / publishTo := Some(Opts.resolver.sonatypeStaging)
ThisBuild / isSnapshot := true // override in local repo

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

lazy val demo = project.in(file("demo")).settings(
  scalaVersion := "2.12.8",
  scalacOptions ++= Vector(
    "-feature",
    "-deprecation",
    // "-Ybrowse:refchecks",
  ),
  run / fork := true,
  Compile / run / mainClass := Some("Demo"),
  libraryDependencies += "com.github.zero-deps" %% "gs-meta" % "latest.integration",
  libraryDependencies += "com.github.zero-deps" %% "gs-ops" % "latest.integration",
  libraryDependencies += compilerPlugin("com.github.zero-deps" %% "gs-plug" % "latest.integration"),
)
