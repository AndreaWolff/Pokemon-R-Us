package nz.co.andrea.pokemon_r_us.features.common.repository;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonDao {
    @GET("pokemon/") Single<PokemonsDto> getPokemons();

    @GET("pokemon/{pokemon_id}") Single<PokemonDetailsDto> getPokemonId(@Path("pokemon_id") String id);
}
