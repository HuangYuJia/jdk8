## jdk8
- Function默认方法有compose、andThen  接收一个参数返回一个结果
-     compose先计算传入,再计算本身
-     andThen先计算本身,再计算传入
- BiFunction默认方法只有andThen  接收两个参数返回一个结果
-     andThen先计算本身,再计算传入