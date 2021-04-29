package com.basic.model.abstractFactory;


import com.basic.model.HuaWeiProductOption;
import com.basic.model.ProductInfo;
import com.basic.model.ProductOption;
import com.basic.model.ViVoProductInfo;

/**
 * 制作者工厂
 * @author Administrator
 */
public class MakerFactory implements AbstractFactory{
    @Override
    public ProductInfo getProductInfo() {
        return new ViVoProductInfo();
    }

    @Override
    public ProductOption getProductOption() {
        return new HuaWeiProductOption();
    }
}
