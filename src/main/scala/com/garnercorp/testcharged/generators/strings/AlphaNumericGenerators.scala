package com.garnercorp.testcharged.generators.strings

import com.garnercorp.testcharged.generators.DefaultSizeGenerator
import org.scalacheck.Gen


object AlphaNumericGenerators extends DefaultSizeGenerator[String] {
  override protected def generate(minimum: Long, maximum: Long): Gen[String] = for {
    size <- Gen.chooseNum(minimum, maximum)
    generatedString <- Gen.listOfN(size.toInt, Gen.alphaNumChar)
  } yield generatedString.mkString
}
