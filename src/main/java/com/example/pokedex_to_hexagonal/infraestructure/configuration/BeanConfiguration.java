package com.example.pokedex_to_hexagonal.infraestructure.configuration;

import com.example.pokedex_to_hexagonal.domain.api.IPhotoServicePort;
import com.example.pokedex_to_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_to_hexagonal.domain.spi.IPhotoPersistencePort;
import com.example.pokedex_to_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_to_hexagonal.domain.usecase.PhoteUseCase;
import com.example.pokedex_to_hexagonal.domain.usecase.PokemonUseCase;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.adapter.PokemonJpaAdapter;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper.PokemonEntityMapper;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository.IPokemonRespository;
import com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.adapter.PhotoMongodbAdapter;
import com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.mapper.PhotoEntityMapper;
import com.example.pokedex_to_hexagonal.infraestructure.output.mongodb.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPokemonRespository pokemonRespository;
    private final PokemonEntityMapper pokemonEntityMapper;
    private final IPhotoRepository photoRepository;
    private final PhotoEntityMapper photoEntityMapper;

    @Bean
    public IPokemonPersistencePort pokemonPersistencePort(){
        return new PokemonJpaAdapter(pokemonRespository,pokemonEntityMapper);
    }

    @Bean
    public IPokemonServicePort pokemonServicePort(){
        return new PokemonUseCase(pokemonPersistencePort()); //1:54 Explican esto
    }

    @Bean
    public IPhotoPersistencePort photoPersistencePort(){
        return new PhotoMongodbAdapter(photoRepository,photoEntityMapper);
    }

    @Bean
    public IPhotoServicePort photoServicePort(){
        return new PhoteUseCase(photoPersistencePort()); //1:54 Explican esto
    }

}
