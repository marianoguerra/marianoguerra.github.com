-module(ej_006).
-export([show/0]).

do_to_range(Stop, Stop, Accum, Fun) -> Accum + Fun(Stop);
do_to_range(Start, Stop, Accum, Fun) ->
	do_to_range(Start + 1, Stop, Accum + Fun(Start), Fun).

show() ->
	SumOfSquares = do_to_range(1, 100, 0, fun(X) -> X * X end),
	SquareOfSums = math:pow(do_to_range(1, 100, 0, fun(X) -> X end), 2),
	SquareOfSums - SumOfSquares.

