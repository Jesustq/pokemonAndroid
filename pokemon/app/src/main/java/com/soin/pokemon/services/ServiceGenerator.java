package com.soin.pokemon.services;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.soin.pokemon.commons.Constants.POKEMON_API;

/**
 * Created by Chus on 20/12/2016.
 */

public class ServiceGenerator {

    static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
// set your desired log level


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS).addInterceptor(logging);



    private static Retrofit.Builder RETROFIT =
            new Retrofit.Builder()
                    .baseUrl(POKEMON_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            ;

    public static  <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = RETROFIT.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    private static final PokemonService USER_SERVICE = createService(PokemonService.class);

    public static PokemonService getPokemonsService() {
        return USER_SERVICE;
    }
}
