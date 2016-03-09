package iridiumlabs.org.daggerapp.tdd.Dagger;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iridiumlabs.org.daggerapp.RetrofitLogger;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by John on 3/8/16.
 */
@Module
@Singleton
public class MainTestModule {

    Application application;

    String url;

    public MainTestModule(Application application, String url){
        this.application = application;
        this.url = url;
    }

    @Provides
    @Singleton
    Application proviesApplication(){
        return application;
    }


    @Provides
    @Singleton
    Gson providesGson(){
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }


    @Provides
    @Singleton
    OkHttpClient providesStethoOkHttpClient(){
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new RetrofitLogger());
        return client;

    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(url)
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    Picasso providesPicasso(Application application){
        return Picasso.with(application);
    }
}
