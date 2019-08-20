# glowing-succotash

Compiler plugins/macros/ops for Scala.

[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-plug.svg?label=plug)](https://bintray.com/zero-deps/maven/gs-plug/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-meta.svg?label=meta)](https://bintray.com/zero-deps/maven/gs-meta/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-git.svg?label=git)](https://bintray.com/zero-deps/maven/gs-git/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-z.svg?label=z)](https://bintray.com/zero-deps/maven/gs-z/_latestVersion)

## Install

```
resolvers += Resolver.jcenterRepo
libraryDependencies += compilerPlugin("io.github.zero-deps" %% "gs-plug" % "latest.integration")
libraryDependencies += "io.github.zero-deps" %% "gs-meta" % "latest.integration"
libraryDependencies += "io.github.zero-deps" %% "gs-z" % "latest.integration"
libraryDependencies += "io.github.zero-deps" %% "gs-git" % "latest.integration"
```

## Projects

### plug

Restrict `==`/`!=` to compare same types and forbid compare arrays.

### meta

```scala
import zd.gs.meta.Literals
i"1'000'000" // allow ' as thousand separator
```

### git

```scala
import zd.gs.git.GitOps
GitOps.version // version based on git-describe
```

### z

```scala
import zd.gs.z._
// check z/src/test/scala/z.scala for examples
```

```scala
import zd.gs.z.validate._
// check z/src/test/scala/validate.scala for examples
```

```scala
import zd.gs.z.cast._
"any".as[Any]
```

## Demo

```bash
sbt
publishLocal
project demo
run
```

## Publish

```bash
sbt
publish
```
