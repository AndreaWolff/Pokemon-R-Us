package nz.co.andrea.pokemon_r_us.features.common.repository

import javax.inject.Inject

import io.reactivex.Single
import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon
import nz.co.andrea.pokemon_r_us.features.common.domain.PokemonDetail

class PokemonRepositoryDefault @Inject internal constructor(
        private val pokemonDao: PokemonDao
) : PokemonRepository {

    private var cachedPokemon: List<Pokemon>? = null

    override fun getPokemons(): Single<List<Pokemon>> {
        return if (cachedPokemon != null) {
            Single.just(cachedPokemon)
        } else pokemonDao.pokemons.map { pokemonResultDto ->
            cachedPokemon = pokemonResultDto.toPokemonResult()
            cachedPokemon
        }
    }

    override fun getPokemonId(id: String): Single<PokemonDetail> {
        return pokemonDao.getPokemonId(id).map(PokemonDetailsDto::toPokemonDetail)
    }
}
