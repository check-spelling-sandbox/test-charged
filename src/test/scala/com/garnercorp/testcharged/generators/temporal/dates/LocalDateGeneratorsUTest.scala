package com.garnercorp.testcharged.generators.temporal.dates

import java.time.{LocalDateTime, Month, LocalTime, LocalDate}
import com.garnercorp.testcharged.generators.temporal.{
  TemporalTesting,
  NowProvider
}
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks.forAll

class LocalDateGeneratorsUTest
    extends TemporalTesting
    with DateRanges
    with AnyFunSuiteLike {
  val CurrentDate: LocalDate = LocalDate.of(2020, Month.JANUARY, 1)
  implicit val NowProvider: NowProvider = now(
    LocalDateTime.of(CurrentDate, LocalTime.MIDNIGHT)
  )

  test(
    "Ensure LocalDate generation helpers generate within the defined presets"
  ) {
    forAll(LocalDateGenerators.distancePast) {
      withinRange(CurrentDate.minus(DistantPast), CurrentDate)
    }
    forAll(LocalDateGenerators.past) {
      withinRange(CurrentDate.minus(Past), CurrentDate)
    }
    forAll(LocalDateGenerators.recent) {
      withinRange(CurrentDate.minus(Recent), CurrentDate)
    }

    forAll(LocalDateGenerators.default) {
      withinRange(CurrentDate.minus(Recent), CurrentDate.plus(Soon))
    }

    forAll(LocalDateGenerators.soon) {
      withinRange(CurrentDate, CurrentDate.plus(Soon))
    }
    forAll(LocalDateGenerators.future) {
      withinRange(CurrentDate, CurrentDate.plus(Future))
    }
    forAll(LocalDateGenerators.distantFuture) {
      withinRange(CurrentDate, CurrentDate.plus(DistantFuture))
    }
  }
}
