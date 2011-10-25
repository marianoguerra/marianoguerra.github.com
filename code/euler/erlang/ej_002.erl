-module(ej_002).
-compile(export_all).
%-export([calculate/1, print_result/0]).

fibonacci_step(First, Second) -> {Second, First + Second}.

calculate(First, Second, Limit) -> calculate(First, Second, Limit, 0).

calculate(_First, Second, Limit, Accum) when Second > Limit -> Accum;
calculate(First, Second, Limit, Accum) ->
  {NewFirst, NewSecond} = fibonacci_step(First, Second),

  case NewSecond rem 2 of
    0 -> NewAccum = Accum + NewSecond;
    1 -> NewAccum = Accum
  end,

  calculate(NewFirst, NewSecond, Limit, NewAccum).

calculate(Limit) -> calculate(0, 1, Limit).

print_result() -> io:format("~w~n", [calculate(4000000)]).

