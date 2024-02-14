package com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.repository;

import com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.entity.PhotoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPhotoRepository extends MongoRepository<PhotoEntity,String> {
}
