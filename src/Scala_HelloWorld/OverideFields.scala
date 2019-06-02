//package Scala_HelloWorld
//
//
//class Person {
//
//  val counter = 3
//  val counterArray = new Array[Int](counter)
//
//}
////
////class Sporter extends Person{
////  override val counter = 5
////}
//
//class Sporter extends {
//  override  val counter = 5
//}with  Person
////这是正确的写法这样才是真正的覆盖
////在源码中的pravite[any]是仅仅在这个包下面才可以使用属于私有
//
//
//class Programmer(val name:String,val salary:Double) {
//
//  final override def equals(obj: Any) = {
//    val that  = obj.isInstanceOf[Programmer]
//    if (that == null ) false
//    else name == obj.name && salary == obj.salary
//
//  }
//
//  final override def hashCode() = name.hashCode()* 7 + salary.hashCode()*7
//
//}
//
//object OverideFields extends App {
//  val s = new Sporter
//  println(s.counterArray.length)
//  //这里是需要提前定义的如果没有定义 仅仅只是复写的话 scala的机制会将Array的长度归0
//}
