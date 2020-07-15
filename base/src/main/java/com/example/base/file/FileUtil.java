package com.example.base.file;

import com.example.base.config.Config;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * ClassName: FileUtils <br/>
 * Description: 文件下载工具类
 * date: 2020/7/15 16:11<br/>
 *
 * @author zwk<br />
 */
public class FileUtil {

    private static Logger log  = LoggerFactory.getLogger(FileUtil.class);

    public static String getSysPath(String winPath,String linuxPath) {
        StringBuilder sb = new StringBuilder();
        if (SystemUtils.OS_NAME.toLowerCase().startsWith(Config.SYS_NAME_WIN)) {
            sb.append(FilenameUtils.normalizeNoEndSeparator(winPath));
        } else {
            sb.append(FilenameUtils.normalizeNoEndSeparator(winPath));
        }
        sb.append(File.separator);
        return sb.toString();
    }

    /**
     * 创建文件夹
     * @param dirName 文件夹名字
     * @return
     */
    public static File creatDir(String dirName) {
        File dir = new File(dirName);
        if (!dir.exists()) {
            if (!dirName.endsWith(File.separator)) {
                dirName = dirName + File.separator;
            }
            if (dir.mkdirs()) {
                log.info("创建文件夹成功");
            } else {
                log.info("创建文件夹失败");
            }
        }
        return dir;
    }


    /**
     * 复制文件
     * @param fromFile 源文件
     * @param toPath 复制到路径
     * @return
     */
    public static boolean copyFile(File fromFile,String toPath){
        creatDir(FilenameUtils.getFullPath(toPath));
        try {
            FileUtils.copyFile(fromFile,new File(toPath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 源文件不存在则创建文件
     * @param fileName
     */
    public static void creatFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建新文件
     * @param fileName 文件名称
     */
    public static void creatFileNew(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
