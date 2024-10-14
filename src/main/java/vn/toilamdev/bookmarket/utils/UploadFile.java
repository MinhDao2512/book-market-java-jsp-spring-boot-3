package vn.toilamdev.bookmarket.utils;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadFile {
    private final ServletContext servletContext;

    public UploadFile(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveFile(MultipartFile multipartFile, String directory) {
        String fileName = "";
        if (multipartFile.getOriginalFilename() == "" || multipartFile.getOriginalFilename() == null) {
            return fileName;
        }

        try {
            byte[] bytes = multipartFile.getBytes();
            String rootPath = this.servletContext.getRealPath("/resources/images");
            File rootDirectory = new File(rootPath + File.separator + directory);
            if (rootDirectory.exists()) {
                rootDirectory.mkdirs();
            }
            fileName = System.currentTimeMillis() + "-" + multipartFile.getOriginalFilename();
            File currentFile = new File(rootDirectory + File.separator + fileName);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(currentFile));
            stream.write(bytes);
            stream.close();
            return fileName;
        } catch (IOException e) {
            return null;
        }
    }
}
