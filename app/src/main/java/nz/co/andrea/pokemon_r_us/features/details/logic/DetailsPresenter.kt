package nz.co.andrea.pokemon_r_us.features.details.logic

import android.content.Context
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import nz.co.andrea.pokemon_r_us.R
import nz.co.andrea.pokemon_r_us.features.common.domain.PokemonDetail
import nz.co.andrea.pokemon_r_us.features.common.repository.PokemonRepository
import nz.co.andrea.pokemon_r_us.features.details.DetailsContract
import javax.inject.Inject

class DetailsPresenter @Inject internal constructor(
        private val pokemonRepository: PokemonRepository,
        private val context: Context
) {

    private lateinit var pokemonId: String

    private var disposable = CompositeDisposable()
    private var view: DetailsContract.View? = null
    private var pokemonDetail: PokemonDetail? = null

    fun connectView(view: DetailsContract.View, savedInstanceState: Bundle?, extras: Bundle?) {
        this.view = view

        if (savedInstanceState == null) {
            if (extras == null) {
                view.finishActivity()
                return
            }

            pokemonId = extras.getString("POKEMON_ID")
        } else {
            pokemonId = savedInstanceState.getString("POKEMON_ID")
            pokemonDetail = savedInstanceState.get("POKEMON_DETAILS") as PokemonDetail
        }

        init()
    }

    private fun init() {
        pokemonDetail?.let {
            displayPokemonDetails(it)
        } ?: loadPokemonDetails()
    }

    fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString("POKEMON_ID", pokemonId)
        outState?.putParcelable("POKEMON_DETAILS", pokemonDetail)
    }

    private fun loadPokemonDetails() {
        view?.showProgressDialog()

        disposable.add(pokemonRepository.getPokemonId(pokemonId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(({ this.handlePopularMoviesResponseSuccessful(it) }), ({ this.handleResponseError(it) })))
    }

    private fun handlePopularMoviesResponseSuccessful(pokemonDetail: PokemonDetail) {
        this.pokemonDetail = pokemonDetail
        displayPokemonDetails(pokemonDetail)
    }

    private fun displayPokemonDetails(pokemonDetail: PokemonDetail) {
        view?.let {
            it.hideProgressDialog()

            it.renderName(pokemonDetail.name)
            it.renderImage(pokemonDetail.sprites.frontDefault)
            it.renderHeightLabel(context.getString(R.string.height_label))
            val height = pokemonDetail.height.toString() + " feet"
            it.renderHeight(height)
            it.renderWeightLabel(context.getString(R.string.weight_label))
            val weight = pokemonDetail.weight.toString() + " lbs"
            it.renderWeight(weight)
        }
    }

    private fun handleResponseError(error: Throwable) = view?.let {
        it.hideProgressDialog()
        it.showErrorDialog("Error", error.message
                ?: "Unable to retrieve data, please try again later.")
    }
}