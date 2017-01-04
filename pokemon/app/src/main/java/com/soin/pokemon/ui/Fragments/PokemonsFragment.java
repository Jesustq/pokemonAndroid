package com.soin.pokemon.ui.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soin.pokemon.R;
import com.soin.pokemon.models.MPokemon;
import com.soin.pokemon.presenters.PokemonPresenter;
import com.soin.pokemon.ui.Adapters.PokemonAdapter;
import com.soin.pokemon.views.PokemonsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PokemonsFragment extends Fragment implements PokemonsView {

    @BindView(R.id.rv_pokemons)
    RecyclerView rv_pokemons;

    PokemonAdapter adapter;

    private static final String TAG = "PokemonsFragment";

    private PokemonPresenter pokemonPresenter;


    public PokemonsFragment() {
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemonPresenter = new PokemonPresenter();
        pokemonPresenter.setView(this);
        Log.d(TAG,"va a entrar a la busqueda");
        pokemonPresenter.onSearchPokemon();
        pokemonPresenter.onResultPokemon();
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                                 Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_pokemons, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Log.d(TAG,"onViewCreated");
        setupRecyclerView();
    }

    @Override public void onDestroy() {
        pokemonPresenter.detachView();
        super.onDestroy();
    }

    @Override public Context getContext() {
        return getActivity();
    }

    private void setupRecyclerView() {
        Log.d(TAG,"setupRecyclerView");
        adapter = new PokemonAdapter();
        adapter.setActivity(getActivity());
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        rv_pokemons.setLayoutManager(manager);
        rv_pokemons.setAdapter(adapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        rv_pokemons.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPokemonNotFoundMessage() {

    }

    @Override
    public void showConnectionErrorMessage() {

    }

    @Override
    public void showServerError() {

    }

    @Override
    public void renderPokemons(List<MPokemon> pokemons) {
        Log.d(TAG,"renderPokemons");
        adapter.setPokemons(pokemons);
        adapter.setActivity(getActivity());
        adapter.notifyDataSetChanged();
    }
}
