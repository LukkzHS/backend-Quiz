package com.colegiointegracao.colegiointegracao.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final String databaseName = "back";
    private final String connectionString = "mongodb+srv://myAtlasDBUser:XcNixIjtQaHi3q1g@myatlasclusteredu.8iwrr.mongodb.net";

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(connectionString);
    }

    @Bean
    public GridFsTemplate gridFsTemplate(MongoDatabaseFactory mongoDatabaseFactory, MappingMongoConverter mappingMongoConverter) {
        return new GridFsTemplate(mongoDatabaseFactory, mappingMongoConverter);
    }

    @Bean
    public GridFSBucket gridFSBucket(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        return GridFSBuckets.create(database);
    }
}
