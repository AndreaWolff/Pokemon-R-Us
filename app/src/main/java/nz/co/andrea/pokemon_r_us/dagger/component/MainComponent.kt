package nz.co.andrea.pokemon_r_us.dagger.component

import dagger.Component
import nz.co.andrea.pokemon_r_us.dagger.module.MainModule
import nz.co.andrea.pokemon_r_us.dagger.scope.PerActivity
import nz.co.andrea.pokemon_r_us.features.main.ui.MainFragment

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
interface MainComponent {
    fun inject(fragment: MainFragment)
}