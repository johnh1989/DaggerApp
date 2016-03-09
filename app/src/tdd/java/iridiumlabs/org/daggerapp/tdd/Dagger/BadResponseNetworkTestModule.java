package iridiumlabs.org.daggerapp.tdd.Dagger;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iridiumlabs.org.daggerapp.Model.NetApi;
import iridiumlabs.org.daggerapp.POJO.Person;
import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.mock.Calls;
import rx.Observable;

/**
 * Created by doktor on 3/8/2016.
 */
@Module
public class BadResponseNetworkTestModule {

    @Singleton
    @Provides
    NetApi providesNetApi(final Retrofit retrofit){
        return new NetApi() {
            @Override
            public Observable<ArrayList<Person>> getPeopleRx() {
                ArrayList<Person> personList = new ArrayList<>();
                //TODO make this a 404
                return Observable.just(personList);
            }

            @Override
            public Call<ArrayList<Person>> getPeopleCall() {
                Response response = Response.error(404, ResponseBody.create(MediaType.parse("application/json"), ""));
                return Calls.response(response, retrofit);
            }
        };
    }
}
