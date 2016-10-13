package com.example.ivanz.androidunittestexample.data.api;

import android.os.Build;

import com.example.ivanz.androidunittestexample.BuildConfig;
import com.example.ivanz.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

/**
 * Created by ivanz on 13.10.2016.
 */

public class ApiManager {

    public static final String APP_ENGINE_BASE_URL = "localhost:8080";

    private static ApiManager sInstance;
    private MyApi appEngineApi;

    public static ApiManager get(){
        if (sInstance == null) {
            sInstance = new ApiManager();
        }
        return sInstance;
    }

    private ApiManager(){
    }

    public MyApi myApi() {
        if (appEngineApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), null)
                    .setApplicationName(BuildConfig.APPLICATION_NAME)
                    .setRootUrl(APP_ENGINE_BASE_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            appEngineApi = builder.build();
        }
        return appEngineApi;
    }
}
