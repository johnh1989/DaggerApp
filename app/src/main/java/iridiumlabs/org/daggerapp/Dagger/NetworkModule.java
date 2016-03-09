package iridiumlabs.org.daggerapp.Dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iridiumlabs.org.daggerapp.NetApi;
import retrofit.Retrofit;

/**
 * Created by doktor on 3/8/2016.
 */
@Module
public class NetworkModule {

    @Singleton
    @Provides
    NetApi providesNetApi(Retrofit retrofit){
        return retrofit.create(NetApi.class);
    }
}
