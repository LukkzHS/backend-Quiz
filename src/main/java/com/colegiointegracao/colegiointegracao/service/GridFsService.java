package com.colegiointegracao.colegiointegracao.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class GridFsService {

    @Autowired
    private GridFSBucket gridFSBucket;

    public ObjectId storeFile(InputStream inputStream, String fileName, String contentType) {
        GridFSUploadOptions options = new GridFSUploadOptions()
                .chunkSizeBytes(358400)
                .metadata(new org.bson.Document("type", contentType));

        return gridFSBucket.uploadFromStream(fileName, inputStream, options);
    }

    public InputStream getFile(ObjectId id) {
        return gridFSBucket.openDownloadStream(id);
    }
}