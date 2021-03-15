package com.example.word.util;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类
 *
 * @author 汪永晖
 * @Date 2021/3/15 15:23
 */
public class DocUtil {

    public static String readDoc(String filePath, InputStream is) throws IOException {
        String text = "";
        is = FileMagic.prepareToCheckMagic(is);
        try {
            if (FileMagic.valueOf(is) == FileMagic.OLE2) {
                WordExtractor ex = new WordExtractor(is);
                text = ex.getText();
                ex.close();
            } else if (FileMagic.valueOf(is) == FileMagic.OOXML) {
                XWPFDocument doc = new XWPFDocument(is);
                XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
                text = extractor.getText();
                extractor.close();
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return text;
    }
}
