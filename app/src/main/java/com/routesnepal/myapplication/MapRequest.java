package com.routesnepal.myapplication;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.params.BasicHttpParams;

/**
 * Created by bhuwan on 10/17/2017.
 */

public class MapRequest {

    static AsyncHttpClient client;
    static  {
        client = new AsyncHttpClient();
    }

    private static final String BASE_URL = "http://192.168.2.103:8080/SpringMvcUser";

    private static final String CREATE_NEW = "/api/androidpost";
    private static final String GET = "/api/androidget";

    public static void addLocation(LatLng location, String title, ResponseHandlerInterface handler) {
        RequestParams params = new RequestParams();
        params.put("latitude", location.latitude);
        params.put("longitude", location.longitude);
        params.put("title", title);

        client.post(BASE_URL + CREATE_NEW, params, handler);
    }

    public static void get(ResponseHandlerInterface handler) {
        client.get(BASE_URL + GET, handler);

    }

}
