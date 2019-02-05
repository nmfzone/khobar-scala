name := """KhobarAPI"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
//  jdbc, // only use it when you're not using Slick.
  ws,
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,
  "com.typesafe.play" %% "play-json" % "2.6.10",
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "com.h2database" % "h2" % "1.4.197",
  "mysql" % "mysql-connector-java" % "8.0.15",
  "io.lemonlabs" %% "scala-uri" % "1.4.0"
)
