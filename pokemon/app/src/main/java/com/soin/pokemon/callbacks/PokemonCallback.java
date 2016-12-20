package com.soin.pokemon.callbacks;

import com.soin.pokemon.models.MPokemon;

import java.util.List;

/**
 * Created by Chus on 19/12/2016.
 */

public interface PokemonCallback {

    void onResponse(List<MPokemon> pokemons);

    void onArtistNotFound();

    void onNetworkConnectionError();

    void onServerError();

}
