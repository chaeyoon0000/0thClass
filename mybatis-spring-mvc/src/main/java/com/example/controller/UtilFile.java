package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.view.AbstractView;
 

@Component
public class UtilFile extends AbstractView{
    String fileName = "";
    
//  프로젝트 내 지정된 경로에 파일을 저장하는 메소드
//  DB에는 업로드된 전체 경로명으로만 지정되기 때문에(업로드한 파일 자체는 경로에 저장됨)
//  fileUpload() 메소드에서 전체 경로를 리턴받아 DB에 경로 그대로 저장   
	/*
	 * private void uploadFile(MultipartFile filePath) {
	 * System.out.println("업로드 한 파일: " + filePath.getOriginalFilename()); File file
	 * = new File(this.uploadDir + filePath.getOriginalFilename());//this.uploadDir
	 * try { filePath.transferTo(file); } catch (IllegalStateException | IOException
	 * e) { e.printStackTrace(); } }
	 */
    public String fileUpload(MultipartHttpServletRequest request,
                                        MultipartFile uploadFile, Object obj) {
        String path = "";
        String fileName = "";
        
        OutputStream out = null;
        PrintWriter printWriter = null;
        
        try {
            fileName = uploadFile.getOriginalFilename();
            byte[] bytes = uploadFile.getBytes();
            path = getSaveLocation(request, obj);
            
            
            path = getSaveLocation(request, obj);
            
            System.out.println("UtilFile fileUpload fileName : " + fileName);
            System.out.println("UtilFile fileUpload uploadPath : " + path);
            
            File file = new File(path);
            
//          파일명이 중복으로 존재할 경우
            if (fileName != null && !fileName.equals("")) {
                if (file.exists()) {
//                    파일명 앞에 업로드 시간 초단위로 붙여 파일명 중복을 방지
                    fileName = System.currentTimeMillis() + "_" + fileName;
                    
                    file = new File(path + fileName);
                }
            }
            
            System.out.println("UtilFile fileUpload final fileName : " + fileName);
            System.out.println("UtilFile fileUpload file : " + file);
            
            out = new FileOutputStream(file);
            
            System.out.println("UtilFile fileUpload out : " + out);
            
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path + fileName;
    }
    
//  업로드 파일 저장 경로 얻는 메소드
//  업로드한 파일의 경로가 도메인 별로 달라야 했기 때문에 도메인의 형을 비교하여 파일 저장 정로를 다르게 지정함
    private String getSaveLocation(MultipartHttpServletRequest request, Object obj) {
        
        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        String attachPath = "..\\..\\resources\\";
//        String attachPath = "C:\\Users\\dongduk\\Desktop\\";
        System.out.println("UtilFile getSaveLocation path : " + uploadPath + attachPath);
        
//        return attachPath;
        return uploadPath + attachPath;
    }

    // download
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        
        setContentType("application/download; charset=utf-8");
        
        File file = (File) model.get("downloadFile");
        
        response.setContentType(getContentType());
        response.setContentLength((int) file.length()); 
        
        String header = request.getHeader("User-Agent");
        boolean b = header.indexOf("MSIE") > -1;
        String fileName = null;
        
        if (b) {
            fileName = URLEncoder.encode(file.getName(), "utf-8");
        } else {
            fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
        }
        
        response.setHeader("Conent-Disposition", "attachment); filename=\"" + fileName + "\";");
        response.setHeader("Content-Transter-Encoding", "binary");
        
        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(file);
            
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            
            out.flush();
        }
    }
    
////UtilFile 객체 생성
//  UtilFile utilFile = new UtilFile();
//  
////파일 업로드 결과값을 path로 받아온다(이미 fileUpload() 메소드에서 해당 경로에 업로드는 끝났음)
//  String uploadPath = utilFile.fileUpload(request, auctionCommand.getFilePath(), auction);
//  
////해당 경로만 받아 db에 저장
//  auction.setImage(uploadPath);
}