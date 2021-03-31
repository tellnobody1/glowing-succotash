scalaVersion := "3.0.0-RC2"
crossScalaVersions := "3.0.0-RC2" :: "3.0.0-RC1" :: "2.13.5" :: Nil
organization := "io.github.zero-deps"
version := zero.git.version()

libraryDependencies ++= Seq(
  // "dev.zio" %% "zio-test-sbt" % "1.0.5" % Test
)
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

scalacOptions ++= {
  scalaVersion.value match {
    case "2.13.5" => Nil
    case "3.0.0-RC1" => Seq(
      "-source", "future-migration", "-deprecation", "-rewrite"
    , "release", "11"
    , "-Yexplicit-nulls"
    , "-language:postfixOps", "-language:strictEquality"
    )
    case "3.0.0-RC2" => Seq(
      "-source", "future-migration", "-deprecation", "-rewrite"
    , "release", "11"
    , "-Yexplicit-nulls"
    , "-language:postfixOps", "-language:strictEquality"
    )
    case v => throw new Exception(s"bad version=$v")
  }
}

resolvers += Resolver.JCenterRepository

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges