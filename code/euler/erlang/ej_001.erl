-module(ej_001).
-export([calculate/0, print_result/0]).

calculate() -> lists:sum([X || X <- lists:seq(0, 1000), X rem 3 == 0 orelse X rem 5 == 0]).

print_result() -> io:format("~w~n", [calculate()]).
