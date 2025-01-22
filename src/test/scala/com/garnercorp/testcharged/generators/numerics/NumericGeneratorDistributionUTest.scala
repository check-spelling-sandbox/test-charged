package com.garnercorp.testcharged.generators.numerics

import org.scalacheck.Gen
import org.scalacheck.Gen.Choose
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class NumericGeneratorDistributionUTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {

  test("The double generator does not weight extremities") {
    ensureExtremitiesNotWeighted(DoubleGenerators)
  }

  test("The integer generator does not weight extremities") {
    ensureExtremitiesNotWeighted(IntGenerators)
  }

  test("The long generator does not weight extremities") {
    ensureExtremitiesNotWeighted(LongGenerators)
  }

  test("The float generator does not weight extremities") {
    ensureExtremitiesNotWeighted(FloatGenerators)
  }

  test("The short generator does not weight extremities") {
    ensureExtremitiesNotWeighted(ShortGenerators)
  }

  def ensureExtremitiesNotWeighted[A: Choose](
      generator: NumericGenerator[A]
  )(implicit numeric: Numeric[A]): Unit = {
    val sizeOfList: Int = 100
    val fivePercent: Int = (sizeOfList * 0.05).toInt
    val listGenerator: Gen[Seq[A]] =
      Gen.listOfN(sizeOfList, generator.default.default)

    forAll(listGenerator) { generatedNumerics =>
      generatedNumerics.count(
        _ == generator.DefaultMaximum
      ) should be < fivePercent
      generatedNumerics.count(
        _ == numeric.negate(generator.DefaultMaximum)
      ) should be < fivePercent
    }
  }
}
