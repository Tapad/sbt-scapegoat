import Dependencies._
import Publishing._
import sbtrelease.ReleaseStateTransformations._

name := "sbt-scapegoat"

organization := "com.tapad.sbt"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalaVersion := "2.12.6"

sbtPlugin := true

crossSbtVersions := Seq("0.13.17", "1.1.6")

scalacOptions ++= Seq("-deprecation", "-language:_")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
resolvers ++= Seq(
  Repositories.LocalMaven
)

PublishSettings

publishMavenStyle := true

publishArtifact in Test := false

parallelExecution in Test := false

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  releaseStepCommandAndRemaining("^test"),
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("^publish"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)

sbtrelease.ReleasePlugin.autoImport.releaseCrossBuild := true
