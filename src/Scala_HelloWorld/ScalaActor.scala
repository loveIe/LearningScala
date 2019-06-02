package Scala_HelloWorld

import scala.actors.Actor

/**
  * scala并发编程：
  *    1.是通过Actor这个类来进行的操作
  *    2.要继承Actor这个类 复写act方法
  *    3.发送语句 子类！+ 发送的信息 必须回复消息是 !?
  *    4.receive是偏函数
  *    5.case class 作为消息传递
  *    6.sender这个参数作为返回信息的关键字传递消息
  */

class ScalaActor extends Actor {
    var counter = 0
    def act(): Unit ={
      while (true){
        receive{
          case content:String => println("Message:"+content)
          case Hello(name,content,sender) => {
            println("name"+name+" content"+content+counter)
            counter += 1
            sender ! HelloBack("BB",content+counter,this)
          }
        }
        Thread.sleep(3000)
      }
    }
}

class HelloBackActor(val helloActor:ScalaActor) extends Actor {
  var counter = 0
  def act(): Unit ={
    helloActor ! Hello("AA","Love is here",this)
    while (true){
      receive{
        case content:String => println("Message:"+content)
        case HelloBack(name,content,sender) => {
          println("name"+name+" content"+content+counter)
          counter += 1
          sender ! Hello("AA",content+counter,this)
        }
      }
      Thread.sleep(3000)
    }
  }
}

case class Hello(name:String,content:String,sender:Actor)
case class HelloBack(name:String,content:String,sender:Actor)

object ScalaActor {
def main(args: Array[String]): Unit = {
      var counter = 0
      val helloActor = new ScalaActor
      helloActor.start()
//      while(true) {
//        helloActor ! "Wow" + counter
//        counter += 1
//      }
//      helloActor ! Hello("Spark","Scala is worth")
      val helloBackActor = new HelloBackActor(helloActor)

      helloBackActor.start()
}

}
