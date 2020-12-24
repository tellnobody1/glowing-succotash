resolvers += Resolver.githubPackages("zero-deps")
addSbtPlugin("io.github.zero-deps" % "sbt-git" % "latest.integration")
addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "latest.integration")
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")
