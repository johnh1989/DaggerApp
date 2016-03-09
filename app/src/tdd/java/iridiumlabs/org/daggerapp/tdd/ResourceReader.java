package iridiumlabs.org.daggerapp.tdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by doktor on 3/8/2016.
 */
public final class ResourceReader {

    private static ResourceReader instance;

    private ResourceReader(){}

    public ResourceReader get(){
        if (instance == null){
            instance = new ResourceReader();
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
}