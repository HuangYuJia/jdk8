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