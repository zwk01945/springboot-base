package com.basic.model.builder;


import com.basic.model.Theme;

/**
 * 主题建造者模式
 * @author Administrator
 */
public class BuilderTest {

    public static void main(String[] args) {
        ThemeManger themeManger = new ThemeManger(new HuaWeiSubThemeBuilder());
        Theme theme = themeManger.builderTheme();
        System.out.println(theme.toString());
    }
}
