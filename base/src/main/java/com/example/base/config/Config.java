package com.example.base.config;

import com.example.base.date.DateConstant;
import com.example.base.date.DateUtil;
import com.example.base.propertie.ImageProperties;
import com.example.base.propertie.UploadProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * ClassName: Config <br/>
 * Description: 配置
 * date: 2020/7/15 14:52<br/>
 *
 * @author zwk<br />
 */
@Configuration
public class Config {

    private static Logger log = LoggerFactory.getLogger(Config.class);

    public static final String SYS_NAME_WIN = "win";
    public static final String SYS_NAME_LINUX = "linux";

    /** 系统文件下载配置 */
    @Autowired
    UploadProperties uploadProperties;
    /** 图片服务器 */
    @Autowired
    ImageProperties imageProperties;

    @Bean(value = "globalConfig")
    public void config() {
        log.info("全局系统配置如下============================");
        log.info("当前系统时间为:{}", DateUtil.getStrByDate(new Date(), DateConstant.YYYY_MM_DD_HH_MM_SS));
        log.info("下载上传配置如下:");
        log.info("win环境:{},{},{},{}", uploadProperties.getWinPath(),
                uploadProperties.getWinPathZip(),
                uploadProperties.getWinBakPath(),
                uploadProperties.getWinBakErrorPath());
        log.info("linux环境:{},{},{},{}",uploadProperties.getLinuxPath(),uploadProperties.getLinuxPathZip(),
                uploadProperties.getLinuxBakPath(),
                uploadProperties.getLinuxBakErrorPath());
        log.info("图片服务器配置如下:");
        log.info("ip,port,path:{},{},{}",imageProperties.getServerIp(),
                imageProperties.getServerPort(),
                imageProperties.getServerPath());
    }


}
