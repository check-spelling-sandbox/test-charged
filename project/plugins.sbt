ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
)

// Code Coverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.3.0")

// Deployment
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.9.2")

// Documentation
addSbtPlugin("com.47deg" % "sbt-microsites" % "1.4.4")
