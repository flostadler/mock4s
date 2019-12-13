package de.flostadler.mock4s


import scala.reflect.runtime.universe.{TypeTag, typeOf}

object Mock4s {
  val mockedString = Mock(classOf[String]) when { _.charAt } thenDo {
    case index if index == 7 => 'd'
    case _ => 'u'
  }

  val second = Mock(classOf[String]) when { _.codePointCount } thenDo {
    case (lower, _) if lower > 5 => 7
    case _ => -2
  }

  val third = Mock(classOf[TestClass]) when { _.three } thenDo {
    case (1, 2, 3) => ""
  }

}

class TestClass {
  def three(a: Int, b: Int, c: Int): String = ""
}

case class Mock[A](private val clazz: Class[A]) {
  def when[B, R](func: A => B => R)(implicit tag: TypeTag[B]): MockBuilder[A, B, R] = {

  }

  def when[B, C, R](func: A => (B, C) => R)(implicit bTag: TypeTag[B], cTag: TypeTag[C]): MockBuilder2[A, B, C, R] = {

  }

  def when[B, C, D, R](func: A => (B, C, D) => R)(implicit bTag: TypeTag[B], cTag: TypeTag[C], dTag: TypeTag[D]): MockBuilder3[A, B, C, D, R] = {

  }
}

case class MockBuilder[A, B, R](private val clazz: Class[A], private val func: A => B => R) {
  def thenDo(matcher: PartialFunction[B, R]): A = {

  }
}

case class MockBuilder2[A, B, C, R](private val clazz: Class[A], private val func: A => (B, C) => R ) {
  def thenDo(matcher: PartialFunction[(B, C), R]): A = {

  }
}

case class MockBuilder3[A, B, C, D, R](private val clazz: Class[A], private val func: A => (B, C, D) => R ) {
  def thenDo(matcher: PartialFunction[(B, C, D), R]): A = {

  }
}
