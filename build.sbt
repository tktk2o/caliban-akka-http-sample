name := "caliban-akka-http-sample"

version := "0.1"

scalaVersion := "2.13.5"

val CalibanVersion       = "0.9.5"
val CirceVersion         = "0.12.3"
val AkkaVersion          = "2.6.12"
val AkkaHttpCirceVersion = "1.35.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka"     %% "akka-actor-typed"  % AkkaVersion,
  "com.github.ghostdogpr" %% "caliban"           % CalibanVersion,
  "com.github.ghostdogpr" %% "caliban-akka-http" % CalibanVersion,
  "com.github.ghostdogpr" %% "caliban-tools"     % CalibanVersion,
  "de.heikoseeberger"     %% "akka-http-circe"   % AkkaHttpCirceVersion
)

enablePlugins(CodegenPlugin)
