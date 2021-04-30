package com.basic.model.proxy;

import com.basic.model.ProductInfo;

import java.util.HashMap;
import java.util.Map;

/**
 *  主题详情和列表代理类
 * @author Administrator
 */
public class ProductInfoProxy implements ProductInfo {

    private Map<Object,Object> cache = new HashMap<>(10);
    private ProductInfo proxy;

    public ProductInfoProxy(Map<Object, Object> cache) {
        this.cache = cache;
    }

    public ProductInfoProxy(ProductInfo proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object getProductDetail(Object proId) {
        if (cache.get(proId) != null){
            System.out.println("从缓存中拿");
            cache.remove(proId);
            return 1;
        }
        System.out.println("从代理对象中拿");
        proxy.getProductDetail(1);
        cache.put(proId,"主题1");
        return 0;
    }

    @Override
    public Object getProductList(Map<String, Object> mapQuery) {
        return null;
    }
}
