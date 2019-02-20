# glowing-succotash

Compiler plugins/macros/ops for Scala.

## plug

Restrict `==`/`!=` to compare only same types. 

### Use

```sbt
addCompilerPlugin("com.github.zero-deps" %% "gs-plug" % "latest.integration")
```

## meta

Formatted integers.

### Use

```sbt
libraryDependencies += "com.github.zero-deps" %% "gs-meta" % "latest.integration"
```

```scala
import zd.gs.meta.Literals
i"1'000'000"
```

## ops

Cast to superclass.

## Use

```sbt
libraryDependencies += "com.github.zero-deps" %% "gs-ops" % "latest.integration"
```

```scala
import zd.gs.ops.Cast
"".as[Any]
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
> sonatypeRelease
```
