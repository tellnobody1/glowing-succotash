libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "latest.integration",
  "org.eclipse.jgit" % "org.eclipse.jgit" % "latest.integration",
)

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "latest.integration")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "latest.integration")
