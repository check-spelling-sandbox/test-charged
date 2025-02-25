package com.garnercorp.testcharged.generators.temporal

import java.time._

import com.garnercorp.testcharged.generators.temporal.dates.{
  LocalDateGenerators,
  LocalDateTimeGenerators,
  ZonedDateTimeGenerators
}
import com.garnercorp.testcharged.generators.temporal.instant.InstantGenerators
import com.garnercorp.testcharged.generators.temporal.times.LocalTimeGenerators

trait TemporalGenerators extends NowDsl {
  val zonedDateTime: TemporalGenerator[ZonedDateTime] = ZonedDateTimeGenerators
  val localDateTime: TemporalGenerator[LocalDateTime] = LocalDateTimeGenerators
  val localDate: TemporalGenerator[LocalDate] = LocalDateGenerators
  val localTime: TemporalGenerator[LocalTime] = LocalTimeGenerators
  val instant: TemporalGenerator[Instant] = InstantGenerators
}
