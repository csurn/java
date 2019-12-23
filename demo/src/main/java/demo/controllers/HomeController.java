package demo.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class HomeController {

    @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        String fileName = "static/index.html";
        String content = null;
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
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(content);
    }

}
