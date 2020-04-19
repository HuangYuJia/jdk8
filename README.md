## jdk8
- Function默认方法有compose、andThen  接收一个参数返回一个结果
-     compose先计算传入,再计算本身
-     andThen先计算本身,再计算传入
- BiFunction默认方法只有andThen  接收两个参数返回一个结果
-     andThen先计算本身,再计算传入

- 实现类的优先级要比接口的优先级更高一些.

- 什么情况下使用方法引用:lambda表达式只有一行代码,
- 并且这行代码恰好调用的方法是已经存在的,
- 那么就可以使用方法引用来替代lamda表达式!
- 方法引用是lambda表达式的一种特殊用法

- 方法引用 method reference
- 方法引用实际上是一个Lambda表达式的一种语法糖

- 我们可以将方法引用看做是一个(函数指针)，function pointer

- classname::staticmethod
- classname.static

- 方法引用共分为四类:
- 1.类名::静态方法名
- 2.引用名(对象名)::实例方法名
- 3.类名::实例方法名
- 4.构造方法引用: 类名::new

- Stream 流
- 流由三部分组成
- 1.源
- 2.零个或多个中间操作
- 3.终止操作

- 流操作的分类
- 惰性求值
- 及早求值

- stream.xxx().yyy().zzz().count()

- max() mix()返回 Optional sum() 返回 int,因为有可能没有最大值和最小值,而没有值的话sum()得出的结果为0

- parallelStream 并行流
- stream 串行流

- map和flatmap的区别
- 数组中有多个数组时,map映射的结果还是数组中存在多个数组,而flatMap映射的结果是把数组中的所有数组打平成一个数组并返回该数组


- select name from student where age > 20 and address = "beijing" order by age desc;
- stream和mysql一样都是描述性的语言
- students.stream().filter(student -> student.getAge() > 20).filter(student -> student.getAddress()
- .equals("beijing)).sort().forEach(student -> System.out.println(student.getName()));

- 内部迭代: stream 
- 外部迭代: 传统的for循环 

- 集合关注的是数据与数据存储本身
- 流关注的则是对数据的计算

- 流与迭代器类似的一点是:流是无法重复使用或消费的

- 中间操作都会返回一个Stream对象,比如说返回Stream<Student>,Stream<Integer>,Stream<String>
- 终止操作则不会返回Stream类型,可能没有返回值,也可能返回其他类型的单个值

- 并行不一定比串行快，它涉及到线程之间的切换
- jdk8函数式编程或lamada表达式针对一个问题有多种解决方法，通用选择规则，越具体的方法越好！
- mapToInt等具体方法使得jdk8不会对原生的类型进行自动的拆装箱等违反性能的操作

- 分组: group by
- 分区: partition by


- 流的特点:流的短路,和&& || 一样,遇到满足的条件就不往后执行了