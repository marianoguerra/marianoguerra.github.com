install couchdb 1.1.0 in debian lenny
=====================================

you should have build-essential installed::

        sudo apt-get install build-essential

download and install erlang::

        wget http://www.erlang.org/download/otp_src_R14B04.tar.gz

        # extract
        tar -xzf otp_src_R14B04.tar.gz 
        cd otp_src_R14B04

        # do the compile dance
        ./configure
        make
        sudo make install

install dependencies for couchdb::

        sudo apt-get install libmozjs-dev libicu-dev

download and install couchdb::

        wget http://apache.openmirror.de//couchdb/1.1.0/apache-couchdb-1.1.0.tar.gz
        tar -xzf apache-couchdb-1.1.0.tar.gz
        cd apache-couchdb-1.1.0

        # do the compile dance
        ./configure
        make
        sudo make install

add the init.d script::

        cd /etc/init.d/
        sudo ln -s /usr/local/etc/init.d/couchdb couchdb

create users and set permissions::

        prefix='/usr/local'

        # add couchdb user:
        sudo useradd -d ${prefix}/var/lib/couchdb couchdb

        # correct permissions:
        sudo chown -R couchdb: ${prefix}/var/{lib,log,run}/couchdb ${prefix}/etc/couchdb
        sudo chmod 0770 ${prefix}/var/{lib,log,run}/couchdb ${prefix}/etc/couchdb

start and test::

        sudo /etc/init.d/couchdb start
        curl http://localhost:5984

you should see something like this::

        {"couchdb":"Welcome","version":"1.1.0"}

