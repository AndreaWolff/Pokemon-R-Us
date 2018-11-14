package nz.co.andrea.pokemon_r_us.features.main.ui

import android.app.AlertDialog
import android.app.Fragment
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import nz.co.andrea.pokemon_r_us.R
import nz.co.andrea.pokemon_r_us.application.PokemonApplication.getDagger
import nz.co.andrea.pokemon_r_us.dagger.component.DaggerMainComponent
import nz.co.andrea.pokemon_r_us.databinding.FragmentMainBinding
import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon
import nz.co.andrea.pokemon_r_us.features.main.MainContract
import nz.co.andrea.pokemon_r_us.features.main.logic.MainPresenter
import javax.inject.Inject

class MainFragment : Fragment(), MainContract.View, PokemonAdapter.ListItemClickListener {

    private lateinit var binding: FragmentMainBinding
    @Inject lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.fragment_main, container, false)

        binding = DataBindingUtil.setContentView(activity, R.layout.fragment_main)

        DaggerMainComponent.builder()
                .appComponent(getDagger())
                .build()
                .inject(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.isNestedScrollingEnabled = false

        presenter.connectView(this)

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disconnectView()
    }

    override fun onListItemClicked(pokemon: Pokemon) {
        presenter.pokemonSelected(pokemon)
    }

    // region View methods
    override fun showPokemons(pokemons: List<Pokemon>) {
        val adapter = PokemonAdapter(pokemons, this)
        binding.recyclerView.adapter = adapter
    }

    override fun navigateToPokemonDetails(intent: Intent) = startActivity(intent)

    override fun showProgressDialog() {
        binding.mainProgressBar.visibility = VISIBLE
    }

    override fun hideProgressDialog() {
        binding.mainProgressBar.visibility = GONE
        binding.contentView.visibility = VISIBLE
    }

    override fun showErrorDialog(errorTitle: String, errorMessage: String) {
        val builder = AlertDialog.Builder(activity)
                .setTitle(errorTitle)
                .setMessage(errorMessage)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    // do nothing
                }
        builder.create()
        builder.show()
    }
    // endregion
}