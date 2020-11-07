libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "latest.integration",
  "io.github.zero-deps" %% "ext-git" % "2.2.0",
)

resolvers += Resolver.jcenterRepo

addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")

