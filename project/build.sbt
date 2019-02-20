libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "latest.integration",
  "org.eclipse.jgit" % "org.eclipse.jgit" % "latest.integration",
)

addSbtPlugin("org.foundweekends" % "sbt-bintray" % "latest.integration")
