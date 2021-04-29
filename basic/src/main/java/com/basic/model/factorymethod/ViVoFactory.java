package com.basic.model.factorymethod;

import com.basic.model.ProductInfo;
import com.basic.model.ViVoProductInfo;

/**
 * Vivo工厂
 * @author Administrator
 */
public class ViVoFactory implements FactoryMethod{
    @Override
    public ProductInfo getProduct() {
        return new ViVoProductInfo();
    }
}
