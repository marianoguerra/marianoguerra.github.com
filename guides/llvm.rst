llvm
====

::

        vim hello.c
        clang -O3 -emit-llvm -S hello.c -o hello.ll
        llvm-as-2.9 hello.ll -o hello.bc
        lli-2.9 hello.bc

