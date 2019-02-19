val demo = project.in(file(".")).settings(
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
)

addCompilerPlugin("com.github.zero-deps" %% "gs-plug" % "latest.integration")
