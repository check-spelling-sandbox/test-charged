package com.garnercorp.testcharged.generators.locations

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers

class CountryGeneratorsUTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {
  test("Can generate just a code of any country in the country list") {
    val allCountryCodes = CountryGenerators.CountryList.map(_.code)

    forAll(CountryGenerators.code) { countryCode =>
      allCountryCodes should contain(countryCode)
    }
  }

  test("Can generate just a name of any country in the country list") {
    val allCountryNames = CountryGenerators.CountryList.map(_.name)

    forAll(CountryGenerators.name) { countryName =>
      allCountryNames should contain(countryName)
    }
  }

  test("Can generate a full country object using the country generators") {
    forAll(CountryGenerators.default) { country =>
      CountryGenerators.CountryList should contain(country)
    }
  }
}
