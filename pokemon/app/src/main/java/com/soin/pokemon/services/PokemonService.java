package com.soin.pokemon.services;

import com.soin.pokemon.commons.Constants;
import com.soin.pokemon.models.MPokemonSearch;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Chus on 20/12/2016.
 */

public interface PokemonService {

    @GET(Constants.POKEMON_SEARCH)
    Observable<MPokemonSearch> searchPokemons(
            @Query(Constants.QUERY_SEARCH) String limit);

    @GET(Constants.POKEMON_DETAIL_SEARCH)
    Observable<MPokemonSearch> searchPokemon(
            @Path(Constants.POKEMON_PATH) String pokemonId);
}
