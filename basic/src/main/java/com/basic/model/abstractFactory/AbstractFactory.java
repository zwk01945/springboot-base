package com.basic.model.abstractFactory;

import com.basic.model.ProductInfo;
import com.basic.model.ProductOption;

/**
 * 抽象工厂
 * @author Administrator
 */
public interface AbstractFactory {

    /**
     * 获取详情和列表
     * @return
     */
    ProductInfo getProductInfo();

    /**
     * 增加删除和修改
     * @return
     */
    ProductOption getProductOption();


}
