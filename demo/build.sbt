val demo = project.in(file(".")).settings(
  scalaVersion := "2.12.8",
  scalacOptions ++= Vector(
    "-feature",
    "-deprecation",
    // "-Ybrowse:refchecks",
  ),
  run / fork := true,
  Compile / run / mainClass := Some("Demo"),
  libraryDependencies += "com.github.zero-deps" %% "gs-meta" % "0.0.1",
  libraryDependencies += "com.github.zero-deps" %% "gs-ops" % "0.0.1",
)

addCompilerPlugin("com.github.zero-deps" %% "gs-plug" % "0.0.1")
