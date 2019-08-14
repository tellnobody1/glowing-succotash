# glowing-succotash

Compiler plugins/macros/ops for Scala.

[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-plug.svg?label=plug)](https://bintray.com/zero-deps/maven/gs-plug/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-meta.svg?label=meta)](https://bintray.com/zero-deps/maven/gs-meta/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-ops.svg?label=ops)](https://bintray.com/zero-deps/maven/gs-ops/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-git.svg?label=git)](https://bintray.com/zero-deps/maven/gs-git/_latestVersion)
[![Bintray](https://img.shields.io/bintray/v/zero-deps/maven/gs-z.svg?label=z)](https://bintray.com/zero-deps/maven/gs-z/_latestVersion)

## Install

```
resolvers += Resolver.jcenterRepo
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

### z

#### Use

```scala
import zd.gs.z._
val x: Maybe[Int] = Some(0)
val x: Maybe[Int] = Maybe(0)
val x: Just[Int] = Some(0)
val x: Just[Int] = Just(0)
val x: Just[Int] = 0.just
val x: Nothing = None
val x: Nothing = Nothing
val x: Left[String,Int] = "left".left[Int]
val x: Right[String,Int] = 0.right[String]
true.fold("true", "ignored") == "true"
false.fold("ignored", "false") == "false"
val x: Either[String,Vector[Int]] = Stream(1.right,"2".left,3.right).sequenceU
val x: Either[String,Unit] = Stream(1.right,"2".left,3.right).sequence_
val x: Option[List[Int]] = List(1.just,Nothing,3.just).sequenceU
val x: Either[String,String] = "left".left[Int].coerceRight[String]
val x: Either[Int,Int] = 0.right[String].coerceLeft[Int]
Right("").ensure("is empty")(_.nonEmpty) == Left("is empty")
Left[String,String]("").ensure("is empty")(_.nonEmpty) == Left("")
Left(0).leftMap(_ + 1) == Left(1)
Right[Int,Int](0).leftMap(_ + 1) == Right(0)
def f: Int => Int => Int = {
  case x => {
    case y => {
      x + y
    }
  }
}
f `<$>` 2.just <*> 3.just == Some(5)
f `<$>` 2.just <*> Nothing == Nothing
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
