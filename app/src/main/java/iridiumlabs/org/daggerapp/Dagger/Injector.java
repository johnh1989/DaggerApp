package iridiumlabs.org.daggerapp.Dagger;

import iridiumlabs.org.daggerapp.home.MainActivityPresenterImpl;
import iridiumlabs.org.daggerapp.home.MainRecyclerAdapter;

/**
 * Handles all of the code for calling inject on the component(s)
 */
public class Injector {

    private static Injector instance;

    private MainComponent mainComponent;

    public Injector(MainComponent mainComponent){
        this.mainComponent = mainComponent;
    }

    public static Injector get(MainComponent mainComponent){
        if (instance == null){
            instance = new Injector(mainComponent);
        }

        return instance;
    }

    public void inject(MainActivityPresenterImpl mainActivityPresenterImpl){
        mainComponent.inject(mainActivityPresenterImpl);
    }

    public void inject(MainRecyclerAdapter mainRecyclerAdapter){
        mainComponent.inject(mainRecyclerAdapter);
    }
}
