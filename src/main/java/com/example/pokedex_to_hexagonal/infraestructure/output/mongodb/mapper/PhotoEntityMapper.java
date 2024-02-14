package com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.mapper;

import com.example.pokedex_to_hexagonal.domain.model.Photo;
import com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.entity.PhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface PhotoEntityMapper {

    PhotoEntity toEntity(Photo photo);

    Photo toPhoto(PhotoEntity photoEntity);

    List<Photo> toPhotoList(List<PhotoEntity> photoEntityList);

}
