rebar fix
=========

let's create a simple erlang module using rebar::

        # create module folder
        mkdir modulo

        # go to it
        cd modulo

        # download and set it to executable
        wget http://cloud.github.com/downloads/basho/rebar/rebar && chmod u+x rebar

        # create the module skeleton
        ./rebar create template=simplemod modid=modulo

now let's try to compile it::

        ➜  modulo  ./rebar compile
        ==> modulo (compile)
        ➜  modulo  tree
        .
        ├── rebar
        ├── src
        │   └── modulo.erl
        └── test
            └── modulo_tests.erl

            2 directories, 3 files

nothing happened :(

it seems something is missing, let's add the app.src file::

        ➜  modulo  vim src/modulo.app.src 
        ➜  modulo  cat src/modulo.app.src 
        {application, modulo, [
          {description, "super useful module."},
          {vsn, "0.0.1"},
          {env, []}
        ]}.

and try again::

        ➜  modulo  ./rebar compile                                 
        ==> modulo (compile)
        Compiled src/modulo.erl
        ➜  modulo  tree           
        .
        ├── ebin
        │   ├── modulo.app
        │   └── modulo.beam
        ├── rebar
        ├── src
        │   ├── modulo.app.src
        │   └── modulo.erl
        └── test
            └── modulo_tests.erl

        3 directories, 6 files

success!

then the simplemod template needs the app.src file to be complete.

let's try fixing that, first fork rebar from github.com/basho/rebar.

then clone it::

        git clone git@github.com:marianoguerra/rebar.git

        cd rebar

let's see where the templates are::

        ➜  rebar git:(master) find -name simplemod\*
        ./priv/templates/simplemod_tests.erl
        ./priv/templates/simplemod.erl
        ./priv/templates/simplemod.template

        ➜  rebar git:(master) cd priv/templates

now let's be a nice git citizen and create a branch for this fix::

        git checkout -b simplemod-app-src-missing

looking at the other templates they have a file like **simpleapp.app.src**

where simpleapp is the name of the template.

looking at the content::

        {application, {{appid}},
         [
          {description, ""},
          {vsn, "1"},
          {registered, []},
          {applications, [
                          kernel,
                          stdlib
                         ]},
          {mod, { {{appid}}_app, []}},
          {env, []}
         ]}.

seems to be a template were appid is the variable to be replaced, let's try
with that::

        # copy the file
        cp simpleapp.app.src simplemod.app.src
        # some sed spells
        sed -i 's/appid/modid/g' simplemod.app.src 

let's see the content with **cat simplemod.app.src**::

        {application, {{modid}},
         [
          {description, ""},
          {vsn, "1"},
          {registered, []},
          {applications, [
                          kernel,
                          stdlib
                         ]},
          {mod, { {{modid}}_app, []}},
          {env, []}
         ]}.

and add the new file to the template definition::

        echo '{template, "simplemod.app.src", "src/{{modid}}.app.src"}.' >> simplemod.template                                              

and see the new content::

        cat simplemod.template 

        {variables, [{modid, "mymod"}]}.
        {template, "simplemod.erl", "src/{{modid}}.erl"}.
        {template, "simplemod_tests.erl", "test/{{modid}}_tests.erl"}.
        {template, "simplemod.app.src", "src/{{modid}}.app.src"}.

let's build the new version (inside the base rebar folder)::

        ./bootstrap

now let's try our new version::

        mkdir /tmp/modulo
        cp rebar /tmp/modulo 
        cd /tmp/modulo 

        ./rebar create template=simplemod modid=modulo                                        

        ==> modulo (create)
        Writing src/modulo.erl
        Writing test/modulo_tests.erl
        Writing src/modulo.app.src

        ➜  modulo  ./rebar compile
        ==> modulo (compile)
        Compiled src/modulo.erl

        ➜  modulo  tree
        .
        ├── ebin
        │   ├── modulo.app
        │   └── modulo.beam
        ├── rebar
        ├── src
        │   ├── modulo.app.src
        │   └── modulo.erl
        └── test
            └── modulo_tests.erl

        3 directories, 6 files
                
success!

commit::

        git add priv/templates/simplemod.app.src
        git add priv/templates/simplemod.template
        git commit

push our new branch to github::

        git push origin simplemod-app-src-missing

and do the pull request on github::

        https://github.com/basho/rebar/pull/201

