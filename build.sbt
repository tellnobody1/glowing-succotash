scalaVersion := "2.12.8"
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided
organization := "name.tellnobody1"
name := "cplugin"
version := "0.0.1"
isSnapshot := true

scalacOptions ++= Vector(
  "-feature",
  "-deprecation",
  "-Ywarn-unused:imports",
)
