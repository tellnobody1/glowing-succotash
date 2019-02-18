scalaVersion := "2.12.8"

scalacOptions ++= Vector(
  "-feature",
  "-deprecation",
  // "-Ybrowse:refchecks",
)

val root = project.in(file(".")).withId("demo")

addCompilerPlugin("name.tellnobody1" %% "cplugin" % "0.0.1")
