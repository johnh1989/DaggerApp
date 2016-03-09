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
import iridiumlabs.org.daggerapp.tdd.Dagger.BadResponseNetworkTestModule;
import iridiumlabs.org.daggerapp.tdd.Dagger.MainTestComponent;
import iridiumlabs.org.daggerapp.tdd.Dagger.MainTestModule;
import iridiumlabs.org.daggerapp.tdd.MockApp;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by doktor on 3/8/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    /**
     * This component allows us to @Inject dependencies into our test, like a mock object
     */
    @Singleton
    @Component(modules = {MainTestModule.class, BadResponseNetworkTestModule.class})
    public interface TestComponent extends MainTestComponent{
        void inject(MainActivityTest mainActivityTest);
    }

    TestComponent component;

    MockApp app;

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp(){

        /**
         * get an instance of the MockApplication class
         */
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        app = (MockApp) instrumentation.getTargetContext().getApplicationContext();

    }

    @Test
    public void test_error_response_from_server_displays_toast(){

        //swap our component out for one using the bad response module
        component = DaggerMainActivityTest_TestComponent.builder()
                .mainTestModule(new MainTestModule(app, MockApp.url))
                .badResponseNetworkTestModule(new BadResponseNetworkTestModule())
                .build();

        component.inject(this);

        MockApp.setComponent(component);

        rule.launchActivity(new Intent());

        onView(withText(R.string.api_404)).inRoot(Helpers.isToast()).check(matches(isDisplayed()));

        //this runs our Rx call. make sure the toast we expect to be displayed is displayed when the call fails
        onView(withId(R.id.fab)).perform(click());

        onView(withText(R.string.api_404)).inRoot(Helpers.isToast()).check(matches(isDisplayed()));
    }

    @Test
    public void test_good_response_from_server_updates_recyclerview(){
        //TODO
        Assert.assertTrue(1 == 1);
    }
}
