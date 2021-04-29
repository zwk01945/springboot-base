package com.basic.model.factorymethod;

import com.basic.model.HuaWeiProductInfo;
import com.basic.model.ProductInfo;

/**
 * 华为主题工厂
 * @author Administrator
 */
public class HuaWeiFactory implements FactoryMethod {
    @Override
    public ProductInfo getProduct() {
        return new HuaWeiProductInfo();
    }
}
