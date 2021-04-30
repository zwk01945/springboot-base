package com.basic.model.decorator;


/**
 * 装饰者模式测试
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        // 原构件  不允许被继承
        Component component = new Component();
        component.getProductDetail(1);
        System.out.println("============新增测试功能=========");
        Decorator decorator = new Decorator(component);
        decorator.getProductDetail(1);
    }
}
