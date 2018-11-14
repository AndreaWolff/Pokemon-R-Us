package nz.co.andrea.pokemon_r_us.features.main.logic

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon
import nz.co.andrea.pokemon_r_us.features.common.repository.PokemonRepository
import nz.co.andrea.pokemon_r_us.features.details.ui.DetailsActivity
import nz.co.andrea.pokemon_r_us.features.main.MainContract
import java.util.*
import javax.inject.Inject

class MainPresenter @Inject internal constructor(
        private val pokemonRepository: PokemonRepository,
        private val context: Context
) {

    private var disposable = CompositeDisposable()
    private var view: MainContract.View? = null

    fun connectView(view: MainContract.View) {
        this.view = view

        init()
    }

    private fun init() = loadPokemons()

    fun pokemonSelected(pokemon: Pokemon) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("POKEMON_ID", pokemon.id)

        view?.navigateToPokemonDetails(intent)
    }

    fun disconnectView() {
        view = null
    }

    private fun loadPokemons() {
        view?.showProgressDialog()

        disposable.add(pokemonRepository.getPokemons()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(({ this.handlePopularMoviesResponseSuccessful(it) }), ({ this.handleResponseError(it) })))
    }

    private fun handlePopularMoviesResponseSuccessful(pokemons: List<Pokemon>) = view?.let {
        it.hideProgressDialog()
        it.showPokemons(pokemons)
    }

    private fun handleResponseError(error: Throwable) = view?.let {
        it.hideProgressDialog()
        it.showErrorDialog("Error",error.message ?: "Unable to retrieve data, please try again later.")
    }
}