package com.garnercorp.testcharged.generators.numerics

import com.garnercorp.testcharged.generators.GenerateDsl
import com.garnercorp.testcharged.generators.api.DefaultCaller
import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class NumericGeneratorsUTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks
    with GenerateDsl {

  test("All Numeric based generators conform to the NumericGenerator API") {
    testNumericGenerator(ShortGenerators)
    testNumericGenerator(IntGenerators)
    testNumericGenerator(LongGenerators)
    testNumericGenerator(FloatGenerators)
    testNumericGenerator(DoubleGenerators)
  }

  def testNumericGenerator[A: Numeric: Ordering](
      numericGenerator: NumericGenerator[A]
  )(implicit defaultCaller: DefaultCaller[A, SignGenerator[A]]): Unit = {
    testMaximumLargerThanMinimum(numericGenerator)

    testMinimumMaximum(
      numericGenerator,
      numericGenerator.ShortMaximum,
      numericGenerator.BigMaximum
    )
    testRangeGeneration(
      numericGenerator(numericGenerator.BigMaximum),
      numericGenerator.BigMaximum
    )

    testRangeGeneration(numericGenerator.tiny, numericGenerator.TinyMaximum)
    testRangeGeneration(numericGenerator.small, numericGenerator.ShortMaximum)
    testRangeGeneration(
      numericGenerator.default,
      numericGenerator.DefaultMaximum
    )
    testRangeGeneration(numericGenerator.large, numericGenerator.BigMaximum)
    testRangeGeneration(numericGenerator.huge, numericGenerator.HugeMaximum)
  }

  def testRangeGeneration[A: Ordering](generator: Gen[A], range: A)(implicit
      numeric: Numeric[A]
  ): Unit =
    forAll(generator) { generatedValue =>
      generatedValue should be >= numeric.negate(range)
      generatedValue should be <= range
    }

  def testMinimumMaximum[A: Numeric](
      generator: NumericGenerator[A],
      minimum: A,
      maximum: A
  ): Unit =
    forAll(generator(minimum, maximum)) { generatedValue =>
      generatedValue should be >= minimum
      generatedValue should be <= maximum
    }

  def testMaximumLargerThanMinimum[A: Numeric](
      generator: NumericGenerator[A]
  ): Unit = {
    val minimum = generator.BigMaximum
    val maximum = generator.ShortMaximum
    val expected =
      s"requirement failed: Your minimum value ($minimum) must be less than your maximum ($maximum)."

    the[IllegalArgumentException] thrownBy generator(
      minimum,
      maximum
    ) should have message expected
  }
}
