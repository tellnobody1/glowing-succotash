# glowing-succotash

Compiler plugins/macros/ops for Scala.

[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/ext-plug.svg?label=ext-plug)](https://bintray.com/zero-deps/maven/ext-plug/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/ext-git.svg?label=ext-git)](https://bintray.com/zero-deps/maven/ext-git/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/ext.svg?label=ext)](https://bintray.com/zero-deps/maven/ext/_latestVersion)

## Projects

### ext-plug

Restrict `==`/`!=` to compare same types and forbid compare arrays.

See `demo/src/main/scala/plug.demo.scala` for details.

```
resolvers += Resolver.jcenterRepo
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

## Publish

```
sbt publish
```
