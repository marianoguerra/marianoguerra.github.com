package org.myproject

object Scalample {
  def main(args: Array[String]) {
    val adder = new Adder
    val muler = new Muler

    println("adder: 2 + 3 = " + adder.add(2, 3))
    println("muler: 2 * 3 = " + muler.mul(2, 3))
  }
}
