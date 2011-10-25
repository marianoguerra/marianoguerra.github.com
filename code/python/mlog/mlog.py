'''helpers for logging, now you don't have excuse to use logging'''

import inspect
import logging
import logging.handlers

SECOND   = SECONDS   = 'S'
MINUTE   = MINUTES   = 'M'
HOUR     = HOURS     = 'H'
DAY      = MIDNIGHT  = MIDNIGHTS = 'midnight'

DEFAULT_FORMAT = '[%(asctime)s] %(name)s %(levelname)s: %(message)s'

def every(interval, when):
    return (interval, when)

def _get_logger(name, logger, handler, level, format):
    if logger is None:
        if name is None:
            name = get_caller_module(3)

        logger = logging.getLogger(name)
        logger.setLevel(logging.DEBUG)

    if format is None:
        format = DEFAULT_FORMAT

    formatter = logging.Formatter(format)

    handler.setLevel(level)
    handler.setFormatter(formatter)
    logger.addHandler(handler)

    return logger

def console(name=None, level=logging.INFO, logger=None, format=None):
    handler = logging.StreamHandler()
    return _get_logger(name, logger, handler, level, format)

def file(path, when=None, name=None, level=logging.DEBUG, logger=None,
        format=None):
    if when is None:
        handler = logging.FileHandler(path)
    else:
        interval, when_type = when
        handler = logging.handlers.TimedRotatingFileHandler(path, when_type, interval)

    return _get_logger(name, logger, handler, level, format)

def get_caller_module(level=2):
    '''
    return the name of the module that called the function that called this
    function, by default it assumes that the function that called this function
    was called from another module, to change this set level to the value
    of nested calls
    '''
    return inspect.getmoduleinfo(inspect.stack()[level][1]).name
