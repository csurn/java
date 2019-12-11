package com.example.demo.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        String fileName = "static/index.html";
        HttpHeaders responseHeaders = new HttpHeaders();
        String content = null;
        responseHeaders.setContentType(MediaType.TEXT_HTML);
        try {
            File file = new File(fileName);
            Resource resource = null;
            if (file.exists()) {
                resource = new FileSystemResource(file);
            } else {
                resource = new ClassPathResource(fileName);
            }
            byte[] data = FileCopyUtils.copyToByteArray(resource.getInputStream());
            content = new String(data, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            content = e.getMessage();
        }
        return new ResponseEntity<String>(content, responseHeaders, HttpStatus.NOT_FOUND);
    }

}
