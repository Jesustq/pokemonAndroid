package com.soin.pokemon.callbacks;

import com.soin.pokemon.models.MPokemon;
import com.soin.pokemon.models.MPokemonResult;

import java.util.List;

/**
 * Created by Chus on 26/12/2016.
 */

public interface PokemonSearchCallback {

    void onResponse(List<MPokemonResult> pokemons);

    void onPokemonNotFound();

    void onNetworkConnectionError();

    void onServerError();
}
