package Scala_HelloWorld


/**
  *Scala的Array创建方式其实是根据Array的构建对象的Apply工厂方法来创建的
  *Scala的Array方法是根据JVM来的是不可变的
  * 如果集合需要改变就需要使用到Array的方法
  */
object ScalaArrayOpt {
  def main(args: Array[String]): Unit = {
//     val array = new Array[Int](5) //最原始的创建方法
//       val array = Array[Int](1,2,3,5)//Scala的创建方式
       val array = Array(2,1,3,4)//Array的泛型可以忽略，因为Scala有类型推导
     for(item <- array) println(item)

     import scala.collection.mutable.ArrayBuffer
     val arrayBuffer = ArrayBuffer[Int]()
     arrayBuffer += 1
     arrayBuffer += 2 //一个加号一个等号相当于添加一个元素
     arrayBuffer += 3
     arrayBuffer += (4,5)
     arrayBuffer ++= Array(6,7,8,9)//ArrayBuffer是可变的数组 两个等号等于数组相加
     for (item <-  arrayBuffer ) println(item)

//     arrayBuffer.insert(2,100)
//     arrayBuffer.remove(2)
//     arrayBuffer.toArray 多线程开发时，将arrayBuffer 转换成 Array 很重要

     for(i <- 0 until array.length) print(array(i))

     scala.util.Sorting.quickSort(array) //scala的排序需要导入包

     println(array.mkString(","))   //mkString 的作用..查看源码可以将数组内容

     val arrayAddOne = for(item <- array ) yield item + 1 //yield 关键字可以在不修改原数组的情况下对原数组的元素进行操作并且组成一个新的数组
     print(arrayAddOne.mkString(" "))
     println(array.mkString("  "))

     val arrayEven = for(i <- array if i % 2 == 0) yield i //在这里 yield 可以不做任何操作 但是必须要有，因为需要构建一个新的数组
       println(arrayEven.mkString(","))

     println( array.filter(i => i % 2 == 1).map(i => i*10).mkString(" ")) //数组可以使用过滤器 过滤器规则 过滤数组中的元素后面跟Boolean表达式
       //集合的操作往往通过丰富的操作算子来进行二次操作
       //在Spark中核心思想就是类似于yield通过对原集合中的元素进行操作组成新的集合
  }
}
