package nz.co.andrea.pokemon_r_us.dagger.module

import dagger.Module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import dagger.Provides
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import nz.co.andrea.pokemon_r_us.features.common.repository.PokemonDao
import nz.co.andrea.pokemon_r_us.features.common.repository.PokemonRepository
import nz.co.andrea.pokemon_r_us.features.common.repository.PokemonRepositoryDefault

@Module
class NetModule(
        private val BASE_URL: String
) {
    @Singleton @Provides fun okHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

    @Singleton @Provides fun retrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()

    @Singleton @Provides fun pokemonDao(retrofit: Retrofit): PokemonDao = retrofit.create(PokemonDao::class.java)

    @Singleton @Provides fun pokemonRepository(implementation: PokemonRepositoryDefault): PokemonRepository = implementation
}
