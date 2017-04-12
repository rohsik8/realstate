package com.rg.realstate.ApiController;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by kishor on 02/04/17.
 */

public class RestServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    public RestServiceGenerator() {


    }

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())     //toget json response
            .addConverterFactory(ScalarsConverterFactory.create()) ;  //toget string response
//            .addConverterFactory(SimpleXmlConverterFactory.create()); //toget xml response


    public static <S> S createService(Class<S> serviceClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit retrofit = builder
                .client(httpClient
                        .addInterceptor(interceptor)
                        .connectTimeout(ApiConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(ApiConfig.READ_TIMEOUT, TimeUnit.SECONDS)
                        .build())

                .build();
        return retrofit.create(serviceClass);
    }



    public static OkHttpClient.Builder getHttpClient() {
        return httpClient;
    }
}
