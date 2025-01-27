package com.garnercorp.testcharged.generators.numerics


trait NumericGenerators {
  val short: NumericGenerator[Short] = ShortGenerators
  val int: NumericGenerator[Int] = IntGenerators
  val long: NumericGenerator[Long] = LongGenerators
  val double: NumericGenerator[Double] = DoubleGenerators
  val float: NumericGenerator[Float] = FloatGenerators
}
