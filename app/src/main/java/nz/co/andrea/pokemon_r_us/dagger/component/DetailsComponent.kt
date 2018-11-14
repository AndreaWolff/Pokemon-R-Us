package nz.co.andrea.pokemon_r_us.dagger.component

import dagger.Component
import nz.co.andrea.pokemon_r_us.dagger.module.DetailsModule
import nz.co.andrea.pokemon_r_us.dagger.scope.PerActivity
import nz.co.andrea.pokemon_r_us.features.details.ui.DetailsFragment

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [DetailsModule::class])
interface DetailsComponent {
    fun inject(fragment: DetailsFragment)
}