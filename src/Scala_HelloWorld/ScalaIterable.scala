package Scala_HelloWorld


/**
  * Scala中集合的Iterable是共同的Trait。Iterable要求继承者要实现它的一些方法.
  * Array是Scala中特有的数据结构，不从属于Scala集合的体系
  * Scala中分为可变的集合和不可变的集合两种，不可变的是scala.collection.immutable中，可变的在scala.collection.mutable中
  * List是不可变集合head是第一个元素，tail是剩下的元素构成的集合
  *     使用::来把新的元素和List进行组拼构成一个新的集合
  *     如果集合中没有元素的话此时为Nil，如果集合中有且只有一个元素的话,那么head就是这个元素，tail此时为Nil
  * LinkedList是可变元素的列表
  * set是元素不可重复的集合，并且是无序的,hashSet元素是无序的，不可重复的，不可变的
  * linkedhashsSet可以维持元素插入的顺序
  */
object ScalaIterable {
  def main(args: Array[String]): Unit = {
        val range = 1 to 10
//        println(range)

      val list = List(1,2,3,4,5)
//      println(list.head)
//      println(list.tail)
//      println(6::list)

      var linkedList = scala.collection.mutable.LinkedList(1,2,3,4,5)
//      println(linkedList.elem)
      //head和elem的意思是一样的
//      println(linkedList.head)
      val copied = linkedList.+:(9)
      //+:是临时操作一个新的集合并不是原有的集合，原有的集合并不包含9
//      println(copied)

      val set = Set(1,23,4,5)
      println(set)

      println(List("I am so tired").flatMap(x=>x.split(" ")).map(x=>(x,1)).map(x=>x._2).reduce((x,y)=>x+y))
      //flatMap将一个元素拆分成为一个集合，如果是多个元素拆后也是一个集合,map就在这里就相当于shuffle操作
      //reduce是聚合操作，以上的语句可以简化
      println(List("I am so tired").flatMap(_.split(" ")).map((_,1)).map(_._2).reduce((x,y)=>x+y))
      //如果对集合中的元素进行操作时，需要注意的是如果集合中传递是一个元素的话就可以用_来代替
      //reduce端如果是xy其实y是不动的，也可以看成是一个参数也就可以演变成为下面的语句
      println(List("I am so tired").flatMap(_.split(" ")).map((_,1)).map(_._2).reduce(_+_))

      List(0,1,2,3,4).foreach(x=>println(x))
      List(0,1,2,3,4).foreach(println(_))
      List(0,1,2,3,4).foreach(println _)
      List(0,1,2,3,4).foreach(println)
      //具体的演变过程
  }


}
