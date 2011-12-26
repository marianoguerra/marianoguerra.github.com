sed tips
========

search and replace recursive
----------------------------

::

        find . -name '<regx>' -type f -print0 | xargs -0 sed -i 's/original/replace/g'
