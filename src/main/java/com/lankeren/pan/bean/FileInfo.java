package com.lankeren.pan.bean;

import java.time.LocalTime;

/**
 * @author lankeren
 * @ClassName FileInfo
 * @Deacription:
 * @create: 2020-11-03 20:50
 */
public class FileInfo {
    private String fileName ;
    private Integer fileSize ;
    private LocalTime uploadTime ;

    public FileInfo() {
    }

    public FileInfo(String fileName, Integer fileSize) {
        this.uploadTime = null;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public FileInfo(String fileName, Integer fileSize, LocalTime uploadTime) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.uploadTime = uploadTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public LocalTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalTime uploadTime) {
        this.uploadTime = uploadTime;
    }
}
