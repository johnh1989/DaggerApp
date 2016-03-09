package iridiumlabs.org.daggerapp;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Singleton;

import dagger.Component;
import iridiumlabs.org.daggerapp.MVP.home.MainActivity;
import iridiumlabs.org.daggerapp.tdd.Dagger.MainTestComponent;
import iridiumlabs.org.daggerapp.tdd.Dagger.MainTestModule;
import iridiumlabs.org.daggerapp.tdd.Dagger.NetworkTestModule;
import iridiumlabs.org.daggerapp.tdd.MockApp;

/**
 * Created by doktor on 3/8/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    /**
     * This component allows us to @Inject dependencies into our test, like a mock object
     */
    @Singleton
    @Component
    public interface TestComponent extends MainTestComponent{
        void inject(MainActivityTest mainActivityTest);
    }

    TestComponent component;

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){

        /**
         * get an instance of the MockApplication class
         */
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MockApp app = (MockApp) instrumentation.getTargetContext().getApplicationContext();

        component = DaggerMainActivityTest_TestComponent.builder()
                .mainTestModule(new MainTestModule(app, MockApp.url))
                .networkTestModule(new NetworkTestModule())
                .build();

        component.inject(this);

        MockApp.setComponent(component);
    }

    @Test
    public void testActivityLaunch(){
        rule.launchActivity(new Intent());
        Assert.assertTrue(1==1);
    }
}
