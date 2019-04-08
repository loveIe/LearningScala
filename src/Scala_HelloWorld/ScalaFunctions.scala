package Scala_HelloWorld

/**
  * 函数可以被简单的认为是一个包裹了一条或者多条语句的代码体,这个代码体可以接受多个参数，经过代码体处理后返回结果，函数在scala中是一等
  * 公民，可以像变量一样传递，赋值，变量也可以赋值给函数，函数也可以赋值给变量，根本原因就是函数的背后是类和对象，在程序的运行期间函数就
  * 可以认为是一个变量.背后的类和对象是Scala天然生成的.且可以进行序列化和反序列化.意义非常重大.
  * 意义： 1 . 天然序列化的好处就是在分布式系统中，函数可以进行传递.
  *       2 . 因为背后是类和对象，所以函数可以运用在任何变量运用的地方.
  *
  * 如果函数名称和函数体之间没有等于号，那么函数类型推导失效
  * 如果在函数体中无法推导出函数类型，则必须声明函数类型
  * 函数的参数可以不根据顺序来传递，可以根据名字来传递 因为函数的背后是类和对象，参数可以想想成为类成员.
  * 函数中如果传递的参数是可变，可以使用函数变长的方式，传参的时候方式为 : _*
  * 可变的参数中的数据会被收集成为Array数组
  */

object ScalaFunctions {
  def main(args: Array[String]): Unit = {
      hello("TangQ",20)
      hello("TangQ")
      val result = fibonacci(10)
      println(result)
      println(sum(1,2,3,4,5))
      println(sum(1 to 10 : _*))
      println(recursion(1 to 100 : _*))

  }

  def hello(name:String,age:Int=10): Unit ={
    //变量后面加上等号可以给个默认值
    println("My Name is " + name)
    println("My Age is" + age)
  }

  def fibonacci(n:Int):Int={
    if(n<=1) 1
    else fibonacci(n-2)+fibonacci(n-1)
  }

  def sum(numbers:Int*):Int={
    //Int后加上*表明参数是可变的
    var result = 0
    for(number <- numbers) {
      result += number
    }
    result
  }

  def recursion(n:Int*):Int={
    if(0 == n.length) 0
    else n.head + recursion(n.tail: _*)
  }
}
