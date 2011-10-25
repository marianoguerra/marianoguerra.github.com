functions
=========

* def name(arg1: Type, arg2: Type): ResultType => <body> // long function definition
* def name(arg1: Type, arg2: Type) { <body> } // procedure (returns Unit, highlight that it's done for the side effect)
* (arg1: Type, arg2: Type) => <body> // literal function definition
* arg => <body> // short literal function definition
* println // currying

* implicit def name(arg) = <conversion> // implicit declaration

expressions
===========

* for (arg <- args) <body>
* for (arg <- args if <cond>) <body>
* for (arg <- args if <cond>; arg1 <- args1 if <cond1>) <body> // nested for with filters
* for {arg <- args if <cond>; someval = something; arg1 <- args1 if <cond1>} <body> // nested for with filters, assignment and curly brackets
* while (<cond>) <body>
* try { <body> } catch { case ex: ExType => <body>; case ex: ExType1 => <body1> } finally <finallyBlock>
* match { case <val> => <body>; ... ; case _ => <defaultBody> } // no breaks, no fall through

tricks
======

* 1 to 10 // range
* 1 to 10 by 2 // range with step
* 1 until 10
* a -> b // build a two item tuple (a, b), works for all types
* unary\_ defines prefix operators (only +, -, ! and ~)
* throw expression "returns" Nothing (can be used in expressions)

class/object
============

* def this(<args>) <body> // auxiliary contructors, call the another constructor as first action
* class Child(s: String) extends Father(s) // call Father constructor passing "s"
* class Thing(override? [protected|private]? [var|val]? name: String) // define a field in the parameter list


low level
=========

* foo(bar) // foo.apply(bar)
* foo(bar) = baz // foo.update(bar, baz)
* val arr = Array(1, 2, 3) // val arr = Array.apply(1, 2, 3)
* (1, "asd") -> Tuple2[Int, String]
* fields and methods belong to the same namespace, a field can override a parameterless method
* namespaces: values (fields, methods, packages, singleton objs) and types (class and trait names)

types
=====

* Array[T] // mutable array
* List[T] // inmutable list
* 'symbol // atom, Symbol("symbol")
* """raw string""" // raw string, can span multiple lines, contain quotes @see stripMargin

operations
==========

* List(1, 2) ::: List(3, 4) // list concatenation (append, add, push)
* 1 :: List(2, 3) // list cons (prepend)
* 1 :: 2 :: 3 :: Nil // prepend to Nil (the empty List) the the values
* list.count(s => s.length > 4) // count items whose size is > 4
* list.drop(2) // remove first 2 elements
* list.dropRight(2) // remove last 2 elements
* list.exists(<pred>) // return true if pred is true for a value
* list.filter(<pred>) // keep the items that make pred return true
* list.forall(<pred>) // true if pred is true for all items
* list.foreach(<fun>) // execute fun for each item
* list.head // first element
* list.tail
* list.init // all but last
* list.isEmpty
* list.last
* list.length
* list.map
* list.mkString(", ") // return a string joining with ", "
* list.remove(<pred>) // remove the ones where pred returs true
* list.reverse
* list.sort(<comp>)

* val pair = (42, "asd"); pair._1; pair._2 // tuple creation and access (1 based)

* set.contains(<val>)

* var map = Map(1 -> "I", 2 -> "II"); map += (3 -> "III")

gotchas
=======

* gotcha: function definitions without the equal sign return Unit
* gotcha: x\n+ y -> x; +y;, the correct way is (x\n+ y) or x +\ny
* gotcha: operators ending with = that are not comparison have the same precedense as assignment (i.e \*=)
* gotcha: operators ending with : are called in the object of the right
* gotcha: no matter the associativity, operands are always evaluated from left to right
* gotcha: scala doesn't infer semicolons while inside parenthesis
