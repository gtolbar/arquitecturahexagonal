package com.example.pokedex_to_hexagonal.infraestructure.input.rest;

import com.example.pokedex_to_hexagonal.application.dto.PokedexRequest;
import com.example.pokedex_to_hexagonal.application.dto.PokedexResponse;
import com.example.pokedex_to_hexagonal.application.handler.IPokedexHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokedex")
@RequiredArgsConstructor
public class PokedexRestController {

    private final IPokedexHandler pokedexHandler;

    @PostMapping("/")
    public ResponseEntity<Void> savePokemonInPokedex(@RequestBody PokedexRequest pokedexRequest){
        pokedexHandler.savePokemonInPokedex(pokedexRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<PokedexResponse>> getAllPokemonFromPokedex(){
        return ResponseEntity.ok(pokedexHandler.getAllPokemonFromPokedex());
    }

    @GetMapping("/{number}")
    public ResponseEntity<PokedexResponse> getPokemonFromPokedex(@PathVariable(name = "number") Long pokemonNumber){
        return ResponseEntity.ok(pokedexHandler.getPokemonFromPokedex(pokemonNumber));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updatePokemonInPokedex(@RequestBody PokedexRequest pokedexRequest){
        pokedexHandler.updatePokemonInPokedex(pokedexRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deletePokemonInPokedex(@PathVariable(name = "number") Long pokemonNumber){
        pokedexHandler.deletePokemonFromPokedex(pokemonNumber);
        return ResponseEntity.noContent().build();
    }

}
