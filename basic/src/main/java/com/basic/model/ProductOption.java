package com.basic.model;

/**
 * 产品增加和删除以及修改主题
 * @author Administrator
 */
public interface ProductOption {


    /**
     * 增加产品
     * @param obj
     * @return
     */
    long addProduct(Object obj);

    /**
     * 删除产品
     * @param obj
     * @return
     */
    long removeProduct(Object obj);

    /**
     * 修改产品
     * @param obj
     * @return
     */
    long geditProduct(Object obj);

}
