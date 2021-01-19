scalaVersion := "3.0.0-M3"
githubOwner := "zero-deps"
githubRepository := "ext"
organization := "io.github.zero-deps"
version := zero.git.version()
isSnapshot := true

libraryDependencies ++= Seq(
  "dev.zio" %% "zio-test"     % "1.0.3+130-a21e83b8-SNAPSHOT" % Test
, "dev.zio" %% "zio-test-sbt" % "1.0.3+130-a21e83b8-SNAPSHOT" % Test
)
resolvers += Resolver.sonatypeRepo("snapshots")
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges
