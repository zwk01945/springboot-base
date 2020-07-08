### HashMap的使用

- hashmap的继承关系<br>
    hashmap是abstractMap的子类，并且实现了Map、cloneAble、Serializable接口
    
- hashmap核心成员变量<br>

    1.DEFAULT_INITIAL_CAPACITY   默认初始化桶数组大小为 1<<4
    2.MAXIMUM_CAPACITY     桶最大值为 1<<30   
    3.DEFAULT_LOAD_FACTOR  默认加载因子 0.75   
    4.TREEIFY_THRESHOLD   链表转换为红黑树的阀值    
    5.Node<K,V>[] table   存放真正数据的数组       
    6.Set<Map.Entry<K,V>> entrySet 存放节点的集合     
    
- 构造方法    
    1.HashMap(int initialCapacity, float loadFactor) <br>
        如果初始化桶小于0 抛异常，如果超过最大值，则赋值为最大，负载因子小于0或者不是浮点数
        抛出异常，最后根据桶大小计算出红黑树阀值，赋值本地负载因子
    2.HashMap(int initialCapacity)    <br>
        调用上一个方法，传入默认的负载因子
    3.HashMap() <br>
        赋值this.loadfactor   
    4.HashMap(Map<? extends K, ? extends V> m)         
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
- 内部类  
    1.Node<K,V>           
        final int hash;
        final K key;
        V value;
        Node<K,V> next;              
    2.EntrySet    
        包括一些Node节点的遍历
- put和get、resize方法          
    1.put方法    
    调用put方法
        
       public V put(K key, V value) 
        {
          return putVal(hash(key), key, value, false, true);
        }
        
    putVal方法    
    
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                           boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                1.判断当前桶是否为空，空的就需要初始化（resize 中会判断是否进行初始化）。
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                2.根据当前 key 的 hashcode 定位到具体的桶中并判断是否为空，为空表明没有 Hash 冲突就直接在当前位置创建一个新桶即可。
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k;
                    3.如果当前桶有值（ Hash 冲突），那么就要比较当前桶中的 key、key 的 hashcode 与写入的 key 是否相等，相等就赋值给 e,在第 8 步的时候会统一进行赋值及返回。
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    4.如果当前桶为红黑树，那就要按照红黑树的方式写入数据。    
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                     5.如果是个链表，就需要将当前的 key、value 封装成一个新节点写入到当前桶的后面（形成链表）。
                        for (int binCount = 0; ; ++binCount) {
                        6.接着判断当前链表的大小是否大于预设的阈值，大于时就要转换为红黑树。
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            7.如果在遍历过程中找到 key 相同时直接退出遍历。
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    8.如果 e != null 就相当于存在相同的 key,那就需要将值覆盖。
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                9.最后判断是否需要进行扩容。
                ++modCount;
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null;
            }
    
    2.get方法             
    调用get方法
    
        public V get(Object key) {
                Node<K,V> e;
                return (e = getNode(hash(key), key)) == null ? null : e.value;
            }
    getNode方法
    
        final Node<K,V> getNode(int hash, Object key) {
                Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
                首先将 key hash 之后取得所定位的桶。
                if ((tab = table) != null && (n = tab.length) > 0 &&
                    (first = tab[(n - 1) & hash]) != null) {
                    判断桶的第一个位置(有可能是链表、红黑树)的 key 是否为查询的 key，是就直接返回 value。
                    if (first.hash == hash && // always check first node
                        ((k = first.key) == key || (key != null && key.equals(k))))
                        return first;
                    如果第一个不匹配，则判断它的下一个是红黑树还是链表。
                    if ((e = first.next) != null) {
                        红黑树就按照树的查找方式返回值。
                        if (first instanceof TreeNode)
                            return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                        不然就按照链表的方式遍历匹配返回值。
                        do {
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                return e;
                        } while ((e = e.next) != null);
                    }
                }
                如果桶为空则直接返回 null 。
                return null;
            }
           
    3.resize方法    
        改方法自行查看,resize方虽然在jdk1.8解决了多线程下的尾插法环形问题，但是还会有cpu高的问题。
                       
            
            
    


