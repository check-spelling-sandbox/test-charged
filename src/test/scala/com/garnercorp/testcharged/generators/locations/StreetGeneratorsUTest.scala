package com.garnercorp.testcharged.generators.locations

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalatest.funsuite.AnyFunSuite

class StreetGeneratorsUTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {

  test("Can generate street numbers between about 1 and 9999") {
    forAll(StreetGenerators.number) { generatedStreetNumber =>
      validateStreetNumber(generatedStreetNumber)
    }
  }

  test("Can generate reasonable street names") {
    forAll(StreetGenerators.name) { generatedStreetName =>
      validateStreetName(generatedStreetName)
    }
  }

  test("Can generate a street suffix") {
    forAll(StreetGenerators.suffix) { generatedSuffix =>
      validateStreetSuffix(generatedSuffix)
    }
  }

  test("Can generate a full realistic street string") {
    forAll(StreetGenerators.default) { generatedStreet =>
      val streetParts = generatedStreet.split(" ").toVector

      validateStreetNumber(streetParts.head.toInt)
      validateStreetName(streetParts.tail.mkString(" "))
    }
  }

  def validateStreetNumber(number: Int): Unit = {
    number should be >= StreetGenerators.MinimumStreetNumber
    number should be <= StreetGenerators.MaximumStreetNumber
  }

  def validateStreetName(name: String): Unit = {
    name.count(character =>
      character.isLetter || character.isDigit || character.isWhitespace
    ) == name.length
  }

  def validateStreetSuffix(suffix: String): Unit = {
    suffix.count(_.isLetter) == suffix.length
    StreetGenerators.Suffixes should contain(suffix)
  }
}
