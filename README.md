# glowing-succotash

Compiler plugins for Scala.

## Eq

Restrict ```==``` to compare only same types. 

## Use

```
autoCompilerPlugins := true
addCompilerPlugin("name.tellnobody1" %% "cplugin" % "0.0.1")
```

## Demo

```bash
$ sbt
sbt> publishLocal
sbt> exit
cd demo
sbt
sbt> run
```
