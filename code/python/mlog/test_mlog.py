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
