package com.garnercorp.testcharged

import com.garnercorp.testcharged.generators.ids.IdGenerators
import com.garnercorp.testcharged.generators.temporal.TemporalGenerators
import com.garnercorp.testcharged.generators.locations.LocationGenerators
import com.garnercorp.testcharged.generators.numerics.NumericGenerators
import com.garnercorp.testcharged.generators.strings.StringGenerators


package object generators extends GenerateDsl {
  object Generate
    extends StringGenerators
    with NumericGenerators
    with LocationGenerators
    with TemporalGenerators
    with IdGenerators
}
