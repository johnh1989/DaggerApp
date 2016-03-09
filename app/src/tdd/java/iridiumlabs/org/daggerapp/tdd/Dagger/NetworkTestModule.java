package iridiumlabs.org.daggerapp.tdd.Dagger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iridiumlabs.org.daggerapp.Helpers.ResourceReader;
import iridiumlabs.org.daggerapp.Model.NetApi;
import iridiumlabs.org.daggerapp.POJO.Person;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.mock.Calls;
import rx.Observable;

/**
 * Created by doktor on 3/8/2016.
 */
@Module
public class NetworkTestModule {

    @Singleton
    @Provides
    NetApi providesNetApi(final Retrofit retrofit){
        return new NetApi() {
            @Override
            public Observable<ArrayList<Person>> getPeopleRx() {
                ArrayList<Person> personList =
                        new Gson().fromJson(ResourceReader.get().getJson("persons_response.json"),
                        new TypeToken<List<Person>>(){}.getType()
                        );

                return Observable.just(personList);
            }

            @Override
            public Call<ArrayList<Person>> getPeopleCall() {
                ArrayList<Person> personList =
                        new Gson().fromJson(ResourceReader.get().getJson("persons_response.json"),
                                new TypeToken<List<Person>>(){}.getType()
                        );

                return Calls.response(personList, retrofit);
            }
        };
    }
}
