package com.example.pokedex_to_hexagonal.application.mapper;

import com.example.pokedex_to_hexagonal.application.dto.PokedexRequest;
import com.example.pokedex_to_hexagonal.domain.model.Photo;
import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Base64;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface PokedexRequestMapper {

    Pokemon toPokemon(PokedexRequest pokedexRequest);

    @Mapping(target = "photo", qualifiedByName = "base64ToByteArray")
    Photo toPhoto(PokedexRequest pokedexRequest);

    @Named("base64ToByteArray")
    static byte[] base64ToByteArray(String base64Photo){return Base64.getDecoder().decode(base64Photo);}


}
