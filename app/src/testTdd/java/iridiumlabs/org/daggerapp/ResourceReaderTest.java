package iridiumlabs.org.daggerapp;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import iridiumlabs.org.daggerapp.Utilities.ResourceReader;
import iridiumlabs.org.daggerapp.POJO.Person;
import iridiumlabs.org.daggerapp.tdd.MockApp;

/**
 * Created by doktor on 3/9/2016.
 */

/**
 * with roboelectric be sure to st teh manifests properly.
 * on windows i need to go into edit configurations of teh test, and change the working
 * directory to point to the app directory, or "module directory". this is slightly
 * different on mac.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(application = MockApp.class,
        constants = BuildConfig.class, sdk = 21,
        manifest = "src/tdd/AndroidManifest.xml"
)
public class ResourceReaderTest {
    
    @Test
    public void test_resource_reader_works(){

        ArrayList<Person> personList = null;

        personList =
                new Gson().fromJson(ResourceReader.get().getJson("persons_response.json"),
                        new TypeToken<List<Person>>(){}.getType());

        Assert.assertTrue(personList != null);
        Assert.assertTrue(!personList.isEmpty());
        Assert.assertTrue(personList.size() == 2);
        Assert.assertEquals(3, personList.get(0).getId().intValue());
        Assert.assertEquals(4, personList.get(1).getId().intValue());

    }
}
