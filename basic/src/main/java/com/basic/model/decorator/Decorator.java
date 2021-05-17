package com.basic.model.decorator;

import com.basic.model.ProductInfo;
import java.util.Map;


/**
 * 抽象装饰
 * @author Administrator
 */
public class Decorator implements ProductInfo {

    private final ProductInfo productInfo;

    public Decorator(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    @Override
    public Object getProductDetail(Object proId) {
        System.out.println("装饰者测试");
        return productInfo.getProductDetail(proId);
    }

    @Override
    public Object getProductList(Map<String, Object> mapQuery) {
        return productInfo.getProductList(mapQuery);
    }
}
