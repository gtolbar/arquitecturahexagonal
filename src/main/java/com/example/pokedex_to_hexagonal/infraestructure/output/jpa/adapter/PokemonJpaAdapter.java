package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.adapter;

import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import com.example.pokedex_to_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_to_hexagonal.infraestructure.exception.PokemonAlreadyExistsException;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository.IPokemonRespository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PokemonJpaAdapter implements IPokemonPersistencePort {

    private final IPokemonRespository pokemonRespository;

    private final PokemonJpaAdapter pokemonJpaAdapter;

    @Override
    public void savePokemon(Pokemon pokemon) {
        if(pokemonRespository.findByNumber(pokemon.getNumber()).isPresent()){
            throw new PokemonAlreadyExistsException();
        }
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return null;
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return null;
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {

    }

    @Override
    public void deletePokemon(Long pokemon) {

    }
}
