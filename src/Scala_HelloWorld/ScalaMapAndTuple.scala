package Scala_HelloWorld



/**
  * 直接使用Map声明就可以，但是数据是不能修改，一旦修改就变成了新的MAP了
  * 如果想要更改数据需要导入包scala.collection.mutabl
  * 注意原生MAP不能实例化
  * 在获取Map的value时要使用getOrElse方法，在实际开发中这个方法特别重要，可以提供一个默认值，如果直接获得话如果为空会报错
  * 想要new的话必须使用Map子类
  * LinkedMAp在存放数据会记住数据的存放位置
  * tuple在企业级中使用比较多
  * 使用它作为函数的返回值
  * 所有的构造方法公有，私有都是在类创建的时候的创建
  * 在spark中缓存究竟占用内存的多少 ？？
  *
  *
  * spark使用伴生类和伴生对象的好处：
  *  1.伴生对象的成员，及成员方法可以公用
  *  2.伴生对象的工厂方法
  *  3.代码抽离。
  *  4.版本的更新迭代 个人感觉相当于测试类
  *  Lazy加载并不是在类创建的时候加载
  *  Spark的伴生对象并不是属于API的方法。
  *  类继承时，不会继承伴生对象
  *  类继承时， 成员变量和方法都属于类成员
  *  isInstanceOf asInstanceOf
  *  isInstanceOf是父类使用子类实例的某个方法时，判断是否是这个子类
  *  asInstanceOf是转换
  *
 */

object ScalaMapAndTuple {
  def main(args: Array[String]): Unit = {
       val bigData = Map(("Scala"->11),("Java" -> 23),("Hadoop" -> 11))
      //->相当于将Scala给key赋值
       for ((name,age) <- bigData) println(name + ":" + age)
       val personInformation = Map(("AA"-> 12),("BB" -> 13),("CC" -> 14))
       val language = scala.collection.mutable.Map("One"->"English","Two"->"Chinese")
       language("Two")="Japanese"
       for((order,lan)<-language)println(order+":"+lan)
       println(language.getOrElse("Three","None"))

       val person = new scala.collection.mutable.HashMap[String,Int]
      //如果不能使用+=给MAP添加值是因为没用子类的，需要new出子类来
      //使用SortedMap可以按照字典顺序排序
       person += ("Tang"->13)
       person += ("Li" -> 12)

       for(name <- person.keySet) println(name)
       for(age <- person.values) println(age)

       //如果想要从原有Map中构建新的Map使用yeild，yield是有返回值的
       val result = for((name,age)<-person) yield (age,name)
       for((age,name)<-result) println(age+":"+name)

       val information = (12,"Tang","I hava a Dream",'a')
       //这就是tuple数据类型，tuple数据类型可以存放多种类型数据，在读取时，需要指定位置
       println(information._3)
  }
}
