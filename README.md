# -Java——天气信息的获取+数据库操作
## -使用的技术+简述自己实现的过程  

1.写了一个Weatherget类，用于对高德平台API的调用，根据它的API文档传入相对应的参数，得到天气预报的信息，转化为json对象作为结果返回。  

2.根据json的格式，编写了Forcast类和Castdata类，将json对象转化为java对象。  

3.创建了JDBCUtils工具类，实现了注册驱动、连接数据库和关闭资源的方法  

4.写了Operationdemo接口，和该接口的实现类OperationdemoImpl，实现了对数据库增添信息的方法和查询信息的方法。  




