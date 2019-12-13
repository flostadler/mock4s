name := "mock4s"
organization := "de.flostadler"
version := "0.0.1"

scalaVersion := "2.13.1"

lazy val scalaReflect = Def.setting { "org.scala-lang" % "scala-reflect" % scalaVersion.value }
libraryDependencies += scalaReflect.value

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
