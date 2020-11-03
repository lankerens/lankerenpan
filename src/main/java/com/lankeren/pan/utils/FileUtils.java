package com.lankeren.pan.utils;

import com.lankeren.pan.bean.FileInfo;
import com.lankeren.pan.constant.Constants;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author lankeren
 * @ClassName FileUtils
 * @Deacription:
 * @create: 2020-11-03 17:23
 */
public class FileUtils {

    /**
     * 检查后缀
     *
     * @return
     */
    public static boolean fileTypeCheck(String suf) {
        for (String val : Constants.fileTypes) {
            if (val.equals(suf)) return false;
        }
        return true;
    }

    public static boolean hasSameName(String name) {
        File file = new File(Constants.savePath);
        for (String val : file.list()) {
            if (val.equals(name)) return true;
        }
        return false;
    }

    public static List<FileInfo> getFileInfoMap() {
        File file = new File(Constants.savePath);
        List<FileInfo> list = new ArrayList<>();
        FileInputStream fis = null;
        try {
            for (File f : file.listFiles()) {
                fis = new FileInputStream(f);
                list.add(new FileInfo(f.getName(), fis.available()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
