scalaVersion := "3.0.0-M2"
githubOwner := "zero-deps"
githubRepository := "ext"
organization := "io.github.zero-deps"
version := zero.git.version()
isSnapshot := true

libraryDependencies ++= Seq(
  "dev.zio" % "zio-test_3.0.0-M2"     % "1.0.3+115-4e6e1ca1-SNAPSHOT" % Test
, "dev.zio" % "zio-test-sbt_3.0.0-M2" % "1.0.3+115-4e6e1ca1-SNAPSHOT" % Test
)
resolvers += Resolver.sonatypeRepo("snapshots")
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges
