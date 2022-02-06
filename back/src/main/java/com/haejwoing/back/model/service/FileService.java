package com.haejwoing.back.model.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void fileInsert(MultipartFile[] file);
}
