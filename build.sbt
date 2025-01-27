name := "Test Charged"

inThisBuild(
  List(
    organization := "com.github.fulrich",
    homepage := Some(url("https://github.com/garnercorp/test-charged")),
    licenses := List(
      "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
    ),
    scalaVersion := "3.6.2",
    crossScalaVersions := Seq("2.12.20", "2.13.15", "3.6.2"),
    developers := List(
      Developer(
        "vmandrychenko",
        "vmandrychenko",
        "4511527+vmandrychenko@users.noreply.github.com",
        url("https://github.com/vmandrychenko")
      ),
      Developer(
        "fulrich",
        "fulrich",
        "9284621+fulrich@users.noreply.github.com",
        url("https://github.com/fulrich")
      )
    ),
    libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always",
  )
)

// Dependencies
val ScalacticVersion = "3.2.19"
val ScalaCheckVersion = "1.18.1"
val ScalaCheckPlusVersion = "3.2.19.0"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % ScalaCheckVersion,
  "org.scalactic" %% "scalactic" % ScalacticVersion,
  "org.scalatest" %% "scalatest" % ScalacticVersion % Test,
  "org.scalatestplus" %% "scalacheck-1-18" % ScalaCheckPlusVersion % Test
)

// Documentation
lazy val micrositeSettings = Seq(
  micrositeName := "Test Charged",
  micrositeDescription := "Supercharge your testing",
  micrositeBaseUrl := "/test-charged",
  micrositeDocumentationUrl := "/test-charged/docs",
  micrositeAuthor := "garnercorp",
  micrositeHomepage := "https://garnercorp.github.io/test-charged/",
  micrositeGithubOwner := "garnercorp",
  micrositeGithubRepo := "test-charged",
  micrositeHighlightTheme := "darcula",
  micrositeGithubToken := sys.env.get("GITHUB_TOKEN"),
  micrositePushSiteWith := GitHub4s,
  micrositeGitterChannel := false,
  micrositeShareOnSocial := false,
  micrositeFooterText := None
)

lazy val root = project in file(".")

lazy val docs = (project in file("docs"))
  .enablePlugins(MicrositesPlugin)
  .settings(publishArtifact := false)
  .settings(micrositeSettings)

// Publishing
publishConfiguration := publishConfiguration.value.withOverwrite(true)
publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true)
