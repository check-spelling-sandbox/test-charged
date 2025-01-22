package com.garnercorp.testcharged.generators.locations

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers

class CityGeneratorsUTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {

  test(
    "All city names generated should be alpha only and start with a capital"
  ) {
    forAll(CityGenerators.default) { generatedCity =>
      CityGenerators.CityList should contain(generatedCity)
    }
  }
}
