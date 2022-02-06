package com.haejwoing.back.model.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

@Slf4j
@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private ServletContext servletContext;

    @Override
    public void fileInsert(MultipartFile[] file) {
        if(!file[0].isEmpty()){
            for(int i=0; i<file.length; i++){
                log.info("파일 원본 이름 : {}",file[i]);

            }
        }
    }
}
