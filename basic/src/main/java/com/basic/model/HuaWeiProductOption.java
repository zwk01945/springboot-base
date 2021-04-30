package com.basic.model;

/**
 * Huawei产品增加和删除以及修改主题
 * @author Administrator
 */
public class HuaWeiProductOption implements ProductOption{


    @Override
    public long addProduct(Object obj) {
        System.out.println("HuaWei添加产品");
        return 0;
    }

    @Override
    public long removeProduct(Object obj) {
        System.out.println("HuaWei删除产品");
        return 0;
    }

    @Override
    public long geditProduct(Object obj) {
        System.out.println("HuaWei修改产品");
        return 0;
    }
}
