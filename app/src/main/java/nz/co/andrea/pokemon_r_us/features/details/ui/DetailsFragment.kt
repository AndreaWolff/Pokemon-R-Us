package nz.co.andrea.pokemon_r_us.features.details.ui

import android.app.AlertDialog
import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import nz.co.andrea.pokemon_r_us.R
import nz.co.andrea.pokemon_r_us.application.PokemonApplication
import nz.co.andrea.pokemon_r_us.dagger.component.DaggerDetailsComponent
import nz.co.andrea.pokemon_r_us.databinding.FragmentDetailsBinding
import nz.co.andrea.pokemon_r_us.features.details.DetailsContract
import nz.co.andrea.pokemon_r_us.features.details.logic.DetailsPresenter
import nz.co.andrea.pokemon_r_us.util.GlideUtil
import javax.inject.Inject

class DetailsFragment : Fragment(), DetailsContract.View {

    private lateinit var binding: FragmentDetailsBinding
    @Inject lateinit var presenter: DetailsPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.fragment_details, container, false)

        binding = DataBindingUtil.setContentView(activity, R.layout.fragment_details)

        DaggerDetailsComponent.builder()
                .appComponent(PokemonApplication.getDagger())
                .build()
                .inject(this)

        presenter.connectView(this, savedInstanceState, activity.intent.extras)

        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    // region View methods
    override fun renderName(name: String) {
        binding.pokemonName.text = name
    }

    override fun renderImage(image: String) = GlideUtil.displayImage(image, binding.pokemonImage)

    override fun renderHeight(height: String) {
        binding.pokemonHeight.text = height
    }

    override fun renderWeight(weight: String) {
        binding.pokemonWeight.text = weight
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

    override fun showProgressDialog() {
        binding.detailsProgressBar.visibility = VISIBLE
    }

    override fun hideProgressDialog() {
        binding.detailsProgressBar.visibility = GONE
        binding.contentView.visibility = VISIBLE
    }

    override fun renderHeightLabel(label: String) {
        binding.pokemonHeightLabel.text = label
    }

    override fun renderWeightLabel(label: String) {
        binding.pokemonWeightLabel.text = label
    }

    override fun finishActivity() = activity.finish()
    // endregion
}