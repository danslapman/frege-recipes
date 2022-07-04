ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / autoScalaLibrary := false

ThisBuild / managedScalaInstance := false

lazy val okhttp = (project in file("ok-http"))
  .settings(
    name := "frege-okhttp",
    run / fork := true,
    libraryDependencies ++= Seq(
      "com.squareup.okhttp3" % "okhttp" % "4.10.0"
    ),
    fregeLibrary := "org.frege-lang" % "frege" % "3.25.84" from "https://github.com/Frege/frege/releases/download/3.25alpha/frege3.25.84.jar",
    fregeOptions ++= Seq(
      "-hints",
      "-ascii",
      "-latin"
    )
  )

lazy val root = (project in file("."))
  .aggregate(okhttp)
  .settings(
    name := "frege-recipes",
    run / aggregate := false,
    libraryDependencies -= fregeLibrary.value
  )

