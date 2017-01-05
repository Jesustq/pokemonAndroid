package com.soin.pokemon.presenters;

import android.util.Log;

import com.soin.pokemon.MainApplication;
import com.soin.pokemon.callbacks.PokemonCallback;
import com.soin.pokemon.callbacks.PokemonSearchCallback;
import com.soin.pokemon.interactors.PokemonInteractor;
import com.soin.pokemon.interactors.PokemonsInteractor;
import com.soin.pokemon.models.MPokemon;
import com.soin.pokemon.models.MPokemonResult;
import com.soin.pokemon.services.PokemonService;
import com.soin.pokemon.views.PokemonsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chus on 26/12/2016.
 */

public class PokemonPresenter implements Presenter<PokemonsView>, PokemonCallback, PokemonSearchCallback {

    private PokemonsView pokemonsMvpView;
    private PokemonsInteractor pokemonsInteractor;
    private PokemonInteractor pokemonInteractor;
    private List<MPokemon> pokemonsList;
    private List<MPokemonResult> pokemonResults;
    private static final String TAG = "PokemonPresenter";


    public PokemonPresenter() {
        pokemonsList = new ArrayList<>();
        pokemonResults = new ArrayList<>();
    }

    @Override
    public void onResponse(MPokemon pokemon) {
        pokemonsList.add(pokemon);
    }

    @Override
    public void onResponse(List<MPokemonResult> pokemons) {
        //for (MPokemonResult result : pokemons) {
          //  pokemonInteractor.loadDataFromApi(result.getUrl(),this);
        //}
       // pokemonsMvpView.hideLoading();
       // pokemonsMvpView.renderPokemons(pokemonsList);
        Log.d(TAG,"onResponse" + pokemons);
        pokemonResults = pokemons;
        this.onResultPokemon();
    }

    public void onSearchPokemon() {
        pokemonsInteractor.loadDataFromApi(this);
    }

    public void onResultPokemon() {
        Log.d(TAG,"onResult" + pokemonResults);
        for (MPokemonResult result : pokemonResults) {
              pokemonInteractor.loadDataFromApi(result.getUrl(),this);
            }
             pokemonsMvpView.hideLoading();
             pokemonsMvpView.renderPokemons(pokemonsList);

    }

    @Override
    public void onPokemonNotFound() {
        pokemonsMvpView.showPokemonNotFoundMessage();
    }

    @Override
    public void onNetworkConnectionError() {
        pokemonsMvpView.showConnectionErrorMessage();
    }

    @Override
    public void onServerError() {
        pokemonsMvpView.showServerError();
    }

    @Override
    public void setView(PokemonsView view) {
        if (view == null) throw new IllegalArgumentException("You can't set a null view");

        pokemonsMvpView = view;
        pokemonsInteractor = new PokemonsInteractor(MainApplication.getContext());
        pokemonInteractor = new PokemonInteractor(MainApplication.getContext());
    }

    @Override
    public void detachView() {
        pokemonsMvpView = null;
    }
}
