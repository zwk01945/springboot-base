package com.basic.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *  动态代理类
 * @author Administrator
 */
public class ProductInvokeHandler implements InvocationHandler {

    private final Map<Object,Object> cache = new HashMap<>(10);
    private final Object subject;

    public ProductInvokeHandler(Object proxy) {
        this.subject = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置处理---------");
        if (cache.get(args[0]) != null) {
            System.out.println("从缓存中拿-----");
            return cache.get(args[0]);
        }
        Object invoke = method.invoke(subject, args);
        cache.put(args[0],invoke);
        return invoke;
    }

}
