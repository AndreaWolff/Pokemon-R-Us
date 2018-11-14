package nz.co.andrea.pokemon_r_us.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides
import nz.co.andrea.pokemon_r_us.application.PokemonApplication
import javax.inject.Singleton

@Module
class AppModule(
        private val application: PokemonApplication
) {
    @Singleton @Provides fun context(): Context = application.applicationContext
}