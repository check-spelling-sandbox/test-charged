package com.github.fulrich.testcharged.generators.temporal

import com.github.fulrich.testcharged.generators.GeneratorTesting
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

trait TemporalTesting
    extends AnyFunSuite
    with Matchers
    with GeneratorTesting
    with NowDsl
    with TemporalOrdering {
  def withinRange[A: Ordering](after: A, before: A)(generatedDate: A): Unit = {
    generatedDate should be >= after
    generatedDate should be <= before
  }
}
