package com.basic.model.factorymethod;

import com.basic.model.ProductInfo;

/**
 * 工厂方法
 * @author Administrator
 */
public interface FactoryMethod {

    /**
     * 获取产品
     * @return
     */
    ProductInfo getProduct();

}
