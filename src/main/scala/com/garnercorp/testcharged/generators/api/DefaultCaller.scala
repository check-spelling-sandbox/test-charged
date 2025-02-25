package com.garnercorp.testcharged.generators.api

import org.scalacheck.Gen

trait DefaultCaller[A, B] {
  def apply(callee: B): Gen[A]
}
