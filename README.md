# glowing-succotash

Compiler plugins/macros/ops for Scala.

## plug

Restrict `==`/`!=` to compare only same types. 

### Use

```sbt
addCompilerPlugin("com.github.zero-deps" %% "gs-plug" % "0.0.1")
```

## meta

Formatted integers.

### Use

```sbt
libraryDependencies += "com.github.zero-deps" %% "gs-meta" % "0.0.1"
```

```scala
i"1'000'000"
```

## ops

Cast to superclass.

## Use

```sbt
libraryDependencies += "com.github.zero-deps" %% "gs-ops" % "0.0.1"
```

```scala
"".as[Any]
```

## Demo

```bash
$ sbt
> publishLocal
> exit
cd demo
$ sbt
> run
```
