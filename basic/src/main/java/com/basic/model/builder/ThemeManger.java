package com.basic.model.builder;

import com.basic.model.Theme;


/**
 * 主题建造管理者
 * @author Administrator
 */
public class ThemeManger {

    private ThemeBuilder themeBuilder;

    public ThemeManger(ThemeBuilder themeBuilder) {
        this.themeBuilder = themeBuilder;
    }


    public Theme builderTheme() {
       themeBuilder.setThemeName();
       themeBuilder.setSubThemeName();
       themeBuilder.setThemeCount();
       return themeBuilder.getTheme();
    }

}
