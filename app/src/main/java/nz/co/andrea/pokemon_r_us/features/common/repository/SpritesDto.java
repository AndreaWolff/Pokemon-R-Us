package nz.co.andrea.pokemon_r_us.features.common.repository;

import com.google.gson.annotations.SerializedName;

import nz.co.andrea.pokemon_r_us.features.common.domain.Sprites;

public class SpritesDto {

    @SerializedName("back_default") private String backDefault;
    @SerializedName("back_shiny") private String backShiny;
    @SerializedName("front_default") private String frontDefault;
    @SerializedName("front_shiny") private String frontShiny;

    Sprites toSprites() {
        return new Sprites(
                backDefault,
                backShiny,
                frontDefault,
                frontShiny
        );
    }
}
