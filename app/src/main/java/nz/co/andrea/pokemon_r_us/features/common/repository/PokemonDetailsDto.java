package nz.co.andrea.pokemon_r_us.features.common.repository;

import com.google.gson.annotations.SerializedName;

import nz.co.andrea.pokemon_r_us.features.common.domain.PokemonDetail;

public class PokemonDetailsDto {

    @SerializedName("height") private int height;
    @SerializedName("name") private String name;
    @SerializedName("sprites") private SpritesDto spritesDto;
    @SerializedName("weight") private int weight;

    PokemonDetail toPokemonDetail() {
        return new PokemonDetail(
                height,
                name,
                spritesDto.toSprites(),
                weight);
    }
}
