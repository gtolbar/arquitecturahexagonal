package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.adapter;

import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import com.example.pokedex_to_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_to_hexagonal.infraestructure.exception.NoDataFoundException;
import com.example.pokedex_to_hexagonal.infraestructure.exception.PokemonAlreadyExistsException;
import com.example.pokedex_to_hexagonal.infraestructure.exception.PokemonNotFoundException;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.PokemonEntity;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper.PokemonEntityMapper;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository.IPokemonRespository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PokemonJpaAdapter implements IPokemonPersistencePort {

    private final IPokemonRespository pokemonRespository;

    private final PokemonEntityMapper pokemonEntityMapper;

    @Override
    public void savePokemon(Pokemon pokemon) {
        if(pokemonRespository.findByNumber(pokemon.getNumber()).isPresent()){
            throw new PokemonAlreadyExistsException();
        }
        pokemonRespository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        List<PokemonEntity> pokemonEntityList = pokemonRespository.findAll();
        if(pokemonEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return pokemonEntityMapper.toPokemonList(pokemonEntityList);
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonEntityMapper.toPokemon(pokemonRespository.findByNumber(pokemonNumber)
                .orElseThrow(PokemonNotFoundException::new));
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonRespository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public void deletePokemon(Long pokemon) {
        pokemonRespository.deleteByNumber(pokemon);
    }
}
