package iridiumlabs.org.daggerapp.Dagger;

import javax.inject.Singleton;

import dagger.Component;
import iridiumlabs.org.daggerapp.home.MainActivityPresenterImpl;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivityPresenterImpl mainActivityPresenterImpl);
}
