package com.basic.model.proxy;

import com.basic.model.HuaWeiProductInfo;
import com.basic.model.ProductInfo;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author Administrator
 */
public class ProHandlerTest {

    public static void main(String[] args) {
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
    }
}
