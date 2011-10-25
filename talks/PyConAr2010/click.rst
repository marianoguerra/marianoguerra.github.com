click click ...
===============

habia una vez
-------------

* un cliente de MSN
* PARA LINUX
* pero la gente de windows lo queria usar (?)

mal acostumbrando a la gente
----------------------------

* siguiente
* siguiente
* siguiente
* finalizar

porque hacer un instalador
--------------------------

* muchos componentes extras para instalar a mano
* muchos instaladores chiquitos
* dificiles de encontrar
* malabares de versiones
* encontrar la combinacion adecuada de versiones que anda
* instalarlo en el orden adecuado
* rezar
* rezar a otros dioses (por las dudas)
* resultado aleatorio

receta
------

* python
* todas las librarias que uses
* py2exe
* nsis
* paciencia y suerte

ejemplo
-------

* aplicacion gtk
* datos
* exe
* instalador
* version portable

ingredientes
------------

* http://python.org/ftp/python/2.6.6/python-2.6.6.msi
* http://sourceforge.net/projects/py2exe/files/py2exe/0.6.9/py2exe-0.6.9.win32-py2.6.exe/download
* http://code.google.com/p/ossbuild/downloads/detail?name=GStreamer-WinBuilds-GPL-x86.msi&can=2
* http://forja.rediris.es/frs/download.php/1414/Pygst-0.10.15.1-Python26.exe
* http://ftp.gnome.org/pub/GNOME/binaries/win32/pycairo/1.8/pycairo-1.8.6.win32-py2.6.exe
* http://ftp.gnome.org/pub/GNOME/binaries/win32/pygobject/2.20/pygobject-2.20.0.win32-py2.6.exe
* http://ftp.gnome.org/pub/GNOME/binaries/win32/pygtk/2.16/pygtk-2.16.0+glade.win32-py2.6.exe
* http://sourceforge.net/projects/pywin32/files/pywin32/Build%20214/pywin32-214.win32-py2.6.exe/download
* http://sourceforge.net/projects/gtk-win/files/GTK%2B%20Runtime%20Environment/GTK%2B%202.22/gtk2-runtime-2.22.0-2010-10-01-ash.exe/download
* http://sourceforge.net/projects/gtk-win/files/GTK%2B%20Themes%20Package/2009-09-07/gtk2-themes-2009-09-07-ash.exe/download
* http://prdownloads.sourceforge.net/nsis/nsis-2.46-setup.exe?download

no creo en brujas...
--------------------

* python
* gtk-runtime
* gstreamer
* gtk2-themes
* nsis
* pygobject
* pycairo
* pygtk
* pywin32
* py2exe
* pygst

tareas extra
------------

* setear el PATH a X:\Python26\
* probar que ande

::

	>>> import gtk
	>>> w = gtk.Window()
	>>> l = gtk.Label("asd")
	>>> w.add(l)
	>>> w.show_all()
	>>> gtk.main()

pasos
-----

* ejemplo.py
* setup.py
* ejemplo.nsi
* ejemplo-portable.nsi
* dist/
* dll/
* python setup.py py2exe
* compile ejemplo.nsi
* compile ejemplo-portable.nsi
* ???
* profit!

notas
-----

* sacar todos los dll de portable python y ponerlos en dll/
* jpeg62.dll, libjpeg-7.dll from inkscape

.. header::

        click click ... 

.. footer::

        Mariano Guerra, PyConAr 2010

