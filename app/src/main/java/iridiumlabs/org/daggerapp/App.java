package iridiumlabs.org.daggerapp;

import android.app.Application;

import iridiumlabs.org.daggerapp.Dagger.DaggerMainComponent;
import iridiumlabs.org.daggerapp.Dagger.Injector;
import iridiumlabs.org.daggerapp.Dagger.MainComponent;
import iridiumlabs.org.daggerapp.Dagger.MainModule;
import iridiumlabs.org.daggerapp.Dagger.NetworkModule;


/**
 * There are many ways to set up your DI.
 * I prefer the use of an Injector class which handles calling compoent.inject() methods
 * But all of this could could be handled in here as well through static methods. There are a million
 * examples on github, so pick one and enjoy it :)
 */
public class App extends Application {

    private String url = "http://69.119.215.250:3000/";

    private static MainComponent mainComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = initialize();
    }

    protected MainComponent initialize(){
        return DaggerMainComponent.builder()
                .mainModule(new MainModule(this, url))
                .networkModule(new NetworkModule())
                .build();
    }

    public static Injector getInjector() {
        return Injector.get(mainComponent);
    }

}
