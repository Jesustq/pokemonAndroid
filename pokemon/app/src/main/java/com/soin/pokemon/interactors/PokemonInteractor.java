package com.soin.pokemon.interactors;

import android.content.Context;
import android.util.Log;

import com.soin.pokemon.MainApplication;
import com.soin.pokemon.callbacks.PokemonCallback;
import com.soin.pokemon.callbacks.PokemonSearchCallback;
import com.soin.pokemon.commons.Constants;
import com.soin.pokemon.exception.HttpNotFound;
import com.soin.pokemon.models.MPokemon;
import com.soin.pokemon.models.MPokemonSearch;
import com.soin.pokemon.services.ServiceGenerator;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Chus on 26/12/2016.
 */

public class PokemonInteractor {

    MainApplication mPokemonApp;
    private static final String TAG = "PokemonInteractor";


    public PokemonInteractor(Context context) {
        this.mPokemonApp = MainApplication.get(context);
    }

    public void loadDataFromApi(String pokemonId , final PokemonCallback pokemonCallback){

        String pokeId = pokemonId.substring(Integer.parseInt(Constants.POKEMON_OFFSET),pokemonId.length()-1);
        Log.d(TAG, "url: "+ pokemonId);
        Log.d(TAG,"pokeId: "+ pokeId);

        ServiceGenerator.getPokemonsService().searchPokemon(pokeId)
                .subscribeOn(mPokemonApp.SubscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MPokemon>() {
                    @Override
                    public void onCompleted() {
                        Log.d("Log","Complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        PokemonInteractor.this.onError(e,pokemonCallback);
                    }

                    @Override
                    public void onNext(MPokemon mPokemon) {
                        Log.d(TAG,"onNext");
                        PokemonInteractor.this.onSuccess(mPokemon,pokemonCallback);
                    }
                });

    }

    private void onSuccess(MPokemon pokemon, PokemonCallback pokemonCallback) {
        if (pokemon.getId() != null) {
            if (Integer.parseInt(pokemon.getId()) > 0) {
                pokemonCallback.onResponse(pokemon);
            } else {
                pokemonCallback.onPokemonNotFound();
            }
        } else {
            pokemonCallback.onPokemonNotFound();
        }
    }

    private void onError(Throwable throwable, PokemonCallback pokemonSearchCallback) {
        if (HttpNotFound.isHttp404(throwable)) {
            pokemonSearchCallback.onPokemonNotFound();
        } else if (throwable.getMessage().equals(HttpNotFound.SERVER_INTERNET_ERROR)) {
            pokemonSearchCallback.onNetworkConnectionError();
        } else {
            pokemonSearchCallback.onServerError();
        }
    }
}
