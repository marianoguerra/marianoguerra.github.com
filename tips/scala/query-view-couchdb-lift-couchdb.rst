query a view in couchdb with lift-couchdb
=========================================

it was hard for me to find how to query a view from couchdb using lift-couchdb
so here is an example::

        > [mariano@ganesha project]$ sbt console
        [info] Starting scala interpreter...
        [info]
        Welcome to Scala version 2.9.1.final (OpenJDK Server VM, Java 1.6.0_22).
        Type in expressions to have them evaluated.
        Type :help for more information.

        scala> import net.liftweb.couchdb.{CouchDB, Database}
        import net.liftweb.couchdb.{CouchDB, Database}

        scala> val hostname = "localhost"
        hostname: java.lang.String = localhost

        scala> val port = 5984
        port: Int = 5984

        scala> val username = "username"
        username: java.lang.String = username 

        scala> val password = "secret"
        password: java.lang.String = secret

        scala> import dispatch.{Http, StatusCode, :/}
        import dispatch.{Http, StatusCode, $colon$div}

        scala> val req = :/(hostname, port).as(username, password)
        req: dispatch.Request = dispatch.Request@186780d

        scala> val databaseName = "dbname"
        databaseName: java.lang.String = dbname

        scala> val db = new Database(req, databaseName)
        db: net.liftweb.couchdb.Database = net.liftweb.couchdb.Database@1ddb605

        scala> db.design("designname").view("viewnname") query
        res1: dispatch.Handler[net.liftweb.common.Box[net.liftweb.couchdb.QueryResults]] = Handler(net.liftweb.couchdb.Design$$anon$3@1160709,<function3>)

        scala> val http = new Http()
        http: dispatch.Http = dispatch.Http@5aa997

        scala> http(db.design("designname").view("viewnname") query)
        INF: [console logger] dispatch: GET http://localhost:5984/dbname/_design/designname/_view/viewnname
        res3: http.HttpPackage[net.liftweb.common.Box[net.liftweb.couchdb.QueryResults]] = Full(QueryResults(Full(5109),Full(0),ArrayBuffer(...)

        scala>
