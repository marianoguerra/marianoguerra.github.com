-module(ej_005).
-export([first_multiple_from_1_to_20/0]).

is_multiple_from_11_to_18(_Value, 10) -> true;
is_multiple_from_11_to_18(Value, Number) ->
  case Value rem Number == 0 of
    true -> is_multiple_from_11_to_18(Value, Number - 1);
    false -> false
  end.

is_multiple_from_11_to_18(Value) -> is_multiple_from_11_to_18(Value, 18).

first_multiple_from_1_to_20(Count) ->
  case is_multiple_from_11_to_18(Count) of
    true -> Count;
    false -> first_multiple_from_1_to_20(Count + 380)
  end.

first_multiple_from_1_to_20() -> first_multiple_from_1_to_20(380).

