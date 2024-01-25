package com.example.pokedex_to_hexagonal.application.handler;

import com.example.pokedex_to_hexagonal.application.dto.PokedexRequest;
import com.example.pokedex_to_hexagonal.application.dto.PokedexResponse;
import com.example.pokedex_to_hexagonal.application.maper.PokedexRequestMapper;
import com.example.pokedex_to_hexagonal.application.maper.PokedexResponseMapper;
import com.example.pokedex_to_hexagonal.domain.api.IPhotoServicePort;
import com.example.pokedex_to_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_to_hexagonal.domain.model.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PokedexHandler implements IPokedexHandler{

    private final IPokemonServicePort pokemonServicePort;
    private final IPhotoServicePort photoServicePort;
    private final PokedexRequestMapper pokedexRequestMapper;
    private final PokedexResponseMapper pokedexResponseMapper;

    @Override
    public void savePokemonInPokedex(PokedexRequest pokedexRequest) {

        Photo photo = photoServicePort.savePhoto(pokedexRequestMapper.toPhoto(pokedexRequest));
    }

    @Override
    public List<PokedexResponse> getAllPokemonFromPokedex() {
        return null;
    }

    @Override
    public PokedexResponse getPokemonFromPokedex(long pokemonNumber) {
        return null;
    }

    @Override
    public void updatePokemonInPokedex(PokedexRequest pokedexRequest) {

    }

    @Override
    public void deletePokemonFromPokedex(Long pokemonNumber) {

    }
}
