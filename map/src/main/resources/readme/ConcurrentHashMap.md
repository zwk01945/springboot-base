### ConcurrentHashMap的使用

- ConcurrentHashMap的继承关系<br>
    ConcurrentHashMap是abstractMap的子类，并且实现了ConcurrentMap、Serializable接口
- ConcurrentHashMap核心成员变量<br>
    MAXIMUM_CAPACITY  桶的最大值 1>>30        
    DEFAULT_CAPACITY  默认的桶大小   16            
    MAX_ARRAY_SIZE    Integer.MAX_VALUE - 8         
    DEFAULT_CONCURRENCY_LEVEL      16
    LOAD_FACTOR   默认负载因子0.75
    TREEIFY_THRESHOLD  红黑树转换阀值 8
- 构造方法 
- 内部类  
### ConcurrentHashMap高并发场景的使用
    address 
    https://blog.csdn.net/programmer_at/article/details/79715177?utm_medium=distribute.pc_relevant_right.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant_right.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase