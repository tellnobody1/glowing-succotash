scalaVersion := "3.0.0-RC1"
crossScalaVersions := "3.0.0-RC1" :: "2.13.5" :: Nil
githubOwner := "zero-deps"
githubRepository := "ext"
organization := "io.github.zero-deps"
version := zero.git.version()

libraryDependencies ++= Seq(
  "dev.zio" %% "zio-test-sbt" % "1.0.5" % Test
)
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

scalacOptions ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 13)) => Nil
    case _ =>
      Seq(
        "-language:postfixOps"
      , "-language:strictEquality"
      , "-Yexplicit-nulls"
      , "-source", "future-migration"
      , "-deprecation"
      , "-rewrite"
      , "release", "11"
      )
  }
}

resolvers += Resolver.JCenterRepository

turbo := true
useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges