package org.myproject

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class AdderSpec extends FlatSpec with ShouldMatchers {

  "adder" should "add 2 + 3 to 5" in {
    val adder = new Adder
    adder.add(2, 3) should equal (5)
  }
}
