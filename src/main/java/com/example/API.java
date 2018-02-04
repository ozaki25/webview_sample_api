package com.example;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class API {
    @Autowired
    private ImageRepository repository;

    @PostMapping
    public Image upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", baos);
        byte[] file = baos.toByteArray();
        Image image = new Image(file);
        return repository.save(image);
    }

    @GetMapping(value = "{id}.jpg", produces = MediaType.IMAGE_JPEG_VALUE + ";Content-Disposition=attachment")
    public byte[] download(@PathVariable Long id) {
        Image image = repository.findOne(id);
        return image.getFile();
    }
}
