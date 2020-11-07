# ext

![ci](https://github.com/zero-deps/ext/workflows/ci/badge.svg)

Compiler plugins/macros/ops for Scala.

## Projects

### ext-plug

Restrict `==`/`!=` to compare same types and forbid compare arrays.

See `demo/src/main/scala/plug.demo.scala` for details.

```
libraryDependencies += compilerPlugin("io.github.zero-deps" %% "ext-plug" % "latest.integration")
```

### ext-git

```scala
import zero.ext._
git.version // version based on git-describe
```

```
libraryDependencies += "io.github.zero-deps" %% "ext-git" % "latest.integration"
```

### ext

```scala
import zero.ext._, boolean._, cast._, cat._, either._, int._, option._, traverse._, validate._
// see src/main and src/test for details
```

```
libraryDependencies += "io.github.zero-deps" %% "ext" % "latest.integration"
```

## Demo

```
sbt 'project demo' run
```

