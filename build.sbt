ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / autoScalaLibrary := false

ThisBuild / managedScalaInstance := false

lazy val root = (project in file("."))
  .settings(
    name := "frege-recipes",
    run / fork := true,
    libraryDependencies ++= Seq(
      "com.squareup.okhttp3" % "okhttp" % "4.10.0"
    )
  )
