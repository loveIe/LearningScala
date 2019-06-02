package Scala_HelloWorld


case class Person1(name:String,salary:Double)

class Owner (val name1 : String , val salary1 : Double)
object  Owner {
  def apply(name1:String,salary1:Double): Unit ={
      new Owner(name1,salary1)
  }

  def unapply(arg: Owner) ={
    Some((arg.name1,arg.salary1))
  }
}



object ScalaExtractor extends App {
     val p = Person1.apply("scala",20000)//这是通过person伴生对象的apply构造
     val Person1(name1,salary1) = p //将对象赋值给类是模式匹配的一种展现 这就是提取器 将属性提取出来也就是unapply方法

      p match {
        case Person1(name,salary)=> println(name+":"+salary)
      }

      val owner = new Owner("scala",200000)
      val Owner = owner

}
