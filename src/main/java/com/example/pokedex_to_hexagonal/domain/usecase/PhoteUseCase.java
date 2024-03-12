package com.example.pokedex_to_hexagonal.domain.usecase;

import com.example.pokedex_to_hexagonal.domain.api.IPhotoServicePort;
import com.example.pokedex_to_hexagonal.domain.model.Photo;
import com.example.pokedex_to_hexagonal.domain.spi.IPhotoPersistencePort;

import java.util.List;

public class PhoteUseCase implements IPhotoServicePort {

    private final IPhotoPersistencePort photoPersistencePort;

    public PhoteUseCase(IPhotoPersistencePort photoPersistencePort) {
        this.photoPersistencePort = photoPersistencePort;
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoPersistencePort.savePhoto(photo);
    }

    @Override
    public List<Photo> getAllPhoto() {
        return photoPersistencePort.getAllPhoto();
    }

    @Override
    public Photo getPhoto(String photoNumber) {
        return photoPersistencePort.getPhoto(photoNumber);
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoPersistencePort.updatePhoto(photo);
    }

    @Override
    public void deletePhoto(String photoId) {
        photoPersistencePort.deletePhoto(photoId);
    }
}
