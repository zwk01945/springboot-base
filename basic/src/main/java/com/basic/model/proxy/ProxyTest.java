package com.basic.model.proxy;

import com.basic.model.HuaWeiProductInfo;

/**
 * 静态代理类测试
 * @author Administrator
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 被代理对象
        HuaWeiProductInfo huaWeiProductInfo = new HuaWeiProductInfo();
        // 代理对象
        ProductInfoProxy proxy = new ProductInfoProxy(huaWeiProductInfo);
        // 调用代理对象的方法
        proxy.getProductDetail(1);
    }
}
