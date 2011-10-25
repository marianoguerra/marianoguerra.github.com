sbt 0.10.1 scala 2.9.1 scalatest 1.6.1 and junit 4.8 example
============================================================

quickstart
----------

create project folder::

        PROJNAME=scalample
        mkdir $PROJNAME
        cd $PROJNAME

create directory structure::

        for dir in main test; do for subdir in resources scala java; do mkdir -p src/$dir/$subdir; done; done

see the project structure::

        tree

        .
        └── src
            ├── main
            │   ├── java
            │   ├── resources
            │   └── scala
            └── test
                ├── java
                ├── resources
                └── scala

        9 directories, 0 files

configure
---------

create a file called build.sbt in the base of the project with the following
content::

        name := "Scalample"

        version := "1.0"

        organization := "org.myproject"

        scalaVersion := "2.9.1"


run sbt so it fetches all the resources::

        sbt

exit with Ctrl + d

coding something
----------------

create a file in src/main/scala/Adder.scala with the following content::

        package org.myproject

        class Adder {
          def add(a: Int, b: Int): Int = {
            a + b
          }
        }

create a file in src/main/java/Muler.java with the following content::

        package org.myproject;

        public class Muler {
            public int mul(int a, int b) {
              return a * b;
            }
        }

create a file in src/main/scala/Scalample.scala with the following content::

        package org.myproject

        object Scalample {
          def main(args: Array[String]) {
            val adder = new Adder
            val muler = new Muler

            println("adder: 2 + 3 = " + adder.add(2, 3))
            println("muler: 2 * 3 = " + muler.mul(2, 3))
          }
        }

running
-------

now run::

        sbt run

you should see something like::

        [info] Set current project to default-de9592 (in build file:/home/mariano/tmp/proj2/)
        [info] Updating {file:/home/mariano/tmp/proj2/}default-de9592...
        [info] Done updating.
        [info] Compiling 2 Scala sources and 1 Java source to /home/mariano/tmp/proj2/target/scala-2.9.1.final/classes...
        [info] Running org.myproject.Scalample 
        adder: 2 + 3 = 5
        muler: 2 * 3 = 6
        [success] Total time: 6 s, completed Sep 20, 2011 12:45:12 PM


testing
-------

add the following to the build.sbt file at the end::

        libraryDependencies ++= Seq(                                                   
            "junit" % "junit" % "4.8" % "test",                                        
            "com.novocode" % "junit-interface" % "0.6" % "test->default",              
            "org.scalatest" % "scalatest_2.9.0" % "1.6.1"                              
        )     

this will specify the dependencies we need to test

now create a file in src/test/scala/AdderSpec.scala with the following
content::

        package org.myproject

        import org.scalatest.FlatSpec
        import org.scalatest.matchers.ShouldMatchers

        class AdderSpec extends FlatSpec with ShouldMatchers {

          "adder" should "add 2 + 3 to 5" in {
            val adder = new Adder
            adder.add(2, 3) should equal (5)
          }
        }

now run::

        sbt test

you should see something like::

        [info] Set current project to default-de9592 (in build file:/home/mariano/tmp/proj2/)
        [info] Updating {file:/home/mariano/tmp/proj2/}default-de9592...
        [info] Done updating.
        [info] Compiling 1 Scala source to /home/mariano/tmp/proj2/target/scala-2.9.1.final/test-classes...
        [info] AdderSpec:
        [info] adder 
        [info] - should add 2 + 3 to 5
        [info] Passed: : Total 1, Failed 0, Errors 0, Passed 1, Skipped 0
        [success] Total time: 12 s, completed Sep 20, 2011 12:46:54 PM

now let's test the java class both in scala and java.

create a file in src/test/scala/MulerSpec.scala with the following content::

        package org.myproject

        import org.scalatest.FlatSpec
        import org.scalatest.matchers.ShouldMatchers

        class MulerSpec extends FlatSpec with ShouldMatchers {

          "muler" should "multiply 2 * 3 to 6" in {
            val muler = new Muler
            muler.mul(2, 3) should equal (6)
          }
        }

now run the tests again::

        sbt test


you should see something like::

        [info] Set current project to default-de9592 (in build file:/home/mariano/tmp/proj2/)
        [info] Compiling 1 Scala source to /home/mariano/tmp/proj2/target/scala-2.9.1.final/test-classes...
        [info] AdderSpec:
        [info] adder 
        [info] - should add 2 + 3 to 5
        [info] MulerSpec:
        [info] muler 
        [info] - should multiply 2 * 3 to 6
        [info] Passed: : Total 2, Failed 0, Errors 0, Passed 2, Skipped 0
        [success] Total time: 21 s, completed Sep 20, 2011 12:48:38 PM

now let's test the java class with a java junit test case.

create a file in src/test/java/TestMul.java with the following content::

        package org.myproject;

        import org.junit.Test;

        import junit.framework.Assert;
        import junit.framework.TestCase;

        public class TestMul extends TestCase {
                @Test
                public void testMul() {
                        Muler muler = new Muler();
                        System.out.println("testing from junit in java");
                        Assert.assertEquals(6, muler.mul(2, 3));
                }
        }

run the tests again::

        [info] Set current project to default-de9592 (in build file:/home/mariano/tmp/proj2/)
        [info] Compiling 1 Java source to /home/mariano/tmp/proj2/target/scala-2.9.1.final/test-classes...

        testing from junit in java

        [info] MulerSpec:
        [info] muler 
        [info] - should multiply 2 * 3 to 6
        [info] AdderSpec:
        [info] adder 
        [info] - should add 2 + 3 to 5
        [info] Passed: : Total 3, Failed 0, Errors 0, Passed 3, Skipped 0
        [success] Total time: 3 s, completed Sep 20, 2011 12:50:54 PM


building jar
------------

build jar by running::

        $ sbt package

        [info] Set current project to default-1c9935 (in build file:/home/mariano/dev/examples/scala/sbt-scalatest-junit/)
        [info] Packaging /home/mariano/dev/examples/scala/sbt-scalatest-junit/target/scala-2.9.1.final/scalample_2.9.1-1.0.jar ...
        [info] Done packaging.
        [success] Total time: 1 s, completed Sep 20, 2011 1:08:54 PM


run::

        $ scala target/scala-2.9.1.final/scalample_2.9.1-1.0.jar 

        adder: 2 + 3 = 5
        muler: 2 * 3 = 6

