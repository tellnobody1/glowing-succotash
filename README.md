# glowing-succotash

Compiler plugins/macros/ops for Scala.

## Install

```
resolvers += Resolver.bintrayRepo("zero-deps", "maven")
libraryDependencies += compilerPlugin("io.github.zero-deps" %% "gs-plug" % "latest.integration")
libraryDependencies += "io.github.zero-deps" %% "gs-meta" % "latest.integration"
libraryDependencies += "io.github.zero-deps" %% "gs-ops" % "latest.integration"
```

## plug

Restrict `==`/`!=` to compare only same types. 

## meta

Formatted integers.

### Use

```scala
import zd.gs.meta.Literals
i"1'000'000"
```

## ops

Cast to superclass.

## Use

```scala
import zd.gs.ops.Cast
"any".as[Any]
```

## Demo

```bash
$ sbt
> publishLocal
> project demo
> run
```

## Publish

```bash
$ sbt
> publish
```
