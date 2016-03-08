package iridiumlabs.org.daggerapp;

import java.util.ArrayList;

import iridiumlabs.org.daggerapp.POJO.Person;
import retrofit.Call;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by John on 3/8/16.
 */
public interface NetApi {

    @GET("/person")
    Observable<ArrayList<Person>> getPeopleRx();

    @GET("person")
    Call<ArrayList<Person>> getPeopleCall();
}
