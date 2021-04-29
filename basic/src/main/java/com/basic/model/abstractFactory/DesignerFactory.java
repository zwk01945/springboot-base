package com.basic.model.abstractFactory;

import com.basic.model.HuaWeiProductInfo;
import com.basic.model.ProductInfo;
import com.basic.model.ProductOption;
import com.basic.model.ViVoProductOption;

/**
 * 设计者工厂
 * @author Administrator
 */
public class DesignerFactory implements AbstractFactory{
    @Override
    public ProductInfo getProductInfo() {
        return new HuaWeiProductInfo();
    }

    @Override
    public ProductOption getProductOption() {
        return new ViVoProductOption();
    }
}
