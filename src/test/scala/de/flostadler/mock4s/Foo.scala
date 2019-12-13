package de.flostadler.mock4s

import org.scalatest.flatspec.AnyFlatSpec
import scala.reflect.runtime.universe.{TypeTag, typeOf}

class Foo extends AnyFlatSpec{
  "test" should "pass" in {
    val str: String = test("")
    val i: Int = test(4)
    val c: Char = test('a')
    val fl: Float = test(4.0f)
    val d: Double = test(.0d)
    val bool: Boolean = test(true)
    val l: Long = test(4L)
    val sh: Short = test(0.toShort)
    val b: Byte = test(0.toByte)
  }

//  def test[B](value: B)(implicit bTag: TypeTag[B]) = {
//    println(DefaultProvider.getDefaultFor(bTag))
//  }

  def test[B](value: B)(implicit bTag: TypeTag[B]): B = {
    DefaultProvider.getDefaultFor(bTag)
  }
}
