python doodles
==============

directory containing small python doodles

mlog
----

am I the only one that uses print instead of logging because I have to go read
the logging documentation every time I want to use it?

am I the only one that even reading the documentation end up copy&pasting code
and feeling dirty?

why do I have to tell explicitly the name of the module if you can find it by yourself?

logging should be there from day one, this is only posible if logging is easy to use

"make simple thing simple and hard things possible"

introduciong mlog (see test_mlog.py for an up to date version)::

        import time
        import mlog

        # create a logger for the console with default logging level, default format
        # and default everything (but nice defaults)
        log = mlog.console()
        # log some stuff
        log.info("hey!")
        log.warn("warning...")
        log.error("something went wrong! (no it didn't just testing log.error)")

        # add a file handler to the logger we where using (see how I pass the logger?)
        # if I don't pass the logger instance I get a brand new logger that is
        # unrelated to the last one, but in this case I add a handler to the one I have
        mlog.file("mlog.log", logger=log)

        # log some more stuff
        log.debug("I'm on a file now!")
        log.info("of course I'm on both")

        # who wants file loggers without rotation?
        # I give you a nice notation to specify the rotation policy
        # add this handler to the logger I already have
        mlog.file("every-minute.log", when=mlog.every(1, mlog.MINUTE), logger=log)

        log.info("im on a file that rotates every minute")

        # give time so it rotates
        time.sleep(65)

        log.info("65 seconds passed!")

        # this is a new logger not related with the others
        # change the module name so it's not in the same hierarchy
        # as the other ones
        other_log = mlog.file("unrelated.log", name="test_mlog_1")

        # log something
        other_log.info("unrelated logger is unrelated")

running it produces the following output (and files)::

        $ python test_mlog.py 
        [2011-08-12 11:44:30,491] test_mlog INFO: hey!
        [2011-08-12 11:44:30,491] test_mlog WARNING: warning...
        [2011-08-12 11:44:30,491] test_mlog ERROR: something went wrong! (no it didn't just testing log.error)
        [2011-08-12 11:44:30,492] test_mlog INFO: of course I'm on both
        [2011-08-12 11:44:30,492] test_mlog INFO: im on a file that rotates every minute
        [2011-08-12 11:45:35,491] test_mlog INFO: 65 seconds passed!

        $ ls
        README.rst                              mlog.log                                test_mlog.py
        every-minute.log                        mlog.py                                 unrelated.log
        every-minute.log.2011-08-12_11-44       mlog.pyc

        $ cat mlog.log 
        [2011-08-12 11:44:30,491] test_mlog DEBUG: I'm on a file now!
        [2011-08-12 11:44:30,492] test_mlog INFO: of course I'm on both
        [2011-08-12 11:44:30,492] test_mlog INFO: im on a file that rotates every minute
        [2011-08-12 11:45:35,491] test_mlog INFO: 65 seconds passed!

        $ cat every-minute.log
        [2011-08-12 11:45:35,491] test_mlog INFO: 65 seconds passed!

        $ cat every-minute.log.2011-08-12_11-44 
        [2011-08-12 11:44:30,492] test_mlog INFO: im on a file that rotates every minute

        $ cat unrelated.log 
        [2011-08-12 11:45:35,495] test_mlog_1 INFO: unrelated logger is unrelated

