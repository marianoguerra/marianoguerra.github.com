package ar.com.marianoguerra

object Calc {
  def add(a: Int, b: Int): Int = {
    a + b
  }
  
  def div(a: Int, b: Int): Option[Int] = {
    if (b == 0) {
      None
    } else {
      Some(a / b)
    }
  }
}

// vim: set ts=4 sw=4 et:
