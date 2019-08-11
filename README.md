# glowing-succotash

Compiler plugins/macros/ops for Scala.

[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-plug.svg?label=plug)](https://bintray.com/zero-deps/maven/gs-plug/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-meta.svg?label=meta)](https://bintray.com/zero-deps/maven/gs-meta/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-ops.svg?label=ops)](https://bintray.com/zero-deps/maven/gs-ops/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-git.svg?label=git)](https://bintray.com/zero-deps/maven/gs-git/_latestVersion)

## Install

```
resolvers += Resolver.bintrayRepo("zero-deps", "maven")
libraryDependencies += compilerPlugin("io.github.zero-deps" %% "gs-plug" % "latest.integration")
libraryDependencies += "io.github.zero-deps" %% "gs-meta" % "latest.integration"
libraryDependencies += "io.github.zero-deps" %% "gs-ops" % "latest.integration"
libraryDependencies += "io.github.zero-deps" %% "gs-git" % "latest.integration"
```

## Projects

### plug

Restrict `==`/`!=` to compare only same types. 

### meta

Formatted integers.

#### Use

```scala
import zd.gs.meta.Literals
i"1'000'000"
```

### ops

Cast to superclass.

#### Use

```scala
import zd.gs.ops.Cast
"any".as[Any]
```

### git

Git ops

#### Use

```scala
import zd.gs.git.GitOps
GitOps.version
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
