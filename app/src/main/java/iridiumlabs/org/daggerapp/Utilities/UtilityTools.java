package iridiumlabs.org.daggerapp.Utilities;

import android.support.annotation.Nullable;

import com.squareup.okhttp.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit.Response;
import rx.Observable;

/**
 * Created by John on 3/8/16.
 */
public class UtilityTools {

    private static UtilityTools instance;

    private UtilityTools(){}

    public static UtilityTools get(){
        if (instance == null){
            instance = new UtilityTools();
        }

        return instance;
    }

    public synchronized String getJson(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        StringBuilder sb = new StringBuilder();

        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * This method allows us to return a mocked response with retrofit
     * @param responseCode setting to null defualts to 200
     * @param json
     * @return
     */
    public Response createResponseWithCodeAndJson(@Nullable Integer responseCode, String json) {
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


    /**
     * returns an observable. should be used when testing mock Observables with retrofit
     * @param obj
     * @return
     */
    public Observable createMockedObervable(Object obj){
        return Observable.just(obj);
    }
}
