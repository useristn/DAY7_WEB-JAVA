package bai7.thymeleaf.service.impl;

import bai7.thymeleaf.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${upload.path}")
    private String uploadDir;

    @Override
    public String storeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir, filename);

        // Tạo thư mục nếu chưa tồn tại
        Files.createDirectories(path.getParent());

        // Lưu file
        file.transferTo(path.toFile());

        // trả về đường dẫn (có thể convert sang URL nếu cần)
        return "/uploads/" + filename;
    }
}
