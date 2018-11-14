package nz.co.andrea.pokemon_r_us.features.common.repository;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon;

class PokemonsDto {

    @SerializedName("results") private List<PokemonDto> pokemonDto;

    List<Pokemon> toPokemonResult() {
        List<Pokemon> pokemons = new ArrayList<>();
        for (PokemonDto dto : pokemonDto) {
            pokemons.add(dto.toPokemons());
        }

        return pokemons;
    }
}
