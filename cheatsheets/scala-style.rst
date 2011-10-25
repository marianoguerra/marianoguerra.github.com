* two spaces indentation
* prefer vals
* prefer inmutable data structures
* isolate side effects, write as much side effect free code as possible
* try to avoid whiles/fors when a more functional way is available
* put braces all the time except for one liners like val a = if (b > c) b else c
* one expression per line
* no semicolons (read and understand semicolon insertion rules)
* use parenthesis in expression to clarify precedence
* no dot no parenthesis for single argument methods
* specify return types
* write for readability
* short methods
* use descriptive names
* avoid abbreviated names, use full names
* split an expression with the operator at the end of the line
* don't abuse DSLs
* understand map, filter, foldl, foldr, forall, foreach and use them
* only use the Application trait for simple scripts and single threaded apps
* use parenthesis on methods without argument only if they produce a side effect or interesting computation
* know the rich wrappers for each basic type
* don't abuse implicits and opeator methods in cases where it's not clear what they do
* don't return values in a finally block (PiS p. 128)
* block expressions return values, use them instead of temp vars
