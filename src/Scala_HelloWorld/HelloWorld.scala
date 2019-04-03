package Scala_HelloWorld

object HelloWorld {

  /**
    * 1.object 不是对象，而是scala中的静态类，相当于public static void 所以不需要实现类，虚拟机可以直接执行
    * 2.def 是scala中的关键字声明函数和方法，但是函数和方法不同，并且方法并不具有函数特征
    * 3.args是变量冒号后面跟有类型
    * 4.Unit是scala中的关键字是返回值类型，相当于void，是根据方法体中最后一个语句来更改的
    * 5.Unit可以省略不写
    * 6.等于号是main方法的返回值
    * 7.scala的很多底层实现是根据java的底层实现得来的.
    * 8.scala中的apply方法是scala的构造对象的工厂方法，控制对象的生成
    * @param args
    */
  def main(args: Array[String]): Unit = {
    println("HelloWorld")
  }

}
