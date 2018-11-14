package nz.co.andrea.pokemon_r_us.dagger.component

import android.content.Context
import dagger.Component
import nz.co.andrea.pokemon_r_us.dagger.module.AppModule
import nz.co.andrea.pokemon_r_us.dagger.module.NetModule
import nz.co.andrea.pokemon_r_us.features.common.repository.PokemonRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {
    fun getContext(): Context

    fun getPokemonRepository(): PokemonRepository
}