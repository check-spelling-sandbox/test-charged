package com.garnercorp.testcharged.generators.strings

import com.garnercorp.testcharged.generators.DefaultSizeGenerator

trait StringGenerators {
  val alpha: DefaultSizeGenerator[String] = AlphaGenerators
  val alphaNumeric: DefaultSizeGenerator[String] = AlphaNumericGenerators
}
