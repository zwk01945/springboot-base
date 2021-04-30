package com.basic.model.decorator;

import com.basic.model.ProductInfo;

import java.util.Map;

/**
 *  具体构件
 * @author Administrator
 */
public class Component implements ProductInfo {
    @Override
    public Object getProductDetail(Object proId) {
        System.out.println("具体构件");
        return null;
    }

    @Override
    public Object getProductList(Map<String, Object> mapQuery) {
        return null;
    }
}
