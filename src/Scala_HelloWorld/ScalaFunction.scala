package Scala_HelloWorld

/**
  * 函数式编程进阶
  * 1.函数和变量都是scala的一等公民，函数可以直接赋值给变量。
  * 2.常用的方式是匿名函数，定义时，只需要说明输入参数和函数体就可以，不需要名称，会把这个函数体赋值给一个val常量
  * 3.可以将函数直接当作成为变量传入，简化开发过程：
  *   3.1 java方式是new出一个接口的实例，然后通过接口实例的回调方法实现业务逻辑，而这里直接将回调方法作为参数传递
  *   3.2 这个方式可以编写复杂逻辑的业务逻辑和控制逻辑对于图计算和机器学习，深度学习至关重要
  * 4.函数的返回值可以是函数，这就是实现了闭包，
  * 5.currying 柯里化复杂函数式编程中经常使用，可以维护变量在内存中的状态，也就是将接受多个参数的函数编程接受一个函数的参数
  */
object ScalaFunction {
  def main(args: Array[String]): Unit = {
      val hello = helloFunc _
      //声明变量后加_就说明将函数赋值给了变量，然后就可以直接调用了.
      hello("Spark")
      val f = (name:String) => println("Hello,"+name)
      f("Scala")

  def getName(func:(String) => Unit,name:String): Unit ={
      //这个func：后面跟的时func需要的入参，而name时getName的入参
      //只有当函数作为入参的时候的操作才可以不用声明入参名称
    func(name)

    Array(1 to 10:_*).map{(i:Int)=>i*2}.foreach(x => println(x))
    //_*变参因为map方法需要对单个参数进行惭怍，所以要说明是变参

  def funcResult(message:String) = (name:String) => println(message+","+name)
  //message是funcResult的入参，而name是后面这个匿名函数的入参这两个是不一样的
    //message能够使用的原因是：因为函数本身是类所以message是成员变量，而后面的函数是成员方法
    funcResult("Hello")("MyName")
  }

  getName(f,"Kafka")

  }
  def helloFunc(name:String): Unit ={
    println("Hello,"+name)
  }


}
