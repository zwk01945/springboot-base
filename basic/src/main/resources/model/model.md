### 设计模式

##### 一、单例设计模式
    单例是当前类内，有当前类的引用或者实例，外部只能通过get方法获取。
    单例设计是为了保证jvm只存在当前的一个实例。
    分为懒汉式和饿汉式，饿汉式在判空的时候，存在线程安全的问题。
##### 二、简单工厂设计模式
    简单工厂是根据方法传入的不同参数自动创建所需要的对象。
    适用于一个系统初始化加载一些必要的组件，可以通过xml等文件读取，依次工厂加载
##### 三、工厂方法设计模式
    工厂方法是一个接口，工厂提供了通用的行为方法
    不同的接口实现，可以为自己的接口下创建自己的实现
##### 四、抽象工厂设计模式
    抽象工厂是保证一个工厂可以操作其他工厂的方法
    抽象工厂也是一个接口，接口内有别的工厂的创建对象的接口
##### 五、建造者设计模式
    建造者是一个方法的对象需要通过的不同的方式进行组装
##### 六、装饰者设计模式
    装饰者是在类内传入，需要装饰对象的接口
    接口去调用具体的传入对象的方法，并做出处理
##### 七、代理设计模式
    代理分静态代理和动态代理
    静态代理是有一个实现目标接口的类，该类在目标接口处理方法的前后
    可以进行对应的处理，比如缓存等
    动态代理是解决了，当多个接口需要代理的时候多个静态代理的问题，
    jdk提供了动态代理创建的方式，需要写一个InvocationHandler的实现类
    在invoke中写具体的代理逻辑
    调用如下：
        // 被代理类的接口
        Class<ProductInfo> productInfoClass = ProductInfo.class;
        // 代理类需要实现的接口
        Class[] classes = {productInfoClass};
        // 代理类调用的方法
        ProductInvokeHandler handler = new ProductInvokeHandler(new HuaWeiProductInfo());
        // 生成代理类
        ProductInfo o =(ProductInfo) Proxy.newProxyInstance(productInfoClass.getClassLoader(), classes,handler);
        // 调用代理方法
        o.getProductDetail(1);
    