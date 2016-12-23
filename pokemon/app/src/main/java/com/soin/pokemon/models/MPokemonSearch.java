package com.soin.pokemon.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Jesus Torres on 21/12/2016.
 */

@Parcel(Parcel.Serialization.BEAN)
public class MPokemonSearch {

    @SerializedName("results") private List<MPokemonResult> results;

    public List<MPokemonResult> getResults() {
        return results;
    }

    public void setResults(List<MPokemonResult> results) {
        this.results = results;
    }
}
