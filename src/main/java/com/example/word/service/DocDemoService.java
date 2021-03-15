package com.example.word.service;

import com.example.word.util.DocUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 汪永晖
 * @Date 2021/3/15 15:32
 */
public class DocDemoService {

    public static void main(String[] args) throws IOException {
        String path = "F:\\demo.doc";
        InputStream is = new FileInputStream(path);
        System.out.println("内容 = " + DocUtil.readDoc(path, is));
    }
}
