package com.garnercorp.testcharged.generators.ids

import com.garnercorp.testcharged.generators._
import org.scalatest.OptionValues
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class UuidGeneratorsUTest extends AnyFunSuite with Matchers with OptionValues {
  test("Single UUID generation") {
    val generatedUuid = Generate.uuid.value

    generatedUuid.toString should include("-")
  }
}
