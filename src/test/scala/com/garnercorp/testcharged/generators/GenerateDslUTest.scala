package com.garnercorp.testcharged.generators

import com.garnercorp.testcharged.generators.numerics.IntGenerators
import com.garnercorp.testcharged.generators.strings.AlphaGenerators
import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers

class GenerateDslUTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {
  val ConstantGeneratedString: String = "Test"
  val generator: Gen[String] = Gen.const(ConstantGeneratedString)

  test(
    "Can take a base generator and use the DSL to grab multiple concrete value types"
  ) {
    generator.value shouldBe ConstantGeneratedString
    generator.option should (be(Option(ConstantGeneratedString)) or be(None))
    generator.some shouldBe Some(ConstantGeneratedString)
    generator.seqOf(3) shouldBe Seq(
      ConstantGeneratedString,
      ConstantGeneratedString,
      ConstantGeneratedString
    )
    generator.seq should (be(empty) or contain only (ConstantGeneratedString))
    generator.nonEmptySeq.nonEmpty
  }

  test("Ensure that a failing generator returns a sensible error message") {
    val failingGen = Gen.alphaStr.suchThat(_.startsWith("5"))

    the[
      IllegalArgumentException
    ] thrownBy failingGen.value should have message GenerateDsl.GenerationFailureMessage
  }

  test(
    "If a Gen is required on a DefaultSizeGenerator the .default called can be skipped"
  ) {
    forAll(Generate.alpha) { generatedString =>
      generatedString.length should be >= AlphaGenerators.ShortMaximum
      generatedString.length should be <= AlphaGenerators.DefaultMaximum
    }
  }

  test(
    "If using the default size on a DefaultSizeGenerator do not need to use the .default method"
  ) {
    val generatedString = Generate.alpha.value

    generatedString.length should be >= AlphaGenerators.ShortMaximum
    generatedString.length should be <= AlphaGenerators.DefaultMaximum
  }

  test(
    "When accessing NumericGenerator value can omit the chained default calls"
  ) {
    val generatedNumeric = Generate.int.value

    generatedNumeric should be >= Math.negateExact(IntGenerators.DefaultMaximum)
    generatedNumeric should be <= IntGenerators.DefaultMaximum
  }

  test(
    "When accessing a NumericGenerator can omit the chained default calls when a Gen is required"
  ) {
    forAll(Generate.int) { generatedInt =>
      generatedInt should be >= Math.negateExact(IntGenerators.DefaultMaximum)
      generatedInt should be <= IntGenerators.DefaultMaximum
    }
  }

  test(
    "When accessing a NumericGenerator's SignGenerator can omit the default when a Gen is required"
  ) {
    forAll(Generate.int.small) { generatedInt =>
      generatedInt should be >= Math.negateExact(IntGenerators.ShortMaximum)
      generatedInt should be <= IntGenerators.ShortMaximum
    }
  }
}
