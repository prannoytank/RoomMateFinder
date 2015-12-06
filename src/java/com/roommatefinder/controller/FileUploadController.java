/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.model.FileUpload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AshirwadTank
 */

@Controller
public class FileUploadController {
    
   @Autowired
   ServletConfig servletConfig;
    
    
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String crunchifyDisplayForm() {
        return "pages/home/uploadFile";
    }
 
    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
    public String crunchifySave(
            @ModelAttribute("uploadForm") FileUpload uploadForm,
            Model map) throws IllegalStateException, IOException {
        String saveDirectory = servletConfig.getServletContext().getRealPath("/")+"WEB-INF/";
        
        File f = new File(saveDirectory+"/adImages/1");
        if(f.exists() == false){
        f.mkdirs();
        }
        
        
        
	 // System.out.println(f.getPath());
        
        List<MultipartFile> crunchifyFiles = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
 
        if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
            for (MultipartFile multipartFile : crunchifyFiles) {
 
                String fileName = multipartFile.getOriginalFilename();
                long size = multipartFile.getSize();
                
                System.out.print((size/1024));
                if (!"".equalsIgnoreCase(fileName)) {
                    // Handle file content - multipartFile.getInputStream()
                    multipartFile.transferTo(new File(f.getPath() +"/" + fileName));
                    fileNames.add(fileName);
                }
            }
        }
 
        map.addAttribute("files", fileNames);
        return "pages/home/uploadSuccess";
    }
    
    
}
