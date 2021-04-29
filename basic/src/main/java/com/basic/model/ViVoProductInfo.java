package com.basic.model;

import java.util.Map;

/**
 * ViVO主题
 * @author Administrator
 */
public class ViVoProductInfo implements ProductInfo {
    @Override
    public Object getProductDetail(Object proId) {
        System.out.println("ViVo主题详情");
        return null;
    }

    @Override
    public Object getProductList(Map<String, Object> mapQuery) {
        System.out.println("ViVo主题列表");
        return null;
    }
}
