package Scala_HelloWorld

import sun.awt.SunHints.Key


class FrameWorkFather

case class FrameWorkSon_1(name:String) extends FrameWorkFather
//类匹配时要主要将case写在class前面
case class FrameWorkSon_2(name:String) extends FrameWorkFather

object ScalaMatchAndCase {
  def main(args: Array[String]): Unit = {
//      getSalary("Spark")
//        getMatchType("Hello")
//        getColleaction(Array("aa","bb"))
//        getCaseClass(FrameWorkSon_2("Hi"))
        val map = Map("Spark"-> "S","Java"->"J")
        getValue("Spark",map)
  }

  //值匹配
  def getSalary(name:String): Unit ={
    name match {
      case "Spark" => println("1")
      case "Scala" => println("2")
      case _name => println("0")
      case _ => println("3")
    }
  }
  //类型匹配
  def getMatchType(msg:Any): Unit ={
    msg match {
      case i : Int => println("Int")
      case s : String => println("String")
      case d : Double => println("Double")
      case b : Boolean => println("Boolean")
      case _ => println("Unknown Type")
    }
  }

  //集合匹配
  def getColleaction(array:Array[String]): Unit ={
    array match {
      case Array("Scala") => println("1")
      case Array("name","bb") => println("2")
      case Array(_*) => println("Many")
    }
  }

  //类匹配
  def getCaseClass(className:FrameWorkFather): Unit ={
    className match {
      case FrameWorkSon_1(name) => println("aaa")
      case FrameWorkSon_2(name) => println("bbb")
    }
  }
  //Map匹配
  def getValue(key:String,map: Map[String,String]): Unit ={
    map.get(key) match {
      case Some(value) => println("Sprak")
      case None => println("Not Found")
    }
  }
  //
}
