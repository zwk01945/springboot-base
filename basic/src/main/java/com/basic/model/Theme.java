package com.basic.model;


/**
 * 主题类
 * @author Administrator
 */
public class Theme {

    private String themeName;

    private Integer themeCount;

    private String subThemeName;

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Integer getThemeCount() {
        return themeCount;
    }

    public void setThemeCount(Integer themeCount) {
        this.themeCount = themeCount;
    }

    public String getSubThemeName() {
        return subThemeName;
    }

    public void setSubThemeName(String subThemeName) {
        this.subThemeName = subThemeName;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "themeName='" + themeName + '\'' +
                ", themeCount=" + themeCount +
                ", subThemeName='" + subThemeName + '\'' +
                '}';
    }
}
