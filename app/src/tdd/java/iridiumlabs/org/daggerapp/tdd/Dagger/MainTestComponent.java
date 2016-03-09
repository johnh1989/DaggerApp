package iridiumlabs.org.daggerapp.tdd.Dagger;

import javax.inject.Singleton;

import dagger.Component;
import iridiumlabs.org.daggerapp.Dagger.MainComponent;

@Singleton
@Component(modules = {MainTestModule.class, NetworkTestModule.class})
public interface MainTestComponent extends MainComponent {

}
