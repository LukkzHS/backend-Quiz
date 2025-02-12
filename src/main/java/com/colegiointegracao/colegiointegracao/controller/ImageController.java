package com.colegiointegracao.colegiointegracao.controller;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final GridFsOperations gridFsOperations;

    @Autowired
    public ImageController(GridFsOperations gridFsOperations) {
        this.gridFsOperations = gridFsOperations;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
      try {
        if (!ObjectId.isValid(id)) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    
        GridFSFile file = gridFsOperations.findOne(
          new Query(Criteria.where("_id").is(new ObjectId(id)))
        );
    
        if (file == null) {
          System.out.println("Arquivo não encontrado para o ID: " + id);
          return ResponseEntity.notFound().build();
        }
    
        GridFsResource resource = gridFsOperations.getResource(file);
        String contentType = "image/jpeg";
        
        if (file.getMetadata() != null && file.getMetadata().containsKey("type")) {
          contentType = file.getMetadata().get("type").toString();
        }
    
        return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_TYPE, contentType)
          .header(HttpHeaders.CACHE_CONTROL, "no-store, max-age=0")
          .body(resource.getInputStream().readAllBytes());
    
      } catch (Exception e) {
        System.out.println("Erro ao buscar imagem com ID: " + id);
        e.printStackTrace();
        return ResponseEntity.internalServerError().build();
      }
    }
}