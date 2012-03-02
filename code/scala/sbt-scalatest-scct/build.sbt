name := "TestCoverave"                                                    
                                                                               
version := "1.0"                                                       

organization := "marianoguerra"                                        

scalaVersion := "2.9.1"   

seq(ScctPlugin.scctSettings: _*)

parallelExecution in Test := false

fork in (Test,run) := true

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "Maven2 Repository" at "http://repo2.maven.org/maven2/"

resolvers += "Apache Maven2 Repository" at "http://repo1.maven.org/maven2/"

libraryDependencies ++= Seq(                                                   
    "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test"
)   

