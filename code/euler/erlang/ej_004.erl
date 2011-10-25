-module(ej_004).
-compile(export_all).
%-export([get_largest_palindrome/0]).

is_palindrome(Number) ->
  String = integer_to_list(Number),
  String == lists:reverse(String).

get_largest_palindrome(0, 0, Accum) -> Accum;
get_largest_palindrome(X, 0, Accum) -> get_largest_palindrome(X - 1, X - 1, Accum);

get_largest_palindrome(X, Y, Accum) ->
  Value = X * Y,

  case is_palindrome(Value) andalso Value > Accum of
    true -> NewValue = Value;
    false -> NewValue = Accum
  end,

  get_largest_palindrome(X, Y - 1, NewValue).

get_largest_palindrome(X, Accum) -> get_largest_palindrome(X, X, Accum).
get_largest_palindrome() -> get_largest_palindrome(999, 0).


