package com.example.pokedex_to_hexagonal.domain.api;

import com.example.pokedex_to_hexagonal.domain.model.Photo;

import java.util.List;

public interface IPhotoServicePort {

    void savePhoto(Photo photo);

    List<Photo> getAllPhoto();

    Photo getPhoto(Long photoNumber);

    void updatePhoto(Photo photo);

    void deletePhoto(Long photo);

}
