package com.basic.model;


import java.util.Map;

/**
 * 主题详情和列表的获取
 * @author Administrator
 */
public interface ProductInfo {

    /**
     * 获取产品的详情
     * @param proId 产品ID
     * @return
     */
    Object getProductDetail(Object proId);

    /**
     * 根据查询条件获取产品的列表
     * @param mapQuery
     * @return
     */
    Object getProductList(Map<String,Object> mapQuery);

}
