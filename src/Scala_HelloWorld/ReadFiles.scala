package Scala_HelloWorld

import java.io._

import scala.io.Source


@SerialVersionUID(100)  class MySpark(val name:String) extends  Serializable


object ReadFiles extends App {

    val Ms = new MySpark("Scala")

    def serialize[T](obj:T):Array[Byte]={
      val ois = new ByteArrayOutputStream()
      val oos = new ObjectOutputStream(ois)
      oos.writeObject(oos)
      oos.close()
      ois.toByteArray
    }
    //文件
//    def serialize[T](obj:T):Array[Byte]={
//      val ois = new FileOutputStream("D:/readme.txt")
//      val oos = new ObjectOutputStream(ois)
//      oos.writeObject(oos)
//      oos.close()
//      ois.toByteArray
//   }
    println(serialize(Ms))

    def deSerialize[T](bytes:Array[Byte]): T = {
      val bis = new ByteArrayInputStream(bytes)
      val ois = new ObjectInputStream(bis)
      ois.readObject().asInstanceOf[T]
    }
//    读取文件的方法
//    Source.fromFile("D:/readme.txt").getLines().mkString
      for (item <- Source.fromFile("D:/readme.txt").getLines()) println(item)



}
