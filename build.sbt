scalaVersion := "2.13.4"
githubOwner := "zero-deps"
githubRepository := "ext"
organization := "io.github.zero-deps"
version := zero.git.version()
scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Ywarn-unused:imports",
)
isSnapshot := true // override local artifacts

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges
