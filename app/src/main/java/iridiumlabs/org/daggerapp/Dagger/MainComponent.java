package iridiumlabs.org.daggerapp.Dagger;

import javax.inject.Singleton;

import dagger.Component;
import iridiumlabs.org.daggerapp.MVP.home.MainActivityPresenterImpl;
import iridiumlabs.org.daggerapp.MVP.home.MainRecyclerAdapter;

@Singleton
@Component(modules = {MainModule.class, NetworkModule.class})
public interface MainComponent {
    void inject(MainActivityPresenterImpl mainActivityPresenterImpl);
    void inject(MainRecyclerAdapter mainRecyclerAdapter);
}
