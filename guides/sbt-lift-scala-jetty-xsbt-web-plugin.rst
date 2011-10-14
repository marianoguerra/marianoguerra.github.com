lift 2.4-M4, scala 2.9.1, sbt 0.11.0-RC0, jetty 7.3 and xsbt-web-plugin 0.1.1
=============================================================================

installing sbt 0.11.0-RC0
=========================

run the following commands::

        # go to your home directory
        cd

        # create a bin folder there (if you don't have it yet)
        mkdir bin

        # download the latest sbt
        wget http://repo.typesafe.com/typesafe/ivy-snapshots/org.scala-tools.sbt/sbt-launch/0.11.0-RC1/sbt-launch.jar

now we need to create a launcher for sbt, create a file called sbt in the bin
directory you just created and put the following inside::

        java -Xmx512M -jar `dirname $0`/sbt-launch.jar "$@"

now run the following commands::

        # give execution permissions to the file
        chmod u+x sbt

if you don't have $HOME/bin in your path variable you should add it, for this
do the following::

        # open $HOME/.bashrc in your favorite text editor
        vim $HOME/.bashrc

and add the following line at the end of it::

        export PATH=$PATH:$HOME/bin

save and close and run the shell again so it loads the new definitions::

        bash

you can check that the path was updated by running::

        echo $PATH

you should see something similar to this::

        /sbin:/bin:/usr/sbin:/usr/bin:/home/test/bin

see that the last one is $HOME/bin (with $HOME expanded to my current home
location)

installing scala 2.9.1
======================

if your operating system has this in the package manager then install it from
there but since the release is new and some distributions are a little behing
we will install it from the download section of the scala site.

run the following commands::

        # download the latest version of scala
        wget http://www.scala-lang.org/downloads/distrib/files/scala-2.9.1.final.tgz

        # unpack it
        tar -xzf scala-2.9.1.final.tgz

        # move the folder to the standard place
        sudo mv scala-2.9.1.final /usr/share/scala

        # create links so the commands are visible
        sudo ln -s /usr/share/scala/bin/scala /usr/bin/scala                           
        sudo ln -s /usr/share/scala/bin/scalac /usr/bin/scalac                         
        sudo ln -s /usr/share/scala/bin/fsc /usr/bin/fsc                               
        sudo ln -s /usr/share/scala/bin/sbaz /usr/bin/sbaz                             
        sudo ln -s /usr/share/scala/bin/sbaz-setup /usr/bin/sbaz-setup                 
        sudo ln -s /usr/share/scala/bin/scaladoc /usr/bin/scaladoc                     
        sudo ln -s /usr/share/scala/bin/scalap /usr/bin/scalap

installing the rest
===================

first create the project folder and setup the structure::

	# define the name of the project
	PROJNAME=demo

	# create the direcotry where our project will be
	mkdir $PROJNAME

	# get the latest lift with sbt support
	wget https://nodeload.github.com/lift/lift_24_sbt/tarball/master

	# extract lift
	tar -xzf master

        # remove the downloaded file
        rm master

	# copy the basic example to our project directory
	cp -r lift-lift_24_sbt-*/scala_29/lift_basic/* $PROJNAME

        # move to our project folder
        cd $PROJNAME

	# remove older sbt versions
	rm sbt sbt.bat sbt-launcher.jar

	# remove the project structure
	rm -r project/

	# create the new project structure
	mkdir -p project/project

the change in the project directory structure is because it changed in
sbt 0.11, see more about this here:

https://groups.google.com/forum/#!searchin/simple-build-tool/plugins/simple-build-tool/ep_63fA_Gzk/32xiPzGkCqAJ

create a file at $PROJNAME/build.sbt::

        vim build.sbt

with the following content::

        seq(webSettings :_*)

        scalaVersion := "2.9.1"

        libraryDependencies ++= Seq(
                "net.liftweb" %% "lift-webkit" % "2.4-M4" % "compile",
                "net.liftweb" %% "lift-mapper" % "2.4-M4" % "compile",
                "org.eclipse.jetty" % "jetty-webapp" % "7.5.1.v20110908" % "jetty",
                "junit" % "junit" % "4.8" % "test",
                "ch.qos.logback" % "logback-classic" % "0.9.26",
                "org.scala-tools.testing" %% "specs" % "1.6.9" % "test",
                "com.h2database" % "h2" % "1.3.160"
        )

create a file at $PROJNAME/project/plugins.sbt::

        vim project/plugins.sbt

with the following content::

	resolvers ++= Seq(
		"Web plugin repo" at "http://siasia.github.com/maven2",
		Resolver.url("Typesafe repository", new java.net.URL("http://typesafe.artifactoryonline.com/typesafe/ivy-releases/"))(Resolver.defaultIvyPatterns)
	)

	addSbtPlugin("com.github.siasia" % "xsbt-web-plugin" % "0.1.1")


now run::

        sbt

when you get to the console write::

        jetty-run

note that the first time it will take a while, that's because it's downloading
lot of stuff and compiling some other things, after the first run everything
becomes faster.

after a moment some information will appear, after that navigate to::

        http://localhost:8080

and play with the app.

generating a war file to deploy in web containers
=================================================

just run::

        sbt package-war

to test you can run::

        sbt test

note that the new version of jetty changed namespace from org.mortbay.* to
org.eclipse.* so some code may be broken.

some extra packages
===================

here are some other packages you may want to have, copy the lines your are
interested in and add them to $PROJNAME/build.sbt::

        libraryDependencies ++= Seq(                                                   
            "com.novocode" % "junit-interface" % "0.6" % "test->default",              
            "org.scalatest" % "scalatest_2.9.0" % "1.6.1",
            "com.sun.jersey" % "jersey-server" % "1.9",
            "com.sun.jersey" % "jersey-client" % "1.9",
            "com.sun.jersey" % "jersey-core" % "1.9",
            "com.sun.jersey" % "jersey-json" % "1.9",
            "javax.ws.rs" % "jsr311-api" % "1.1.1",
            "javax.xml.bind" % "jaxb-api" % "2.2"
        )   
