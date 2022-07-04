ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / autoScalaLibrary := false

ThisBuild / managedScalaInstance := false

lazy val okhttp = (project in file("ok-http"))
  .settings(
    name := "frege-okhttp",
    run / fork := true,
    libraryDependencies ++= Seq(
      "com.squareup.okhttp3" % "okhttp" % "4.10.0"
    )
  )

lazy val root = (project in file("."))
  .aggregate(okhttp)
  .settings(
    name := "frege-recipes",
    run / aggregate := false
  )

