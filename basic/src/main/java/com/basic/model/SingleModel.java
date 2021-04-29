package com.basic.model;

/**
 * 单例设计模式
 * @author Administrator
 */
public class SingleModel {

    private  static final SingleModel SINGLE_MODEL = new SingleModel();
    private  static SingleModel SINGLE_MODEL_LAZY = null;

    /**
     * 饿汉式
     * @return
     */
    public static SingleModel getSingleModel() {
        return SINGLE_MODEL;
    }

    /**
     * 懒汉式
     * @return
     */
    public static SingleModel getSingleModelLazy() {
        if (SINGLE_MODEL_LAZY == null) {
            SINGLE_MODEL_LAZY = new SingleModel();
        }
        return SINGLE_MODEL_LAZY;
    }

}
