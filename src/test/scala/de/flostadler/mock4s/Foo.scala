package de.flostadler.mock4s

import org.scalatest.flatspec.AnyFlatSpec
import scala.reflect.runtime.universe.{TypeTag, typeOf}

class Foo extends AnyFlatSpec{
  "test" should "pass" in {
    test("")
    test(4)
    test('a')
  }

  def test[B](value: B)(implicit bTag: TypeTag[B]) = {
    println(Mock4s.defaultValue(bTag))
  }
}
