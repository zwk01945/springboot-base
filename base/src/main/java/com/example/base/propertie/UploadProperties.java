package com.example.base.propertie;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * ClassName: SysProperties <br/>
 * Description: 系统配置
 * date: 2020/7/15 14:30<br/>
 *
 * @author zwk
 */
@Configuration
@ConfigurationProperties(prefix = "upload")
@PropertySource(value = "classpath:sys.properties")
public class UploadProperties {

    private String winPath;
    private String winPathZip;
    private String winBakPath;
    private String winBakErrorPath;
    private String linuxPath;
    private String linuxPathZip;
    private String linuxBakPath;
    private String linuxBakErrorPath;

    public String getLinuxPath() {
        return linuxPath;
    }

    public void setLinuxPath(String linuxPath) {
        this.linuxPath = linuxPath;
    }

    public String getLinuxPathZip() {
        return linuxPathZip;
    }

    public void setLinuxPathZip(String linuxPathZip) {
        this.linuxPathZip = linuxPathZip;
    }

    public String getLinuxBakPath() {
        return linuxBakPath;
    }

    public void setLinuxBakPath(String linuxBakPath) {
        this.linuxBakPath = linuxBakPath;
    }

    public String getLinuxBakErrorPath() {
        return linuxBakErrorPath;
    }

    public void setLinuxBakErrorPath(String linuxBakErrorPath) {
        this.linuxBakErrorPath = linuxBakErrorPath;
    }

    public String getWinPath() {
        return winPath;
    }

    public void setWinPath(String winPath) {
        this.winPath = winPath;
    }

    public String getWinPathZip() {
        return winPathZip;
    }

    public void setWinPathZip(String winPathZip) {
        this.winPathZip = winPathZip;
    }

    public String getWinBakPath() {
        return winBakPath;
    }

    public void setWinBakPath(String winBakPath) {
        this.winBakPath = winBakPath;
    }

    public String getWinBakErrorPath() {
        return winBakErrorPath;
    }

    public void setWinBakErrorPath(String winBakErrorPath) {
        this.winBakErrorPath = winBakErrorPath;
    }
}
