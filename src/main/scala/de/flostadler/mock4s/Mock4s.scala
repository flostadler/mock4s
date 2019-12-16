package de.flostadler.mock4s


import de.flostadler.mock4s.Mock.{mock, when}

import scala.reflect.runtime.universe.{TypeTag, typeOf}

object Mock4s {
  val mockedString = mock[String] when { _.charAt}  thenDo {
    case index if index == 7 => 'd'
    case _ => 'u'
  }

  val second = mock[String] when { _.codePointAt } thenReturn 7

  val third = mock[TestClass] when { _.one }

  mock[TestClass] when { _.getter }

  mock[TestClass] when { x => x.getter _ } thenReturn "hi"



}

class TestClass {
  def three(a: Int, b: Int, c: Int): String = ""

  def one(a: Int): Int = 4

  def getter: String = ""
}

object Mock {
  def mock[A]: Mock[A] = new Mock[A]()

  def when[A, R](a: A)(func: A => () => R): MockBuilder0[A, R] = {

  }

  def when[A, B, R](a: A)(func: A => B => R)(implicit tag: TypeTag[B]): MockBuilder1[A, B, R] = {

  }
}

class Mock[A]() {

  def when[R](func: A => () => R): MockBuilder0[A, R] = {

  }

  def when[B, R](func: A => B => R)(implicit tag: TypeTag[B]): MockBuilder1[A, B, R] = {

  }

  def when[B, C, R](func: A => (B, C) => R)(implicit bTag: TypeTag[B], cTag: TypeTag[C]): MockBuilder2[A, B, C, R] = {

  }

  def when[B, C, D, R](func: A => (B, C, D) => R)(implicit bTag: TypeTag[B], cTag: TypeTag[C], dTag: TypeTag[D]): MockBuilder3[A, B, C, D, R] = {

  }
}

case class MockBuilder0[A, R](private val func: A => R) {
  def thenDo(matcher: Unit => R): A = {

  }

  def thenReturn(value: R): A  = {

  }
}

case class MockBuilder1[A, B, R](private val clazz: Class[A], private val func: A => B => R) {
  def thenDo(matcher: PartialFunction[B, R]): A = {

  }

  def thenReturn(value: R): A  = {

  }
}

case class MockBuilder2[A, B, C, R](private val clazz: Class[A], private val func: A => (B, C) => R ) {
  def thenDo(matcher: PartialFunction[(B, C), R]): A = {

  }

  def thenReturn(value: R): A  = {

  }
}

case class MockBuilder3[A, B, C, D, R](private val clazz: Class[A], private val func: A => (B, C, D) => R ) {
  def thenDo(matcher: PartialFunction[(B, C, D), R]): A = {

  }

  def thenReturn(value: R): A  = {

  }
}
