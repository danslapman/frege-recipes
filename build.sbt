ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / autoScalaLibrary := false

ThisBuild / managedScalaInstance := false

lazy val frege: ModuleID = "org.frege-lang" % "frege" % "3.25.84" from "https://github.com/Frege/frege/releases/download/3.25alpha/frege3.25.84.jar"

lazy val defaultSettings = Seq(
  run / fork := true,
  fregeLibrary := frege,
  fregeOptions ++= Seq(
    "-hints",
    "-ascii",
    "-latin"
  )
)

lazy val okhttp = (project in file("ok-http"))
  .settings(defaultSettings)
  .settings(
    name := "frege-okhttp",
    libraryDependencies ++= Seq(
      "com.squareup.okhttp3" % "okhttp" % "4.10.0"
    )
  )

lazy val deque = (project in file("deque"))
  .settings(defaultSettings)
  .settings(
    name := "deque"
  )

lazy val root = (project in file("."))
  .aggregate(okhttp, deque)
  .settings(
    name := "frege-recipes",
    run / aggregate := false,
    libraryDependencies -= fregeLibrary.value
  )

