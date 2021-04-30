package com.basic.model.builder;


import com.basic.model.Theme;

/**
 * 主题抽象类
 * @author Administrator
 */
public abstract class ThemeBuilder {

    protected Theme theme = new Theme();

    /**
     * 设置主题名称
     */
    protected abstract void setThemeName();
    /**
     * 设置子主题名称
     */
    protected abstract void setSubThemeName();
    /**
     * 设置主题数量
     */
    protected abstract void setThemeCount();

    public Theme getTheme() {
        return theme;
    }
}
