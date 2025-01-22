package com.garnercorp.testcharged.generators.numerics

import com.garnercorp.testcharged.generators.api.{
  DefaultCaller,
  GenerationSizes,
  SizeApi
}
import com.garnercorp.testcharged.generators._
import org.scalacheck.Gen
import org.scalacheck.Gen.Choose

abstract class NumericGenerator[T: Numeric: Choose]
    extends SizeApi[SignGenerator[T]]
    with GenerationSizes[T] {
  val numeric: Numeric[T] = implicitly[Numeric[T]]

  def apply(range: T): SignGenerator[T] = SignGenerator[T](range)
  def apply(minimum: T, maximum: T): Gen[T] = {
    require(
      numeric.lt(minimum, maximum),
      s"Your minimum value ($minimum) must be less than your maximum ($maximum)."
    )
    Gen.choose[T](minimum, maximum)
  }

  override def tiny: SignGenerator[T] = apply(TinyMaximum)
  override def small: SignGenerator[T] = apply(ShortMaximum)
  override def default: SignGenerator[T] = apply(DefaultMaximum)
  override def large: SignGenerator[T] = apply(BigMaximum)
  override def huge: SignGenerator[T] = apply(HugeMaximum)
}

object NumericGenerator {
  implicit def numericGeneratorDefaultCaller[T: Numeric: Choose]
      : DefaultCaller[T, NumericGenerator[T]] =
    (callee: NumericGenerator[T]) => callee.default
}
