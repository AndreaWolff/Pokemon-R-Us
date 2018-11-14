package nz.co.andrea.pokemon_r_us.features.common.repository

import io.reactivex.Single
import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon
import nz.co.andrea.pokemon_r_us.features.common.domain.PokemonDetail

interface PokemonRepository {
    fun getPokemons(): Single<List<Pokemon>>

    fun getPokemonId(id: String): Single<PokemonDetail>
}