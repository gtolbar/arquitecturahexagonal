package com.example.pokedex_to_hexagonal.domain.model;

public class Pokemon {

    private Long id;
    private String name;
    private Long number;
    private String photoId;

    public Pokemon(Long id, String name, Long number, String photoId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", photoId=" + photoId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
