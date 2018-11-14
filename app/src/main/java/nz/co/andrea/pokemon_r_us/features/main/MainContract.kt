package nz.co.andrea.pokemon_r_us.features.main

import android.content.Intent
import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon

interface MainContract {
    interface View {
        fun showPokemons(pokemons: List<Pokemon>)
        fun navigateToPokemonDetails(intent: Intent)
        fun showProgressDialog()
        fun hideProgressDialog()
        fun showErrorDialog(errorTitle: String, errorMessage: String)
    }
}