-module(ej_003).
-compile(export_all).

factors(Factor, _Value, Limit, Accum) when Factor > Limit -> lists:reverse(Accum);
factors(Factor, Value, Limit, Accum) when Value rem Factor == 0 ->
  factors(Factor + 1, trunc(Value/Factor), Limit, [Factor | Accum]);
factors(Factor, Value, Limit, Accum) ->
  factors(Factor + 1, Value, Limit, Accum).

factors(Value) -> factors(2, Value, trunc(math:sqrt(Value)), []).

print_results() ->
  Factors = factors(600851475143),
  io:format("~w~n", [Factors]),
  if
    length(Factors) > 0 -> io:format("~w~n", ([lists:last(Factors)]));
    true -> io:format("No factor~n")
  end.

