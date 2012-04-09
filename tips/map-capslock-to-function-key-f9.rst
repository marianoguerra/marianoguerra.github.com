map capslock to function key f9
===============================

create file .Xmodmap with the following content::

        remove Lock = Caps_Lock
        keysym Caps_Lock = F9
