//package Scala_HelloWorld
//
///**
//  * scala中类，函数，方法都可以使用泛型
//  * scala中上边界符号 <：定义了类型必须是某种类的子类，类型限定
//  * scalca中下边界符号 :> 定义了类型必须是某种类的父类
//  * view Bounds <% 可以进行某种神秘的转换，在使用的类型没有知觉的情况下转换成为目标类型，view Bounds是上边界和下边界的加强版本
//  * 在SparkCore的SparkContext这个Spark核心类就有T<%Writable 所表达的是T必须是Writable类型，但是T并没有直接继承Wriatble这时
//  * 需要 implicit来进行隐式转换
//  * 逆变和协变： -T +T Exp：如果一个子类可以有的动作，父类也可以有 叫做逆变
//  * 父类有的动作，子类也有叫做协变
//  * T：classTag 是一种类型转换系统在RDD抽象类中，只是在编译时类型信息不够充分，需要借助于JVM的runtime来通过运行时信息获取完整信息
//  * Contxet Bounds T:ordering 必须能够变成Ordering[T] 这种方式 / ordering是进行比较的重要类
//  *
//  */
//
//class Animal[T](val species : T){
//  def getAnimal(species:T):T = species
//}
//
//class Engineer
//class Expert extends Engineer
////class Meeting[-T]
//class Meeting[+T]
//class Person(val name:String){
//  def talk(person:Person): Unit ={
//    println(this.name+":"+person.name)
//  }
//}
//
//class Worker(name:String) extends Person(name)
//
//class Dog( val name:String)
////类中的变量必须声明
//
//class Club[T <: Person](p1:T,p2:T){
//  p1.talk(p2)
//}
//
//class MaxNum[T:Ordering](val x:T,val y:T){
//  def bigger(implicit ord : Ordering[T]): Unit ={
//      if(ord.compare(x,y)>0) x else y
//  }
//}
//
//object ScalaTypeSystem {
//  def main(args: Array[String]): Unit = {
//      implicit def dog2Person(dog:Dog) = new Person(dog.name)
//      val p = new Person("AA")
//      val w = new Worker("BB")
//      val d = new Dog("CC")
//      new Club(p,w)
//      new Club[Person](p,d) //如果这里不写泛型Person的话,那么就会报错，原因，JVM没有泛型，如果不加泛型，那么类型擦除后是Object类型不是Person类型
////      val e = new Meeting[Engineer]
////      partition(e)
//      //这里是逆变
////      val ex = new Meeting[Expert]
////      partition(ex)
//      //这里是协变
//      new MaxNum("Scala","Java").bigger
//      //
//  }
//
//  def partition(meeting:Meeting[Engineer]){
//      println("Welcome")
//  }
//}
