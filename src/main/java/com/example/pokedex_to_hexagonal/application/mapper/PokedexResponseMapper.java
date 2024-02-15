package com.example.pokedex_to_hexagonal.application.mapper;

import com.example.pokedex_to_hexagonal.application.dto.PokedexResponse;
import com.example.pokedex_to_hexagonal.domain.model.Photo;
import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface PokedexResponseMapper {

    @Mapping(target = "photo",qualifiedByName = "byteArrayToBase64" )
    PokedexResponse toResponse(Pokemon pokemon, Photo photo);
    // investigar sobre programacion funcional

    @Named("byteArrayToBase64")
    static String byteArrayToBase64(byte[] byteArrayPhoto){
        return Base64.getEncoder().encodeToString(byteArrayPhoto);
    }

    default List<PokedexResponse> toResponseList(List<Pokemon> pokemonList, List<Photo> photoList){

        return pokemonList.stream()
                .map(pokemon -> {
                    PokedexResponse pokedexResponse = new PokedexResponse();
                    pokedexResponse.setNumber(pokemon.getNumber());
                    pokedexResponse.setName(pokemon.getName());
                    pokedexResponse.setPhoto(byteArrayToBase64(photoList.stream()
                            .filter(photo -> photo.getId().equals(pokemon.getPhotoId()))
                            .findFirst()
                            .orElse(null)
                            .getPhoto()));
                    return pokedexResponse;
                }).toList();
    }


}
