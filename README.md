# ext

![ci](https://github.com/zero-deps/ext/workflows/ci/badge.svg)

```scala
import zero.ext._, boolean._, cast._, either._, option._, option.cat._, seq._, trampoline._, traverse._, validate._
// see src/main and src/test for details
```

```scala
// build.sbt (Scala 2.13.4)
libraryDependencies += "io.github.zero-deps" % "ext_3.0.0-M2" % "latest.integration"
scalacOptions += "-Ytasty-reader"
resolvers += Resolver.githubPackages("zero-deps")

// build.sbt (Scala 3.0.0-M2)
libraryDependencies += "io.github.zero-deps" %% "ext" % "latest.integration"
resolvers += Resolver.githubPackages("zero-deps")

// project/plugins.sbt
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")
```
