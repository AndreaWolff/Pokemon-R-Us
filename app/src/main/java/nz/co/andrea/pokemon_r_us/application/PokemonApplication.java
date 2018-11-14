package nz.co.andrea.pokemon_r_us.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import nz.co.andrea.pokemon_r_us.dagger.component.AppComponent;
import nz.co.andrea.pokemon_r_us.dagger.component.DaggerAppComponent;
import nz.co.andrea.pokemon_r_us.dagger.module.AppModule;
import nz.co.andrea.pokemon_r_us.dagger.module.NetModule;

public class PokemonApplication extends Application {

    private static PokemonApplication application;

    private AppComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();

        application = this;

        appComponent = createDaggerComponent();

        Stetho.initializeWithDefaults(this);
    }

    private AppComponent createDaggerComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://pokeapi.co/api/v2/"))
                .build();
    }

    public static AppComponent getDagger() {
        return application.appComponent;
    }
}
