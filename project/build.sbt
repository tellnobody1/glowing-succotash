libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "latest.integration",
  "io.github.zero-deps" %% "gs-git" % "latest.integration",
)

addSbtPlugin("org.foundweekends" % "sbt-bintray" % "latest.integration")

resolvers += Resolver.jcenterRepo
