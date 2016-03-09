package iridiumlabs.org.daggerapp.tdd.Dagger;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
                ArrayList<Person> personList = new ArrayList<>();
                return Observable.just(personList);
            }

            @Override
            public Call<ArrayList<Person>> getPeopleCall() {
                return Calls.response(new ArrayList<Person>(), retrofit);
            }
        };
    }
}
