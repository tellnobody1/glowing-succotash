scalaVersion := "3.0.0-RC1"
githubOwner := "zero-deps"
githubRepository := "ext"
organization := "io.github.zero-deps"
version := zero.git.version()

libraryDependencies ++= Seq(
  "dev.zio" %% "zio-test-sbt" % "1.0.5" % Test
)
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges

resolvers += Resolver.JCenterRepository

scalacOptions ++= Seq(
  "-language:postfixOps"
, "-language:strictEquality"
, "-Yexplicit-nulls"
, "-source", "future-migration"
, "-deprecation"
, "-rewrite"
, "release", "15"
)
