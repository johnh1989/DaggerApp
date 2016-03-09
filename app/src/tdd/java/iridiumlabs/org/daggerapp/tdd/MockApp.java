package iridiumlabs.org.daggerapp.tdd;

import iridiumlabs.org.daggerapp.App;
import iridiumlabs.org.daggerapp.Dagger.MainComponent;
import iridiumlabs.org.daggerapp.tdd.Dagger.DaggerMainTestComponent;
import iridiumlabs.org.daggerapp.tdd.Dagger.MainTestModule;
import iridiumlabs.org.daggerapp.tdd.Dagger.NetworkTestModule;


/**
 * There are many ways to set up your DI.
 * I prefer the use of an Injector class which handles calling compoent.inject() methods
 * But all of this could could be handled in here as well through static methods. There are a million
 * examples on github, so pick one and enjoy it :)
 */
public class MockApp extends App {

    @Override
    protected MainComponent initialize(){
        return DaggerMainTestComponent.builder()
                .mainTestModule(new MainTestModule(this, App.url))
                .networkTestModule(new NetworkTestModule())
                .build();
    }
}
