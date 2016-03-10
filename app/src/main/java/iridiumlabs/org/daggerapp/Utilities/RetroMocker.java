package iridiumlabs.org.daggerapp.Utilities;

import android.support.annotation.Nullable;

import com.squareup.okhttp.Protocol;

import retrofit.Response;
import rx.Observable;

/**
 * Created by doktor on 3/10/2016.
 */
public final class RetroMocker {
    /**
     * This method allows us to return a mocked response with retrofit
     * @param responseCode setting to null defualts to 200
     * @param json
     * @return
     */
    public static Response createResponseWithCodeAndJson(@Nullable Integer responseCode, String json) {
        if (responseCode == null){
            responseCode = 200;
        }
        return Response.success(json,
                new com.squareup.okhttp.Response.Builder()
                        .code(responseCode)
                        .request(new com.squareup.okhttp.Request.Builder()
                                .url("http://localhost")
                                .delete()
                                .method("more", null)
                                .build())
                        .protocol(Protocol.HTTP_1_1)
                        .build());
    }

    public static <T> Observable<T> createMockedObervable(T obj){
        return Observable.just(obj);
    }
}

