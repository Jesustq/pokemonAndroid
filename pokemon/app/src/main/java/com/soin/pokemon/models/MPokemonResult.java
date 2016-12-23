package com.soin.pokemon.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Jesus Torres on 21/12/2016.
 */

@Parcel(Parcel.Serialization.BEAN)
public class MPokemonResult {

    @SerializedName("name") private String name;

    @SerializedName("url") private String url;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }
}
