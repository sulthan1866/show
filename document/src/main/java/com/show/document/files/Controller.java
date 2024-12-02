package com.show.document.files;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/documents/upload")
    public ResponseEntity<HttpStatus> upload(@RequestBody MultipartFile file) {
        try {
            service.upload(file);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (IOException e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> files = service.getAllFiles();
        return ResponseEntity.ok(files);
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getById(@PathVariable int id) {
        Document document = service.getById(id);

        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @DeleteMapping("/documents/{id}")
    public ResponseEntity<HttpStatus> DeleteById(@PathVariable int id) {
        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello world !", HttpStatus.OK);
    }

}
