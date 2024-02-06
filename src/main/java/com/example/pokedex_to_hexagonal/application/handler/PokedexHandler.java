package com.example.pokedex_to_hexagonal.application.handler;

import com.example.pokedex_to_hexagonal.application.dto.PokedexRequest;
import com.example.pokedex_to_hexagonal.application.dto.PokedexResponse;
import com.example.pokedex_to_hexagonal.application.mapper.PokedexRequestMapper;
import com.example.pokedex_to_hexagonal.application.mapper.PokedexResponseMapper;
import com.example.pokedex_to_hexagonal.domain.api.IPhotoServicePort;
import com.example.pokedex_to_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_to_hexagonal.domain.model.Photo;
import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional //ACID principios
public class PokedexHandler implements IPokedexHandler{

    private final IPokemonServicePort pokemonServicePort;
    private final IPhotoServicePort photoServicePort;
    private final PokedexRequestMapper pokedexRequestMapper;
    private final PokedexResponseMapper pokedexResponseMapper;

    @Override
    public void savePokemonInPokedex(PokedexRequest pokedexRequest) {

        Photo photo = photoServicePort.savePhoto(pokedexRequestMapper.toPhoto(pokedexRequest));
        Pokemon pokemon = pokedexRequestMapper.toPokemon(pokedexRequest);
        pokemon.setPhotoId(photo.getId());
        pokemonServicePort.savePokemon(pokemon);

    }

    @Override
    public List<PokedexResponse> getAllPokemonFromPokedex() {
        return pokedexResponseMapper.toResponseList(pokemonServicePort.getAllPokemon(),photoServicePort.getAllPhoto());
    }

    @Override
    public PokedexResponse getPokemonFromPokedex(long pokemonNumber) {
        Pokemon pokemon = pokemonServicePort.getPokemon(pokemonNumber);
        return pokedexResponseMapper.toResponse(pokemon,photoServicePort.getPhoto(pokemon.getPhotoId()));
    }

    @Override
    public void updatePokemonInPokedex(PokedexRequest pokedexRequest) {

    }

    @Override
    public void deletePokemonFromPokedex(Long pokemonNumber) {

    }
}
