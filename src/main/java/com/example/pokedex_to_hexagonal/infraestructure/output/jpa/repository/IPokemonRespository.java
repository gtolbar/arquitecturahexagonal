package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository;

import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPokemonRespository extends JpaRepository<PokemonEntity,Long> {

    Optional<PokemonEntity> findByNumber(Long aLong); // opcional si esta en base de datos sin sacar null

    void deleteByNumber(Long pokemonNumber);

}
