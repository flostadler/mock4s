package de.flostadler.mock4s

import scala.reflect.runtime.universe.{TypeTag, typeOf}

object DefaultProvider {
  def getDefaultFor[A](tag: TypeTag[A]): A = (tag.tpe match {
      case tag if tag =:= typeOf[Int] => 0
      case tag if tag =:= typeOf[Long] => 0L
      case tag if tag =:= typeOf[Short] => 0.toShort
      case tag if tag =:= typeOf[Byte] => 0.toByte
      case tag if tag =:= typeOf[Char] => '0'
      case tag if tag =:= typeOf[Boolean] => false
      case tag if tag =:= typeOf[Double] => .0d
      case tag if tag =:= typeOf[Float] => .0f
      case _ => null
    }).asInstanceOf[A]
}
