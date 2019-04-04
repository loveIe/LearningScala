package Scala_HelloWorld

/**
  * Scala中基本的控制结构有三种：条件，循环，顺序，但是也有一些高级流程匹配
  */
object ScalaControlStructures {
  def main(args: Array[String]): Unit = {

    var age = 30
    var isWorker = if(age > 35) "worker" else "student"
    //scala中 if是有值，和java不一样，它是根据if条件表达式来决定值
    println(isWorker)

    var result = if (age < 30) "student" else  0
    //if可以进行类型推导，推导的过程就是根据变量值的类型确定变量的类型
    println(result)

    val result2 = if(age > 19) "Adult"   else () //()表示unix类型 如果省略else默认实现是返回 else()所以if值类型可能有所改变
    //这里result2推导类型是Any 因为后面跟的是Unix类型  Unix类型使用的是()来表示的
    println(result2)

    var x,y = 0
    val result3 = if (age >20){
      x = x + 1
      y = y + 1
      x + y
    }else 0
    //如果if有多条语句，就用{}包括起来，并且最后一行的值就是if的值
    println(result3)


    for(i <- 0 to 5 if i == 2){
      println(i)
    }
    //if也可以优化for循环语句

    var flag = true
    var sum = 0
    for(i <- 0 to 6 if flag ){
      sum = sum + i
      if(i==5) flag = false
    }
    //if后语句只有一句的话，就可以直接写上，不需要加上{}
    println(sum)

    //for循环后面如果也只有一句话的时候和上面的if是一样的
    for (item <- "spark" )
      println(item)



//    sum = 0
//    for(i <- 0 to 6  ){
//      sum +=  i
//      if(i==5) return //return 返回是方法级别的，也就是返回到main上面
//    }
//    //if后语句只有一句的话，就可以直接写上，不需要加上{}
//    println(sum)

      flag=true
      while(flag){
        for(item <- "spark"){
          println(item)
          if(item=='r')
            flag=false
        }
      }
      //while循环一般被使用在server和framework中，实际使用为单个线程不停循环
      //在这个while中因为是嵌套了for循环，那么for循环是一定要完成的，所以说全部都打印
      //如果想要达到效果需要如下的解释


      import scala.util.control.Breaks._
      flag=true
      breakable{
        while(flag){
          for(item <- "spark"){
            println(item)
            if(item == 'r' ){
              flag=false
              break
            }
          }
        }
      }
      //在此例中如果想要让程序返回就得使用break，使用break就需要导包
  }






}
