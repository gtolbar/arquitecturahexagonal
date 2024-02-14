package com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photo")
@Data
public class PhotoEntity {

    @Id
    private String id;
    private byte[] photo;

}
