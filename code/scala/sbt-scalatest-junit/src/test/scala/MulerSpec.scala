package org.myproject

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MulerSpec extends FlatSpec with ShouldMatchers {

  "muler" should "multiply 2 * 3 to 6" in {
    val muler = new Muler
    muler.mul(2, 3) should equal (6)
  }
}
