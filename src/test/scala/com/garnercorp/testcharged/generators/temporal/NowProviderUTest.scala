package com.garnercorp.testcharged.generators.temporal

import java.time.{LocalDateTime, Month, Clock, ZoneOffset}
import com.garnercorp.testcharged.generators.temporal.instant.ToInstant
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class NowProviderUTest extends AnyFunSuite with Matchers with NowDsl {
  test("The default NowProvider should use the default system as the default") {
    val defaultNowProvider = implicitly[NowProvider]

    defaultNowProvider
      .apply()
      .millis shouldBe (Clock.systemDefaultZone.millis +- 100)
    defaultNowProvider.zone shouldBe Clock.systemDefaultZone.getZone
  }

  test(
    "Should be able to retrieve the different temporal types from a now provider"
  ) {
    val testLocalDateTime = LocalDateTime.of(2018, Month.JULY, 20, 10, 20)
    val testNow = now(testLocalDateTime)

    testNow.instant shouldBe ToInstant(testLocalDateTime)
    testNow.zone shouldBe ZoneOffset.UTC
    testNow.localTime shouldBe testLocalDateTime.toLocalTime
    testNow.localDate shouldBe testLocalDateTime.toLocalDate
    testNow.localDateTime shouldBe testLocalDateTime
    testNow.zonedDateTime shouldBe testLocalDateTime.atZone(testNow.zone)
  }
}
