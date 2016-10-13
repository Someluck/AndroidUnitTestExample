/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.ivanz.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import by.someluck.HttpClient;


/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.ivanz.example.com",
                ownerName = "backend.myapplication.ivanz.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    public static final String FOOTBALL_DATA ="http://api.football-data.org/v1/competitions/?season=2016";

    @ApiMethod(name = "getFootballData")
    public MyBean getFootballData(){
        MyBean response = new MyBean();
        String data = HttpClient.get(FOOTBALL_DATA);
        response.setData(data);
        return response;
    }

}
