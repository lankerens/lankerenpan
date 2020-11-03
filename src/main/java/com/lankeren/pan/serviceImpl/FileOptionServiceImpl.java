package com.lankeren.pan.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.lankeren.pan.bean.FileInfo;
import com.lankeren.pan.constant.Constants;
import com.lankeren.pan.service.FileOptionService;
import com.lankeren.pan.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @author lankeren
 * @ClassName FileOptionImpl
 * @Deacription:
 * @create: 2020-11-03 17:18
 */
@Service
public class FileOptionServiceImpl implements FileOptionService {

    @Override
    public Object uploadFile(MultipartFile[] files) {
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            assert filename != null;
            String suffix = filename.substring(filename.lastIndexOf(".") + 1);
            try {
                if (FileUtils.fileTypeCheck(suffix) || FileUtils.hasSameName(filename)) {
                    // 不合法
                    return "失败了";
                }
                file.transferTo(new File(Constants.savePath + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "成功啦";
    }

    @Override
    public JSONObject getFileList() {
        JSONObject response = new JSONObject();
        response.put("code", 0);
        response.put("msg", "");
        List<FileInfo> list = FileUtils.getFileInfoMap();
        response.put("count", list.size());
        response.put("data", list);
        return response;
    }

    @Override
    public Object download(String fileName, HttpServletResponse response) {
        // 未使用到
        String filePath = Constants.savePath + fileName;
        File file = new File(filePath);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            byte[] buff = new byte[is.available()];
            is.read(buff);
            os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buff);
            // 清空缓冲区
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}
