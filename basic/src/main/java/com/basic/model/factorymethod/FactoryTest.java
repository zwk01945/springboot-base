package com.basic.model.factorymethod;

import com.basic.model.ProductInfo;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 测试输入工厂名称，返回工厂,并调用方法
 * @author Administrator
 */
public class FactoryTest {

    public static void main(String[] args) {

        Set<String> factories = new LinkedHashSet<>();
        factories.add("com.basic.model.factorymethod.HuaWeiFactory");
        factories.add("com.basic.model.factorymethod.ViVoFactory");
        try {
            factories.forEach(f -> {
                try {
                    Class<?> clazz = Class.forName(f);
                    System.out.println("当前加载工厂为:" + clazz.getSimpleName());
                    FactoryMethod o =(FactoryMethod) clazz.newInstance();
                    ProductInfo productInfo = o.getProduct();
                    System.out.println("创建的产品为:" + (productInfo.getClass().getSimpleName()));
                    System.out.println("invoke调用");
                    productInfo.getProductDetail(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
