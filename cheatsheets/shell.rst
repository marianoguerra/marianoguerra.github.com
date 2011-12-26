
vars
====

* $1 - $9       these variables are the positional parameters.
* $0            the name of the command currently being executed.
* $#            the number of positional arguments given to this invocation of the shell.
* $?            the exit status of the last command executed is
* $$            the process number of this shell - useful for including in filenames, to make them unique.
* $!            the process id of the last command run in the background.
* $-            the current options supplied to this invocation of the shell.
* $*            a string containing all the arguments to the shell, starting at $1.
* $@            same as above, except when quoted.

operations
==========

* slice args ${@:2}
* if [ $var -eq something ]; then command; elif [ $var -ne something ]; command; else command; fi
* for $var in something; do command; done

shortcuts
=========

control-A move to start of current paragraph
control-B move left one character
control-D forwards delete
control-E move to end of current paragraph
control-F move right one character
control-H delete
control-K delete remainder of current paragraph
control-N move down one line
control-O insert new line after cursor
control-P move up one line
control-T transpose (swap) two surrounding character
control-V move to end, then left one character
control-Y paste text previously deleted with control-K
