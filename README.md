# TestCharged
[![Scala Versions](https://img.shields.io/badge/scala-2.12%20%7C%202.13%20%7C%203.6-blue.svg?style=flat-square)](https://github.com/GarnerCorp/test-charged/blob/73a618b69fbed9f6bb5b1bb75874d3d44efe171c/build.sbt#L11)

A small library with helpers for generating test data through a simple DSL.

You can super charge water.  You should also super charge your tests.

## Quick Start

Simply add that dependency to your SBT file:

```scala 
libraryDependencies += "com.garnercorp" %% "test-charged" % "0.1.5"
```

## Documentation
See [documentation](docs/README.md)

## Contributing

### Releasing
TestCharged uses the [sonatype SBT plugin](https://github.com/xerial/sbt-sonatype) to do releases to Maven Central.

See [.github/workflows/publish.yml](.github/workflows/publish.yml) for steps on how to release a version
