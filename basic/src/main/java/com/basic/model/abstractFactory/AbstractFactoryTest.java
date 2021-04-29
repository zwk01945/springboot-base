package com.basic.model.abstractFactory;


import com.basic.model.ProductInfo;
import com.basic.model.ProductOption;
import com.basic.model.factorymethod.FactoryMethod;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 抽象工厂测试
 * @author Administrator
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        Set<String> factories = new LinkedHashSet<>();
        factories.add("com.basic.model.abstractFactory.DesignerFactory");
        factories.add("com.basic.model.abstractFactory.MakerFactory");
        try {
            factories.forEach(f -> {
                try {
                    Class<?> clazz = Class.forName(f);
                    System.out.println("当前加载工厂为:" + clazz.getSimpleName());
                    AbstractFactory o =(AbstractFactory) clazz.newInstance();
                    ProductInfo productInfo = o.getProductInfo();
                    ProductOption productOption = o.getProductOption();
                    System.out.println("创建的产品列表为:" + (productInfo.getClass().getSimpleName()));
                    productInfo.getProductDetail(1);
                    System.out.println("创建的修改删除增加为:" + (productOption.getClass().getSimpleName()));
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
