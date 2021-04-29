package com.basic.model;


/**
 * 简单工厂模式
 *  容易开闭原则，对固定的工厂可以使用
 * @author Administrator
 */
public class SimpleFactory {

    /**
     *  根据传入的产品类型获取对应的产品对象
     * @param type
     * @return
     */
    public static ProductInfo getProduct(Integer type) {
        if (type == 1) {
            return new HuaWeiProductInfo();
        }
        if (type == 2) {
            return new ViVoProductInfo();
        }
        return null;
    }


    /**
     * 测试简单工厂
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(SimpleFactory.getProduct(1).getProductDetail(1));
    }
}
