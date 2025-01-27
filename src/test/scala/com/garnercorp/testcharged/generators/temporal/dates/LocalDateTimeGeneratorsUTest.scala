package com.garnercorp.testcharged.generators.temporal.dates

import java.time.{LocalDateTime, Month}
import com.garnercorp.testcharged.generators.temporal.{
  TemporalTesting,
  NowProvider
}
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks.forAll

class LocalDateTimeGeneratorsUTest
    extends TemporalTesting
    with DateRanges
    with AnyFunSuiteLike {
  val CurrentDateTime: LocalDateTime =
    LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0)
  implicit val NowProvider: NowProvider = now(CurrentDateTime)

  test(
    "Ensure LocalDateTime generation helpers generate within the defined presets"
  ) {
    forAll(LocalDateTimeGenerators.distancePast) {
      withinRange(CurrentDateTime.minus(DistantPast), CurrentDateTime)
    }
    forAll(LocalDateTimeGenerators.past) {
      withinRange(CurrentDateTime.minus(Past), CurrentDateTime)
    }
    forAll(LocalDateTimeGenerators.recent) {
      withinRange(CurrentDateTime.minus(Recent), CurrentDateTime)
    }

    forAll(LocalDateTimeGenerators.default) {
      withinRange(CurrentDateTime.minus(Recent), CurrentDateTime.plus(Soon))
    }

    forAll(LocalDateTimeGenerators.soon) {
      withinRange(CurrentDateTime, CurrentDateTime.plus(Soon))
    }
    forAll(LocalDateTimeGenerators.future) {
      withinRange(CurrentDateTime, CurrentDateTime.plus(Future))
    }
    forAll(LocalDateTimeGenerators.distantFuture) {
      withinRange(CurrentDateTime, CurrentDateTime.plus(DistantFuture))
    }
  }
}
