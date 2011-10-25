OutOfMemoryError PermGen Space in tomcat
========================================

add::

        -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256M

to JAVA_OPTS in bin/catalina.sh
