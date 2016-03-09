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

    /**
     * when we run the app as the tdd flavor, we want to build our component with legitimate mocks
     * This way, we can "test drive" the app, and never have to make a slow network request, DB query,
     * or any other long running operation. we can just return whatever data we want immediately.
     * View the {@link MainTestModule} and {@link NetworkTestModule} for details on how this works.
     * By providing our own implemention of the {@link iridiumlabs.org.daggerapp.Model.NetApi},
     * we can return data instantly and stay on the main thread for mock/testing purposes.
     * @return
     */
    @Override
    protected MainComponent initialize(){
        return DaggerMainTestComponent.builder()
                .mainTestModule(new MainTestModule(this, App.url))
                .networkTestModule(new NetworkTestModule())
                .build();
    }
}
