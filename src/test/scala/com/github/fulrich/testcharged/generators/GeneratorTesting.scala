package com.github.fulrich.testcharged.generators

import org.scalactic.anyvals.PosInt
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

trait GeneratorTesting extends ScalaCheckPropertyChecks {
  private val MinimumSuccessfulRequired: PosInt = 100000

  implicit override val generatorDrivenConfig: PropertyCheckConfiguration =
    PropertyCheckConfiguration(
      minSuccessful = MinimumSuccessfulRequired
    )
}
