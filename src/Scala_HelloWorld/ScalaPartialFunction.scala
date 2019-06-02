package Scala_HelloWorld

/**
  * 偏函数就是函数通过伴生对象的apply方法构建对象
  * lazy 是什么时候程序调用什么时候使用
  */
object ScalaPartialFunction {
  def main(args: Array[String]): Unit = {

        val sample = 1 to 10

        val getNum : PartialFunction[Int,String]={
          //这里的getNum是偏函数，入参是Int ，返回类型是String
          case  x if x %2 ==0 => x + "is even"
          case  x if x %2 ==1 => x + "is odd"
        }

//        println(getNum(4))

        val collect = sample collect(getNum)
        //collect 通过偏函数操作对于集合中元素进行操作
        collect.foreach(println)

        val map = sample map(getNum)
    //map操作时构建两个新的集合
//        map.foreach(map)

  }
}
