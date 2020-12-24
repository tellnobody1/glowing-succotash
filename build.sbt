scalaVersion := "3.0.0-M3"
githubOwner := "zero-deps"
githubRepository := "ext"
organization := "io.github.zero-deps"
version := zero.git.version()
isSnapshot := true

libraryDependencies ++= Seq(
  "dev.zio" % "zio-test_2.13"     % "latest.integration" % Test
, "dev.zio" % "zio-test-sbt_2.13" % "latest.integration" % Test
)
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges
