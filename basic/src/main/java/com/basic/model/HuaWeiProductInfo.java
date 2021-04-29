package com.basic.model;

import java.util.Map;

/**
 * 华为主题
 * @author Administrator
 */
public class HuaWeiProductInfo implements ProductInfo {
    @Override
    public Object getProductDetail(Object proId) {
        System.out.println("华为的主题详情");
        return 1;
    }

    @Override
    public Object getProductList(Map<String, Object> mapQuery) {
        System.out.println("华为的主题列表");
        return 2;
    }
}
