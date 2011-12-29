rhino gotchas
=============

EcmaError : TypeError: Cannot find default value for object
-----------------------------------------------------------

you need to create Arrays and Objects using the context and scope you use
to run the scripts, not with new NativeArray or with another scope::

        ctx.newObject(scope)
        ctx.newArray(scope, arrayOfObjects)
