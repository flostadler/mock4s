package de.flostadler.mock4s

import scala.reflect.runtime.universe.{TypeTag, typeOf}

object DefaultProvider {
  def getDefaultFor[A](tag: TypeTag[A]): A = {
    tag.tpe match {
      case tag if tag =:= typeOf[Int] => 0.asInstanceOf[A]
      case tag if tag =:= typeOf[Long] => 0L.asInstanceOf[A]
      case tag if tag =:= typeOf[Short] => 0.asInstanceOf[A]
      case tag if tag =:= typeOf[Byte] => 0.asInstanceOf[A]
      case tag if tag =:= typeOf[Char] => '0'.asInstanceOf[A]
      case tag if tag =:= typeOf[Boolean] => false.asInstanceOf[A]
      case _ => null.asInstanceOf[A]
    }
  }
}
