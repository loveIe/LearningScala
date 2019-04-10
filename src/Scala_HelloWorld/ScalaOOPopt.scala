package Scala_HelloWorld


/**
  * scala中使用class来声明类
  * scala中的object和class同名时，那么object那就class类的静态内容.可以不通过创建实例就可以调用object中的一切内容
  * 也就是说可以通过object中的方法来创建class的实例对象，object中的特定方法也就是apply方法可以创建对象
  * 抽象类是不能实例出来的，那么apply方法就可以实例化抽象类
  * spark中的graph类就是通过apply方法调用GraphImpl子类方法来实例化graph类，可以更好的适应代码的迭代更新，更为高级的面向接口
  * Object ScalaOOPopt 是 ScalaOOPopt 的伴生对象
  * class ScalaOOPopt 是ScalaOOpopt的伴生类
  * scala可以构造很多apply方法
  * scala很多集合都是使用apply方法构建的 例如array
  */

class ScalaOOPopt(age:Int){
  var name = "Spark"
  def sayHello = println("My Name is " + name)
}


object ScalaOOPopt{
  var number = 0
  def main(args: Array[String]): Unit = {
      val hello = new ScalaOOPopt(10)
      hello.sayHello
      ScalaOOPopt(20)
      ScalaOOPopt(30)
  }

  def apply(age:Int): ScalaOOPopt = {
      //apply后面没有参数的话也需要写上()
      number += 1
      println(number)
      new ScalaOOPopt(30)
  }
  def apply(): ScalaOOPopt = {
    //apply后面没有参数的话也需要写上()
    number += 1
    println(number)
    new ScalaOOPopt(40)
  }
}
