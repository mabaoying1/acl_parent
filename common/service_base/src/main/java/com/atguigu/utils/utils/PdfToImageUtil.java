package com.atguigu.utils.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  pdf转图片工具类
 * @author spd
 */
public class PdfToImageUtil {
    private  final  static Logger logger = LoggerFactory.getLogger(PdfToImageUtil. class);

    /**
     * dpi越大转换后越清晰，相对转换速度越慢
     */
    private static final Integer DPI = 110;

    /**
     * 转换后的图片类型
     */
    private static final String IMG_TYPE = "png";

    /**
     * PDF转图片
     *
     * @param PdfFilePath pdf完整路径
     * @param dstImgFolder 图片存放的文件夹
     * @return 图片文件的
     */
    public static List<File> pdfToImage( String PdfFilePath, String dstImgFolder){
        try {
            File file = new File(PdfFilePath);
            String imgPDFPath = file.getParent();
            int dot = file.getName().lastIndexOf('.');
            // 获取图片文件名
            String imagePDFName = file.getName().substring(0, dot);
            String imgFolderPath = null;
            if (dstImgFolder.equals("")) {
                // 获取图片存放的文件夹路径
                imgFolderPath = imgPDFPath + File.separator + imagePDFName;
            } else {
                imgFolderPath = dstImgFolder + File.separator + imagePDFName;
            }
            File dir = new File(imgFolderPath);
            if (!dir.exists()){
                dir.mkdirs();
            }
            PDDocument document = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(document);
            StringBuffer imgFilePath = null;
            List<File>  files = new ArrayList<>();
            for (int i = 0; i < document.getNumberOfPages(); ++i) {
                String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
                imgFilePath = new StringBuffer();
                imgFilePath.append(imgFilePathPrefix);
                imgFilePath.append("_");
                imgFilePath.append(String.valueOf(i + 1));
                imgFilePath.append(".png");
                File dstFile = new File(imgFilePath.toString());
                BufferedImage image = renderer.renderImageWithDPI(i, DPI);
                ImageIO.write(image, IMG_TYPE, dstFile);
                files.add(dstFile);
            }
            return files;
        }catch (Exception e){
            logger.error(e.getMessage());

        }

        return Collections.emptyList();
    }


    public static void main(String[] args) {
       List<File> files = pdfToImage("C:/Users/Administrator/Desktop/电子健康卡/创业软件医院信息平台-_区县电子健康卡应用接口规范V1.1.pdf", "C:/Users/Administrator/Desktop/电子健康卡/");
    }









}
