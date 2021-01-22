package com.atguigu.utils.utils;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * world pdf工具类
 * @author spd
 */
public class WordToPdfUtils {

    private  final  static Logger logger = LoggerFactory.getLogger(WordToPdfUtils. class);


    public static void doc2pdf(String inPath,String outPath) {
        try {
            //新建一个空白pdf文档
            File file = new File(outPath);
            FileOutputStream os = new FileOutputStream(file);
            // 支持RTF HTML,OpenDocument, PDF,EPUB, XPS转换
            Document doc = new Document(inPath);
            try {
                doc.save(os, SaveFormat.PDF);
                os.close();
            } catch (Exception e) {
                logger.error("world转pdf异常",e.getMessage());
            }
        } catch (Exception e) {
            logger.error("文件异常：",e.getMessage());
        }
    }

    public static void doc2pdf(InputStream inputStream,String outPath) {
        try {
            //新建一个空白pdf文档
            File file = new File(outPath);
            FileOutputStream os = new FileOutputStream(file);
            //支持RTF HTML,OpenDocument, PDF,EPUB, XPS转换
            Document doc = new Document(inputStream);
            try {
                doc.save(os, SaveFormat.PDF);
                os.close();
            } catch (Exception e) {
                logger.error("world转pdf异常",e.getMessage());
            }
        } catch (Exception e) {
            logger.error("文件异常：",e.getMessage());
        }
    }


   public static void main(String[] args) {
        doc2pdf("C:/Users/Administrator/Desktop/电子健康卡/创业软件医院信息平台-_区县电子健康卡应用接口规范V1.1.doc","C:/Users/Administrator/Desktop/电子健康卡/创业软件医院信息平台-_区县电子健康卡应用接口规范V1.1.pdf");

       String substring = "ty.docx".substring(0, "ty.docx".indexOf("."));
       System.out.println(substring);
   }







}
