Java.lang.OutOfMemoryError: PermGen space while running sbt or scala
====================================================================

I have a Jenkins installation that builds a java/scala project build with sbt
in the test target using scala test I tend to get this error.

to fix it I passed the following options to the JVM::

        -XX:+CMSClassUnloadingEnabled -Xmx1000M -XX:MaxPermSize=256M

change 1000M and 256M for any number that makes sense for you

related:

 * http://wiki.caucho.com/Java.lang.OutOfMemoryError:_PermGen_space
 * http://stackoverflow.com/questions/88235/how-to-deal-with-java-lang-outofmemoryerror-permgen-space-error
