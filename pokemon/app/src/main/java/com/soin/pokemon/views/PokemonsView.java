package com.soin.pokemon.views;

import com.soin.pokemon.models.MPokemon;

import java.util.List;

/**
 * Created by Jesus Torres on 22/12/2016.
 */

public interface PokemonsView {

    void showLoading();

    void hideLoading();

    void showArtistNotFoundMessage();

    void showConnectionErrorMessage();

    void showServerError();

    void renderArtists(List<MPokemon> pokemons);
}
