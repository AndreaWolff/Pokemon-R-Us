package nz.co.andrea.pokemon_r_us.features.common.repository;

import com.google.gson.annotations.SerializedName;

import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon;

class PokemonDto {

    @SerializedName("name") private String name;
    @SerializedName("url") private String image;

    Pokemon toPokemons() {
        return new Pokemon(name, image);
    }
}
