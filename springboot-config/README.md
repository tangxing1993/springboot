## springboot配置文件详解

** 配置文件支持yml和properties两种,自己选择 **

### 自定义属性的加载和配置

1. 定义一个属性类,容器化bean（@component）
2. 在属性类的字段上使用@value注解，注解值为"${配置文件中自定义的属性值}"
3. 在配置文件中引用已经被定义的属性
4. 使用springboot测试自定义的属性是否被加载

### 使用随机数 ${random}

1. ${random.value}随机字符串值
2. ${random.int}随机整形值
3. ${random.long}随机long值
4. ${random.int(10)}10以内的整型值
5. ${random.int[10,20]}10到20的整形值

### 命令行给配置文件赋值

1. java -jar xxxx.jar --server.port=8888等价于在application.properties中赋值

### 设置不同的开发环境

1. 定义属性文件application-{开发模式}.properties,配置该模式下的属性
2. 在通用的application.properties环境中指定开发模式application.profiles.active=开发模式
3. 对某一接口指定开发模式，在该实现类上指定@profile(开发模式)注解

