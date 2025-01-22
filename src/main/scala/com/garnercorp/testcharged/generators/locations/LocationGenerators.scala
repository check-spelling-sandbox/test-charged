package com.garnercorp.testcharged.generators.locations


trait LocationGenerators {
  val street = StreetGenerators
  val city = CityGenerators
  val country = CountryGenerators
}
