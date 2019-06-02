package Scala_HelloWorld


/**
  * Scala接口
  * trait 关键字用来表示接口
  * 1.接口中可以实现方法，一般来说接口中的方法如果全部实现了就是个工具类
  * 2.scala中继承就是extends不管是继承接口，类都是extends类可以继承接口 如果有extends关键字with来实现接口
  * scala中接口支持多重继承，类或者抽象类不支持多重继承
  * 抽象方法就是没有实现的方法，并没有关键字
  * 抽象属性没有被赋值的属性，Scala是静态语言，声明变量需要指定类型
  * scala的类的实例对象也可以混入接口，用来扩展当前对象的实例和功能
  * 在scala中没有implements这个关键字直接使用extends
  * scala中如果混入了多个接口，那么使用接口的顺序是从右到左
  * */
trait Logger {
  def log(message:String): Unit ={
    println("Logger Message "+ message)
  }
}

trait RichLogger extends Logger {
  override def log(message: String): Unit = {
    println("RichLogger Message" + message)
  }
}

trait Check{
  def checkInfo(name:String):Boolean={
      name.equals("Tang")
  }
}

class Loggin(name:String) extends Logger{
  println(" Welcome "+name + "!")
  log(name)
}


object ScalaImpl {
  def main(args: Array[String]): Unit = {
       val person = new Loggin("Tang") with RichLogger with Check
       println(person.checkInfo("Tang"))
  }
}
