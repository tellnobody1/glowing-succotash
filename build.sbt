scalaVersion := "3.0.0-M3"
githubOwner := "zero-deps"
githubRepository := "ext"
organization := "io.github.zero-deps"
version := zero.git.version()

libraryDependencies ++= Seq(
  "dev.zio" %% "zio-test-sbt" % "1.0.4-2" % Test
)
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges

resolvers += Resolver.JCenterRepository
