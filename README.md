# TestCharged
[![Scala Versions](https://img.shields.io/badge/scala-2.12%20%7C%202.13%20%7C%203.6-blue.svg?style=flat-square)](https://github.com/GarnerCorp/test-charged/blob/73a618b69fbed9f6bb5b1bb75874d3d44efe171c/build.sbt#L11)

[![Maven Central](https://img.shields.io/nexus/r/https/oss.sonatype.org/com.github.fulrich/test-charged_2.11.svg?label=latest%202.11&style=flat-square)](https://repo1.maven.org/maven2/com/github/fulrich/test-charged_2.11/)
[![Maven Central](https://img.shields.io/nexus/r/https/oss.sonatype.org/com.github.fulrich/test-charged_2.12.svg?label=latest%202.12&style=flat-square)](https://repo1.maven.org/maven2/com/github/fulrich/test-charged_2.12/)
[![Maven Central](https://img.shields.io/nexus/r/https/oss.sonatype.org/com.github.fulrich/test-charged_2.13.svg?label=latest%202.13&style=flat-square)](https://repo1.maven.org/maven2/com/github/fulrich/test-charged_2.13/)

A small library with helpers for generating test data through a simple DSL.

You can super charge water.  You should also super charge your tests.

## Quick Start
The currently released build should be shown on the badges at the top of this README.
Simply add that dependency to your SBT file:

```scala 
libraryDependencies += "com.github.fulrich" %% "test-charged" % "0.1.5"
```

Our SNAPSHOT version is also shown at the badges on the top.  
To use the newest SHAPSHOT you must include the Sonatype resolver and then add the dependency.

```scala
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.github.fulrich" %% "test-charged" % "0.1.6-SNAPSHOT" % "test"
```

## Documentation
See [documentation](docs/README.md)

## Contributing

### Releasing
TestCharged used the ci-release SBT plugin: https://github.com/sbt/sbt-ci-release.

Every push to master that passes CI will release a SNAPSHOT with a unique version number.

To release a new version git tags are utilized:
```
git tag -a v0.1.0 -m "v0.1.0"
git push origin v0.1.0
```
