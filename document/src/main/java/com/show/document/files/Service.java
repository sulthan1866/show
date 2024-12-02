package com.show.document.files;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repo repo;

    public void upload(MultipartFile file) throws IOException {
        Document document = new Document();
        document.setData(file.getBytes());
        document.setName(file.getOriginalFilename());
        repo.save(document);
    }

    public Document getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Document> getAllFiles() {
        return repo.findAll()
                .stream()
                .map(doc -> new Document(doc.getId(), doc.getName(), doc.getData()))
                .collect(Collectors.toList());
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
