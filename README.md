# ext

![ci](https://github.com/zero-deps/ext/workflows/ci/badge.svg)

```scala
import zero.ext._, boolean._, cast._, either._, nat._, option._, option.cat._, seq._, trampoline._, traverse._, validate._
// see src/main and src/test for details
```

```
// build.sbt
libraryDependencies += "io.github.zero-deps" %% "ext" % "latest.integration"
resolvers += Resolver.githubPackages("zero-deps")

// project/plugins.sbt
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")
```
