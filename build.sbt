lazy val root = project in file(".")

scalaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "test"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
