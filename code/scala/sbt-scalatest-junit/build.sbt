name := "Scalample"                                                    
                                                                               
version := "1.0"                                                       

organization := "org.myproject"                                        

scalaVersion := "2.9.1"   

libraryDependencies ++= Seq(                                                   
    "junit" % "junit" % "4.8" % "test",                                        
    "com.novocode" % "junit-interface" % "0.6" % "test->default",              
    "org.scalatest" % "scalatest_2.9.0" % "1.6.1"                              
)   
