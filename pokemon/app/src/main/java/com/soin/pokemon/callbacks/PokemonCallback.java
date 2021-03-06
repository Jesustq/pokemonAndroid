package com.soin.pokemon.callbacks;

import com.soin.pokemon.models.MPokemon;

import java.util.List;

/**
 * Created by Chus on 19/12/2016.
 */

public interface PokemonCallback {

    void onResponse(MPokemon pokemons);

    void onPokemonNotFound();

    void onNetworkConnectionError();

    void onServerError();

}
