package com.soin.pokemon.interactors;

import android.content.Context;
import android.util.Log;

import com.soin.pokemon.MainApplication;
import com.soin.pokemon.callbacks.PokemonSearchCallback;
import com.soin.pokemon.commons.Constants;
import com.soin.pokemon.exception.HttpNotFound;
import com.soin.pokemon.models.MPokemonSearch;
import com.soin.pokemon.services.ServiceGenerator;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Jesus Torres on 21/12/2016.
 */

public class PokemonsInteractor {

    MainApplication mPokemonApp;
    private static final String TAG = "PokemonsInteractor";

    public PokemonsInteractor(Context context) {
        this.mPokemonApp = MainApplication.get(context);
    }

    public void loadDataFromApi(final PokemonSearchCallback pokemonSearchCallback){
        Log.d(TAG,"loadDataFromApi");
        ServiceGenerator.getPokemonsService().searchPokemons(Constants.QUERY_PARAMETER)
                .subscribeOn(mPokemonApp.SubscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MPokemonSearch>() {
                    @Override
                    public void onCompleted() {
                        Log.d("Log","Complete");
                        Log.d(TAG,"oncompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        PokemonsInteractor.this.onError(e,pokemonSearchCallback);
                    }

                    @Override
                    public void onNext(MPokemonSearch mPokemonSearch) {
                        Log.d(TAG,"onNext");
                        PokemonsInteractor.this.onSuccess(mPokemonSearch,pokemonSearchCallback);
                    }
                });

    }

    private void onSuccess(MPokemonSearch pokemonsSearch, PokemonSearchCallback pokemonSearchCallback) {
        Log.d(TAG,"onSuccess");
        if (pokemonsSearch.getResults() != null) {
            if (pokemonsSearch.getResults().size() > 0) {
                pokemonSearchCallback.onResponse(pokemonsSearch.getResults());
            } else {
                pokemonSearchCallback.onPokemonNotFound();
            }
        } else {
            pokemonSearchCallback.onPokemonNotFound();
        }
    }

    private void onError(Throwable throwable, PokemonSearchCallback pokemonSearchCallback) {
        if (HttpNotFound.isHttp404(throwable)) {
            pokemonSearchCallback.onPokemonNotFound();
        } else if (throwable.getMessage().equals(HttpNotFound.SERVER_INTERNET_ERROR)) {
            pokemonSearchCallback.onNetworkConnectionError();
        } else {
            pokemonSearchCallback.onServerError();
        }
    }
}
