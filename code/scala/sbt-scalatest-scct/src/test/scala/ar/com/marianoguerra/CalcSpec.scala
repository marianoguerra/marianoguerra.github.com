package ar.com.marianoguerra

import org.scalatest

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class CalcSpec extends FlatSpec with ShouldMatchers {

  "Calc" should "add" in {
    Calc.add(2, 3) should equal (5)
  }

  it should "divide" in {
    Calc.div(3, 2) should equal (Some(1))
  }
}

// vim: set ts=4 sw=4 et:
