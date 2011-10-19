edit static files without reloading jetty in sbt/scala
======================================================

just a link ;)

http://xyzzyxyzzy.net/2011/07/22/sbt10-webplugin-jetty-run-in-place-once-more/

in case it dissapears

        temporaryWarPath <<= (sourceDirectory in Runtime) / "webapp"
        // watch temporaryWarPath / WEB-INF / classes
        jettyScanDirs <<= (temporaryWarPath) { (target) => Seq(target / "WEB-INF" / "classes") }

as the post says, you should add some lines to .gitignore

        src/main/webapp/WEB-INF/lib/*
        src/main/webapp/WEB-INF/classes/*
