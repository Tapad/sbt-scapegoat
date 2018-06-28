import sbt._
import sbt.Keys._
import Repositories._

object Publishing {

  val PublishSettings = Seq(
    pomIncludeRepository := { _ => false },
    publishArtifact in Test := false,
    publishArtifact in (Compile, packageDoc) := false,
    publishArtifact in (Compile, packageSrc) := true,
    publishMavenStyle := true,
    publishTo := {
      if (version.value.endsWith("SNAPSHOT")) Some(TapadSnapshots) else Some(TapadReleases)
    },
    homepage := Some(new URL("https://github.com/haavardw/sbt-scapegoat")),
    developers := List(
      Developer(
        id = "haavardw",
        name = "Håvard Wall",
        email = "havard.wall@tapad.com",
        url = url("http://github.com/haavardw")
      )
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/haavardw/sbt-scapegoat"),
        "scm:git:git://github.com/haavardw/sbt-scapegoat.git"
      )
    )
  )
}